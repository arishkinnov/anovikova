package ru.anovikova.lesson43.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import ru.anovikova.lesson43.connector.MysqlConnector;
import ru.anovikova.lesson43.exceptions.ReaderNotFoundException;
import ru.anovikova.lesson43.model.ActionResult;
import ru.anovikova.lesson43.model.Reader;
import ru.anovikova.lesson43.model.ReservedBook;

public class ReadersDao implements AutoCloseable {

  private final Connection connection;

  public ReadersDao() {
    this.connection = MysqlConnector.getConnection();
  }

  public Reader register(Reader reader) throws SQLException {
    String query = "insert into library.readers (name, last_name, username) values (?, ?, ?)";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setString(1, reader.getName());
    stmt.setString(2, reader.getLastName());
    stmt.setString(3, reader.getUsername());
    reader.setReaderId(stmt.executeUpdate());

    return reader;
  }

  public Reader auth(Reader reader) throws SQLException {
    String query = "select * from library.readers "
        + "where username = ?";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setString(1, reader.getUsername());
    ResultSet resultSet = stmt.executeQuery();
    if (resultSet.next()) {
      reader.setLastName(resultSet.getString("last_name"));
      reader.setName(resultSet.getString("name"));
      reader.setReaderId(resultSet.getInt("readers_id"));
      return reader;
    } else {
      throw new ReaderNotFoundException();
    }
  }

  public ActionResult reserve(int reviewerId, int bookId, int quantity) throws SQLException {
    String querySelect = "select *, "
        + "   sum(tb.quantity) as taken "
        + "from library.books b "
        + "left join library.taken_books tb using (books_id) "
        + "where b.books_id = ? "
        + "group by tb.books_id ";
    PreparedStatement stmt = connection.prepareStatement(querySelect);
    stmt.setInt(1, bookId);
    ResultSet resultSet = stmt.executeQuery();

    if (resultSet.next()) {
      int freeBooks = resultSet.getInt("quantity") - resultSet.getInt("taken");
      if (freeBooks - quantity < 0) {
        return new ActionResult(
            String.format("'%s' осталось %s шт., невозможно выдать %s шт.", resultSet.getString("title"), freeBooks, quantity),
            false);
      }
      String query = "insert into library.taken_books (readers_id, books_id, quantity) "
          + "values (?, ?, ?) "
          + "on duplicate key update quantity = quantity + ?";
      stmt = connection.prepareStatement(query);
      stmt.setInt(1, reviewerId);
      stmt.setInt(2, bookId);
      stmt.setInt(3, quantity);
      stmt.setInt(4, quantity);
      stmt.executeUpdate();
      return new ActionResult("", true);
    } else {
      return new ActionResult("Вы не можете взять книгу с идентификатором " + bookId
          + ", потому что такого идентификатора не числится в базе библиотеку", false);
    }
  }

  public ActionResult unReserve(int reviewerId, int bookId, int quantity) throws SQLException {
    String querySelect = "select * from library.taken_books "
        + "where books_id = ? and readers_id = ?";
    PreparedStatement stmt = connection.prepareStatement(querySelect);
    stmt.setInt(1, bookId);
    stmt.setInt(2, reviewerId);
    ResultSet resultSet = stmt.executeQuery();

    if (resultSet.next()) {
      int currentQuantity = resultSet.getInt("quantity");

      if (currentQuantity - quantity < 0) {
        return new ActionResult(
            String.format("У вас числится только %s шт., вы не можете отдать %s шт.",currentQuantity, quantity), false);
      }

      if (currentQuantity - quantity > 1) {
        String queryUpdate = "update library.taken_books "
            + "set quantity = quantity - ? "
            + "where books_id = ? and readers_id = ?";
        stmt = connection.prepareStatement(queryUpdate);
        stmt.setInt(1, quantity);
        stmt.setInt(2, bookId);
        stmt.setInt(3, reviewerId);
        stmt.executeUpdate();
      } else {
        String queryDelete = "delete from library.taken_books "
            + "where books_id = ? and readers_id = ?";
        stmt = connection.prepareStatement(queryDelete);
        stmt.setInt(1, bookId);
        stmt.setInt(2, reviewerId);
        stmt.executeUpdate();
      }
      return new ActionResult("", true);
    }
    return new ActionResult(
        String.format("У вас не числится книга '%s', вы не можете отдать %s шт.", bookId, quantity), false);
  }

  @Override
  public void close() throws Exception {
    connection.close();
  }
}
