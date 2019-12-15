package ru.anovikova.lesson43.actions;

import java.util.Arrays;
import java.util.List;

public enum Actions implements Action {
  CABINET("1", "Личный кабинет читателя"),
  BOOK_OPERATIONS("2", "Операции с книгами"),
  QUIT("q", "Завершить работу с приложением");

  private final String code;
  private final String description;

  Actions(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public static Actions valueOfCode(String code) {
    for (Actions action : values()) {
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
    for (Actions action : values()) {
      if (sb.length() != 0) {
        sb.append(",");
      }
      sb.append(action.code);
    }
    return sb.toString();
  }
}
