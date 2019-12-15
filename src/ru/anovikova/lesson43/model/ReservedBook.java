package ru.anovikova.lesson43.model;

public class ReservedBook {
  private Book book;
  private Reader reader;
  private int quantity;

  public ReservedBook(Book book, Reader reader) {
    this.book = book;
    this.reader = reader;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Reader getReader() {
    return reader;
  }

  public void setReader(Reader reader) {
    this.reader = reader;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "ReservedBook{" +
        "book=" + book +
        ", reader=" + reader +
        '}';
  }
}
