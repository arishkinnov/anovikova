package ru.anovikova.lesson43.model;

public class BookStatistic {
  private final Book book;
  private final int quantityReaders;

  public BookStatistic(Book book, int quantityReaders) {
    this.book = book;
    this.quantityReaders = quantityReaders;
  }

  public Book getBook() {
    return book;
  }

  public int getQuantityReaders() {
    return quantityReaders;
  }

  @Override
  public String toString() {
    return "BookStatistic{" +
        "book=" + book +
        ", quantityReaders=" + quantityReaders +
        '}';
  }
}
