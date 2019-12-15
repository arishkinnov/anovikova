package ru.anovikova.lesson43.model;

public class Author {
  private int authorId;
  private String name;
  private String lastName;

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
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

  @Override
  public String toString() {
    return "Author{" +
        "authorId=" + authorId +
        ", name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
