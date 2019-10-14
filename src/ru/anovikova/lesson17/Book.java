package ru.anovikova.lesson17;

import java.io.Serializable;

public class Book implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    private String title;
    private String author;
    private int year;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return '\'' + title + '\'' +
                ". " + author +
                ". год издания " + year + '.';
    }
}
