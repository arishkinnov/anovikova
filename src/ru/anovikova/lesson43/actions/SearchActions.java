package ru.anovikova.lesson43.actions;

import java.util.Arrays;
import java.util.List;

public enum SearchActions implements Action {
  BY_AUTHOR("1", "Поиск по фамилии автора"),
  BY_TITLE("2", "Поиск по названию книги"),
  QUIT("q", "Завершить работу с приложением");

  private final String code;
  private final String description;

  SearchActions(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public static SearchActions valueOfCode(String code) {
    for (SearchActions action : values()) {
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
    for (SearchActions action : values()) {
      if (sb.length() != 0) {
        sb.append(",");
      }
      sb.append(action.code);
    }
    return sb.toString();
  }
}
