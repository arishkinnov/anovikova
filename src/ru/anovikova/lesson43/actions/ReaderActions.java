package ru.anovikova.lesson43.actions;

import java.util.Arrays;
import java.util.List;

public enum ReaderActions implements Action {
  SHOW_TAKEN_BOOKS("1", "Вывести список взятых книг"),
  TAKE_BOOK("2", "Взять книгу"),
  RETURN_BOOK("3", "Сдать книгу"),
  QUIT("q", "Завершить работу с приложением");

  private final String code;
  private final String description;

  ReaderActions(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public static ReaderActions valueOfCode(String code) {
    for (ReaderActions action : values()) {
      if (action.code.equals(code)) {
        return action;
      }
    }

    throw new IllegalArgumentException("Wrong code " + code);
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public List<Action> getActions() {
    return Arrays.asList(values());
  }

  public static String getGroupedCodes() {
    StringBuilder sb = new StringBuilder();
    for (ReaderActions action : values()) {
      if (sb.length() != 0) {
        sb.append(",");
      }
      sb.append(action.code);
    }
    return sb.toString();
  }
}
