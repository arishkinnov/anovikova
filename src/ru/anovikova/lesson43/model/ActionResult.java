package ru.anovikova.lesson43.model;

public class ActionResult {
  private String message;
  private boolean status;

  public ActionResult(String message, boolean status) {
    this.message = message;
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public boolean isStatus() {
    return status;
  }
}
