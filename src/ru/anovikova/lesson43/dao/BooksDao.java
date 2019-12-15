package ru.anovikova.lesson43.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ru.anovikova.lesson43.connector.MysqlConnector;
import ru.anovikova.lesson43.model.Author;
import ru.anovikova.lesson43.model.Book;
import ru.anovikova.lesson43.model.BookStatistic;
import ru.anovikova.lesson43.model.Reader;
import ru.anovikova.lesson43.model.ReservedBook;

public class BooksDao implements AutoCloseable {

  private final Connection connection;

  public BooksDao() {
    connection = MysqlConnector.getConnection();
  }

  public List<Book> getFreeBooks() throws SQLException {
    Statement stmt = connection.createStatement();
    String query = "select *, "
        + "   group_concat(a.last_name) as authors_last_names, "
        + "   sum(tb.quantity) as taken "
        + "from library.books b "
        + "inner join library.book_authors ba using (books_id) "
        + "left join library.authors a using (authors_id) "
        + "left join library.taken_books tb using (books_id) "
        + "group by b.books_id, tb.books_id "
        + "order by authors_last_names";
    ResultSet resultSet = stmt.executeQuery(query);
    List<Book> response = new ArrayList<>();
    while (resultSet.next()) {
      Book book = prepareBook(resultSet);
      book.setQuantity(book.getQuantity() - resultSet.getInt("taken"));
      response.add(book);
    }
    return response;
  }

  private Book prepareBook(ResultSet resultSet) throws SQLException {
    Book book = new Book();
    book.setBookId(resultSet.getInt("books_id"));
    book.setTitle(resultSet.getString("title"));
    book.setDescription(resultSet.getString("description"));
    book.setQuantity(resultSet.getInt("quantity"));
    book.setAuthors(getAuthors(book.getBookId()));
    return book;
  }

  private List<Author> getAuthors(Integer bookId) throws SQLException {
    String query = "select * from library.book_authors ba "
        + "left join library.authors a using (authors_id) "
        + "where ba.books_id = ?";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setInt(1, bookId);
    ResultSet resultSet = stmt.executeQuery();
    List<Author> response = new ArrayList<>();
    while (resultSet.next()) {
      Author author = prepareAuthor(resultSet);
      response.add(author);
    }
    return response;
  }

  private Author prepareAuthor(ResultSet resultSet) throws SQLException {
    Author author = new Author();
    author.setAuthorId(resultSet.getInt("authors_id"));
    author.setName(resultSet.getString("name"));
    author.setLastName(resultSet.getString("last_name"));
    return author;
  }

  public List<BookStatistic> searchBooksByTitle(String title) throws SQLException {
    String query = "select *, sum(tb.quantity) as reserved_quantity "
        + "from library.books b "
        + "left join library.taken_books tb using (books_id) "
        + "where title like ? "
        + "group by b.books_id ";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setNString(1, "%" + title + "%");
    ResultSet resultSet = stmt.executeQuery();
    List<BookStatistic> response = new ArrayList<>();
    while (resultSet.next()) {
      Book book = prepareBook(resultSet);
      int takenQuantity = resultSet.getInt("reserved_quantity");
      BookStatistic bookStatistic = new BookStatistic(book, takenQuantity);
      response.add(bookStatistic);
    }
    return response;
  }

  public List<BookStatistic> getFreeBooksByAuthor(String authorQuery) throws SQLException {
    Author author = getAuthor(authorQuery);

    String query = "select *, sum(tb.quantity) as reserved_quantity "
        + "from library.books b "
        + "left join library.book_authors ba using (books_id) "
        + "left join library.taken_books tb using (books_id) "
        + "where ba.authors_id = ? "
        + "group by b.books_id ";
    if (author != null) {
      PreparedStatement stmt = connection.prepareStatement(query);
      stmt.setInt(1, author.getAuthorId());
      ResultSet resultSet = stmt.executeQuery();
      List<BookStatistic> response = new ArrayList<>();
      while (resultSet.next()) {
        Book book = prepareBook(resultSet);
        int takenQuantity = resultSet.getInt("reserved_quantity");
        BookStatistic bookStatistic = new BookStatistic(book, takenQuantity);
        response.add(bookStatistic);
      }
      return response;
    }

    throw new IllegalStateException(
      String.format("Can't found author %s", authorQuery)
    );
  }

  private Author getAuthor (String author) throws SQLException {
    String query = "select * from library.authors "
        + "where last_name like ?";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setString(1, "%" + author + "%");
    ResultSet resultSet = stmt.executeQuery();
    if (resultSet.next()) {
      return prepareAuthor(resultSet);
    }
    return null;
  }

  public List<ReservedBook> getReservedBooks() throws SQLException {
    Statement stmt = connection.createStatement();
    String query = "select * from library.taken_books tb "
        + "left join library.readers r using (readers_id) "
        + "left join library.books b using (books_id)";
    ResultSet resultSet = stmt.executeQuery(query);
    List<ReservedBook> response = new ArrayList<>();
    while (resultSet.next()) {
      Book book = prepareBook(resultSet);
      Reader reader = prepareReader(resultSet);
      ReservedBook reservedBook = new ReservedBook(book, reader);
      response.add(reservedBook);
    }
    return response;
  }

  public List<ReservedBook> getTackenBooks(int readerId) throws SQLException {
    String query = "select * from library.taken_books tb "
        + "left join library.readers r using (readers_id) "
        + "left join library.books b using (books_id) "
        + "where tb.readers_id = ?";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setInt(1, readerId);
    ResultSet resultSet = stmt.executeQuery();
    List<ReservedBook> response = new ArrayList<>();
    while (resultSet.next()) {
      Book book = prepareBook(resultSet);
      Reader reader = prepareReader(resultSet);
      ReservedBook reservedBook = new ReservedBook(book, reader);
      reservedBook.setQuantity(resultSet.getInt("quantity"));
      response.add(reservedBook);
    }
    return response;
  }

  private Reader prepareReader(ResultSet resultSet) throws SQLException {
      Reader reader = new Reader();
      reader.setReaderId(resultSet.getInt("readers_id"));
      reader.setName(resultSet.getString("name"));
      reader.setLastName(resultSet.getString("last_name"));
      return reader;
  }

  public List<BookStatistic> getBooksStatistics () throws SQLException {
    Statement stmt = connection.createStatement();
    String query = "select *, sum(tb.quantity) as reserved_quantity "
        + "from library.books b "
        + "left join library.book_authors ba using (books_id) "
        + "left join library.taken_books tb using (books_id) "
        + "group by b.books_id";
    ResultSet resultSet = stmt.executeQuery(query);
    List<BookStatistic> response = new ArrayList<>();
    while (resultSet.next()) {
      Book book = prepareBook(resultSet);
      int takenQuantity = resultSet.getInt("reserved_quantity");
      BookStatistic bookStatistic = new BookStatistic(book, takenQuantity);
      response.add(bookStatistic);
    }
    return response;
  }

  @Override
  public void close() throws Exception {
    connection.close();
  }
}
