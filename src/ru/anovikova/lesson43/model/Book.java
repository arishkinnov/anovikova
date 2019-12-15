package ru.anovikova.lesson43.model;

import java.util.List;

public class Book {

  private int bookId;
  private List<Author> authors;
  private String title;
  private String description;
  private int quantity;

  public List<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(List<Author> authors) {
    this.authors = authors;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Book{" +
        "bookId=" + bookId +
        ", authors=" + authors +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", quantity=" + quantity +
        '}';
  }
}
