package ru.anovikova.lesson43.actions;

import java.util.Arrays;
import java.util.List;

public enum LibraryActions implements Action {
  SHOW_BOOKS("1", "Вывести список книг в наличии"),
  SHOW_STATISTIC("2", "Вывести рейтинг книг"),
  SEARCH_BOOKS("3", "Поиск книг"),
  QUIT("q", "Завершить работу с приложением");

  private final String code;
  private final String description;

  LibraryActions(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public static LibraryActions valueOfCode(String code) {
    for (LibraryActions action : values()) {
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
    for (LibraryActions action : values()) {
      if (sb.length() != 0) {
        sb.append(",");
      }
      sb.append(action.code);
    }
    return sb.toString();
  }
}
