package ru.anovikova.lesson43.actions;

import java.util.Arrays;
import java.util.List;

public enum AuthorizeActions implements Action {
  AUTHORIZE("1", "Авторизоваться по логину"),
  REGISTER("2", "Зарегистрировать нового пользователя"),
  QUIT("q", "Завершить работу с приложением");

  private final String code;
  private final String description;

  AuthorizeActions(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public static AuthorizeActions valueOfCode(String code) {
    for (AuthorizeActions action : values()) {
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
    for (AuthorizeActions action : values()) {
      if (sb.length() != 0) {
        sb.append(",");
      }
      sb.append(action.code);
    }
    return sb.toString();
  }
}
