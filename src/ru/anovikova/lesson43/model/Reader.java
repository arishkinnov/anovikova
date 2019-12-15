package ru.anovikova.lesson43.model;

public class Reader {
  private int readerId;
  private String name;
  private String lastName;
  private String username;

  public int getReaderId() {
    return readerId;
  }

  public void setReaderId(int readerId) {
    this.readerId = readerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "Reader{" +
        "readerId=" + readerId +
        ", name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        ", username='" + username + '\'' +
        '}';
  }
}
