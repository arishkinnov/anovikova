package ru.anovikova.lesson43.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import ru.anovikova.lesson43.actions.Action;
import ru.anovikova.lesson43.actions.Actions;
import ru.anovikova.lesson43.actions.AuthorizeActions;
import ru.anovikova.lesson43.actions.LibraryActions;
import ru.anovikova.lesson43.actions.ReaderActions;
import ru.anovikova.lesson43.actions.SearchActions;
import ru.anovikova.lesson43.dao.BooksDao;
import ru.anovikova.lesson43.dao.ReadersDao;
import ru.anovikova.lesson43.exceptions.ReaderNotFoundException;
import ru.anovikova.lesson43.model.ActionResult;
import ru.anovikova.lesson43.model.Author;
import ru.anovikova.lesson43.model.Book;
import ru.anovikova.lesson43.model.BookStatistic;
import ru.anovikova.lesson43.model.Reader;
import ru.anovikova.lesson43.model.ReservedBook;

public class LibraryService {
  private static final String askFormat       = "|| %-35s :";
  private static final String messageFormat   = "|| %-151s ||";
  private static final String tableFormat     = "%-151s";
  private static final String actionFormat    = "%-35s : %-36s";
  private static final String bookFormat      = "| %-5s| %-45s| %-30s| %-40s| %-20s|";
  private static final String statBookFormat  = "| %-5s| %-55s| %-35s| %-15s| %-14s| %-14s|";

  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_BLUE = "\u001B[34m";
  private static final String ANSI_PURPLE = "\u001B[35m";
  private static final String ANSI_CYAN = "\u001B[36m";

  private static final Logger logger = Logger.getLogger(LibraryService.class);

  private final BooksDao booksDao;
  private final ReadersDao readersDao;
  private Reader reader = new Reader();
  private boolean running = false;

  public LibraryService(BooksDao booksDao, ReadersDao readersDao) {
    this.booksDao = booksDao;
    this.readersDao = readersDao;
  }

  public void start() {
    try {
      running = true;
      Scanner sc = new Scanner(System.in);
      authorize(sc);
      while (isRunning()) {
        getAction(sc);
      }
    } catch (Exception e) {
      logger.error("Some problem: ", e);
    }
  }

  private void getAction(Scanner sc) {
    Action action = Actions.QUIT;
    try {
      sayAvailableActions(action);
      Actions pickedAction = Actions.valueOfCode(
          ask("Выберете действие [" + Actions.getGroupedCodes() + "]", sc)
      );
      shortDelimiter(ANSI_GREEN);
      say("Выбранное действие: " + pickedAction.getDescription(), ANSI_GREEN);
      switch (pickedAction) {
        case QUIT: quit();
        case CABINET:
          cabinet(sc);
          break;
        case BOOK_OPERATIONS:
          booksOperations(sc);
          break;
      }
    } catch (IllegalArgumentException e) {
      sayBadAction();
      getAction(sc);
    }
  }

  private void booksOperations(Scanner sc) {
    Action action = ReaderActions.QUIT;
    try {
      sayAvailableActions(action);
      ReaderActions pickedAction = ReaderActions.valueOfCode(
          ask("Выберете действие [" + ReaderActions.getGroupedCodes() + "]", sc)
      );
      shortDelimiter(ANSI_GREEN);
      say("Выбранное действие: " + pickedAction.getDescription(), ANSI_GREEN);
      switch (pickedAction) {
        case QUIT: quit();
        case SHOW_TAKEN_BOOKS:
          showTakenBooks();
          break;
        case TAKE_BOOK:
          takeBook(sc);
          break;
        case RETURN_BOOK:
          returnBook(sc);
          break;
      }
      say("Действие завершено: " + pickedAction.getDescription(), ANSI_GREEN);
      delimiter(ANSI_GREEN);
    } catch (IllegalArgumentException e) {
      sayBadAction();
      getAction(sc);
    }
  }

  private void returnBook(Scanner sc) {
    try {
      String bookId = ask("Введите идентификатор книги", sc);
      String quantity = ask("Введите количество", sc);
      ActionResult actionResult = readersDao
          .unReserve(reader.getReaderId(), Integer.parseInt(bookId), Integer.parseInt(quantity));

      if (!actionResult.isStatus()) {
        say(actionResult.getMessage(), ANSI_RED);
      }
    } catch (Exception e) {
      logger.error("Что-то пошло не так во время возвращения книги ", e);
    }
  }

  private void showTakenBooks() {
    try {
      List<ReservedBook> takenBooks = booksDao.getTackenBooks(reader.getReaderId());
      sayTable(repeat("-", 151), ANSI_GREEN);
      sayTable(String.format(bookFormat,
          "ID",
          "Название книги",
          "Авторы",
          "Описание",
          "Выдано (шт.)"
          ), ANSI_GREEN);
      sayTable(repeat("-", 151), ANSI_GREEN);
      for (ReservedBook reserved : takenBooks) {
        String title = cutString(reserved.getBook().getTitle(), 45);
        String authors = cutString(
            reserved.getBook().getAuthors().stream()
                .map(Author::getLastName)
                .collect(Collectors.joining(",")),
            30
        );
        String description = cutString(reserved.getBook().getDescription(), 40);
        sayTable(String.format(bookFormat,
            reserved.getBook().getBookId(),
            title,
            authors,
            description,
            reserved.getQuantity()
        ), ANSI_GREEN);
        sayTable(repeat("-", 151), ANSI_GREEN);
      }
    } catch (SQLException e) {
      logger.error("", e);
    }
  }

  private String cutString(String value, int maxPosition) {
    if (value == null) {
      return "";
    }
    String title;
    if (value.length() > maxPosition) {
      title = value.substring(0, maxPosition - 3) + "...";
    } else {
      title = value;
    }
    return title;
  }

  private void takeBook(Scanner sc) {
    try {
      String bookId = ask("Введите идентификатор книги", sc);
      String quantity = ask("Введите количество", sc);
      ActionResult actionResult = readersDao
          .reserve(reader.getReaderId(), Integer.parseInt(bookId), Integer.parseInt(quantity));

      if (!actionResult.isStatus()) {
        say(actionResult.getMessage(), ANSI_RED);
      }
    } catch (Exception e) {
      logger.error("Что-то пошло не так во время взятия книги ", e);
    }
  }

  private void cabinet(Scanner sc) {
    Action action = LibraryActions.QUIT;
    try {
      sayAvailableActions(action);
      LibraryActions pickedAction = LibraryActions.valueOfCode(
          ask("Выберете действие [" + LibraryActions.getGroupedCodes() + "]", sc)
      );
      shortDelimiter(ANSI_GREEN);
      say("Выбранное действие: " + pickedAction.getDescription(), ANSI_GREEN);
      switch (pickedAction) {
        case QUIT: quit();
        case SEARCH_BOOKS:
          searchBooks(sc);
          break;
        case SHOW_BOOKS:
          showBooks();
          break;
        case SHOW_STATISTIC:
          showStatistic();
          break;
      }
      say("Действие завершено: " + pickedAction.getDescription(), ANSI_GREEN);
      delimiter(ANSI_GREEN);
    } catch (IllegalArgumentException e) {
      sayBadAction();
      getAction(sc);
    }
  }

  private void showBooks() {
    try {
      List<Book> takenBooks = booksDao.getFreeBooks();
      sayTable(repeat("-", 151), ANSI_GREEN);
      sayTable(String.format(bookFormat,
          "ID",
          "Название книги",
          "Авторы",
          "Описание",
          "Доступно (шт.)"
      ), ANSI_GREEN);
      sayTable(repeat("-", 151), ANSI_GREEN);
      for (Book book : takenBooks) {
        String title = cutString(book.getTitle(), 45);
        String authors = cutString(
            book.getAuthors().stream()
                .map(Author::getLastName)
                .collect(Collectors.joining(",")),
            30
        );
        String description = cutString(book.getDescription(), 40);
        sayTable(String.format(bookFormat,
            book.getBookId(),
            title,
            authors,
            description,
            book.getQuantity()
        ), ANSI_GREEN);
        sayTable(repeat("-", 151), ANSI_GREEN);
      }
    } catch (SQLException e) {
      logger.error("", e);
    }
  }

  private void showStatistic() {
    try {
      List<BookStatistic> takenBooks = booksDao.getBooksStatistics();
      sayTable(repeat("-", 151), ANSI_GREEN);
      sayTable(String.format(statBookFormat,
          "ID",
          "Название книги",
          "Авторы",
          "Всего (шт.)",
          "Выдано (шт.)",
          "Доступно (шт.)"
      ), ANSI_GREEN);
      sayTable(repeat("-", 151), ANSI_GREEN);
      for (BookStatistic book : takenBooks) {
        String title = cutString(book.getBook().getTitle(), 55);
        String authors = cutString(
            book.getBook().getAuthors().stream()
                .map(Author::getLastName)
                .collect(Collectors.joining(",")),
            35
        );
        sayTable(String.format(statBookFormat,
            book.getBook().getBookId(),
            title,
            authors,
            book.getBook().getQuantity(),
            book.getQuantityReaders(),
            book.getBook().getQuantity() - book.getQuantityReaders()
        ), ANSI_GREEN);
        sayTable(repeat("-", 151), ANSI_GREEN);
      }
    } catch (SQLException e) {
      logger.error("", e);
    }
  }

  private void searchBooks(Scanner sc) {
    Action action = SearchActions.QUIT;
    try {
      sayAvailableActions(action);
      SearchActions pickedAction = SearchActions.valueOfCode(
          ask("Выберете действие [" + SearchActions.getGroupedCodes() + "]", sc)
      );
      shortDelimiter(ANSI_GREEN);
      say("Выбранное действие: " + pickedAction.getDescription(), ANSI_GREEN);
      switch (pickedAction) {
        case QUIT: quit();
        case BY_AUTHOR:
          searchByAuthor(sc);
          break;
        case BY_TITLE:
          searchByTitle(sc);
          break;
      }
      say("Действие завершено: " + pickedAction.getDescription(), ANSI_GREEN);
      delimiter(ANSI_GREEN);
    } catch (IllegalArgumentException e) {
      sayBadAction();
      getAction(sc);
    }
  }

  private void searchByTitle(Scanner sc) {
    String titleQuery = ask("Введите название книги", sc);
    try {
      List<BookStatistic> takenBooks = booksDao.searchBooksByTitle(titleQuery);
      sayTable(repeat("-", 151), ANSI_GREEN);
      sayTable(String.format(bookFormat,
          "ID",
          "Название книги",
          "Авторы",
          "Описание",
          "Доступно (шт.)"
      ), ANSI_GREEN);
      sayTable(repeat("-", 151), ANSI_GREEN);
      for (BookStatistic statistic : takenBooks) {
        String title = cutString(statistic.getBook().getTitle(), 45);
        String authors = cutString(
            statistic.getBook().getAuthors().stream()
                .map(Author::getLastName)
                .collect(Collectors.joining(",")),
            30
        );
        String description = cutString(statistic.getBook().getDescription(), 40);
        sayTable(String.format(bookFormat,
            statistic.getBook().getBookId(),
            title,
            authors,
            description,
            statistic.getBook().getQuantity() - statistic.getQuantityReaders()
        ), ANSI_GREEN);
        sayTable(repeat("-", 151), ANSI_GREEN);
      }
    } catch (SQLException e) {
      logger.error("", e);
    }
  }

  private void searchByAuthor(Scanner sc) {
    String lastName = ask("Введите фамилию автора", sc);
    try {
      List<BookStatistic> takenBooks = booksDao.getFreeBooksByAuthor(lastName);
      sayTable(repeat("-", 151), ANSI_GREEN);
      sayTable(String.format(bookFormat,
          "ID",
          "Название книги",
          "Авторы",
          "Описание",
          "Доступно (шт.)"
      ), ANSI_GREEN);
      sayTable(repeat("-", 151), ANSI_GREEN);
      for (BookStatistic book : takenBooks) {
        String title = cutString(book.getBook().getTitle(), 45);
        String authors = cutString(
            book.getBook().getAuthors().stream()
                .map(Author::getLastName)
                .collect(Collectors.joining(",")),
            30
        );
        String description = cutString(book.getBook().getDescription(), 40);
        sayTable(String.format(bookFormat,
            book.getBook().getBookId(),
            title,
            authors,
            description,
            book.getBook().getQuantity() - book.getQuantityReaders()
        ), ANSI_GREEN);
        sayTable(repeat("-", 151), ANSI_GREEN);
      }
    } catch (SQLException e) {
      logger.error("", e);
    }
  }

  private void quit() {
    throw new IllegalStateException("Get quit command");
  }

  private void sayAvailableActions(Action actions) {
    String color = ANSI_CYAN;
    delimiter(color);
    say("Доступные действия", color);
    shortDelimiter(color);
    for (Action action : actions.getActions()) {
      say(String.format(actionFormat, action.getDescription(), action.getCode()), color);
    }
    delimiter(color);
  }

  private void authorize(Scanner sc) {
    System.out.println();
    delimiter(ANSI_CYAN);
    say("Вы не авторизованы!", ANSI_CYAN);
    say("Пожалуйста, авторизуйтесь (1) или создайте новую учетную запись (2)", ANSI_CYAN);
    shortDelimiter(ANSI_CYAN);
    say("Чтобы заверщить работу нажмите q", ANSI_CYAN);
    delimiter(ANSI_CYAN);
    try {
      System.out.println();
      delimiter(ANSI_GREEN);
      AuthorizeActions action = AuthorizeActions.valueOfCode(
          ask("Выберете действие [1,2,q]", sc)
      );
      switch (action) {
        case QUIT: quit();
        case REGISTER:
          register(sc);
          break;
        case AUTHORIZE:
          processAuthorize(sc);
          break;
      }
    } catch (IllegalArgumentException e) {
      sayBadAction();
      authorize(sc);
    }
  }

  private void sayBadAction() {
    say("Вы ввели не существующее действие, сконцентрируйтесь и попробуйте еще раз", ANSI_RED);
    delimiter(ANSI_RED);
  }

  private void processAuthorize(Scanner sc) {
    try {
      String userName = ask("Введите логин", sc);
      reader.setUsername(userName);
      reader = readersDao.auth(reader);
      sayHelloToReader();
    } catch (ReaderNotFoundException e) {
      say(String.format("Не найден читатель с логином: %-44s", reader.getUsername()), ANSI_RED);
      delimiter(ANSI_RED);
      authorize(sc);
    } catch (Exception e) {
      logger.error("Что-то пошло не так во время авторизации пользователя ", e);
    }
  }

  private void register(Scanner sc) {
    try {
      String name = ask("Введите имя", sc);
      reader.setName(name);
      String lastName = ask("Введите фамилию", sc);
      reader.setLastName(lastName);
      String userName = ask("Введите логин", sc);
      reader.setUsername(userName);
      reader = readersDao.register(reader);
      sayHelloToReader();
    } catch (Exception e) {
      logger.error("Что-то пошло не так во время создания новго пользователя ", e);
    }
  }

  private void say(String message, String color) {
    printlnColored(String.format(messageFormat, message), color);
  }

  private void sayTable(String message, String color) {
    printColored("|| ", color);
    printColored(String.format(tableFormat, message), ANSI_PURPLE);
    printColored(" ||\n", color);
  }

  private void delimiter(String color) {
    printlnColored(repeat("=", 157), color);
  }

  private void shortDelimiter(String color) {
    printlnColored(repeat("-", 157), color);
  }

  private String ask(String query, Scanner sc) {
    printColored(String.format(askFormat, query), ANSI_BLUE);
    return sc.nextLine();
  }

  private void sayHelloToReader() {
    shortDelimiter(ANSI_GREEN);
    say(String.format("%-35s : %-16s%-20s", "Приветствуем тебя"
        , reader.getName(), reader.getLastName()), ANSI_GREEN);
    delimiter(ANSI_GREEN);
  }

  private String repeat(String character, int repeat) {
    return new String(new char[repeat]).replace("\0", character);
  }

  private boolean isRunning() {
    return running;
  }

  public void destroy() throws Exception {
    booksDao.close();
    readersDao.close();
  }

  private void printlnColored(String message, String color) {
    System.out.println(color + message + ANSI_RESET);
  }

  private void printColored(String message, String color) {
    System.out.print(color + message + ANSI_RESET);
  }
}
