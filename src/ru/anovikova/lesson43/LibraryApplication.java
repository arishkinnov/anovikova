package ru.anovikova.lesson43;

import ru.anovikova.lesson43.dao.BooksDao;
import ru.anovikova.lesson43.dao.ReadersDao;
import ru.anovikova.lesson43.service.LibraryService;

public class LibraryApplication {

  public static void main(String[] args) {
    LibraryService service = new LibraryService(
        new BooksDao(),
        new ReadersDao()
    );

    service.start();
  }

}
