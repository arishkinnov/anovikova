package ru.anovikova.lesson17;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Library {

    private Book[] books = new Book[10];

    public Library() {
        init();
    }

    public void run() {
        try {
            while (true) {
                showCommands();
                Scanner scanner = new Scanner(System.in);
                String commands = scanner.nextLine();
                try {
                    Command command = Command.findById(Integer.parseInt(commands));
                    doCommand(command);
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            saveBooksToFile();
        }
    }

    private void init() {
        File filesDirectory = new File("books");
        if (!filesDirectory.exists()) {
            System.out.println("Создаем директорию books");
            filesDirectory.mkdir();
        }

        loadBooksFromFile();
    }

    private void loadBooksFromFile() {
        try (InputStream is = new FileInputStream("books/books.dat");
             ObjectInputStream in = new ObjectInputStream(is)) {
            while (is.available() > 0) {
                books = (Book[]) in.readObject();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Еще не было сохранено книг");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveBooksToFile() {
        try (OutputStream os = new FileOutputStream("books/books.dat");
             ObjectOutputStream fout = new ObjectOutputStream(os))
        {
            fout.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCommands() {
        System.out.println("Список доступных команд");
        Arrays.stream(Command.values()).forEach(command -> System.out.println(command.getId() + " " + command.name()));
    }

    private void doCommand(Command command) {
        switch (command) {
            case SHOW:
                showBooks();
                break;
            case CREATE:
                createBook();
                break;
            case EXIT:
                throw new RuntimeException("Получен сигнал завершения программы");
        }
    }

    private void createBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();
        System.out.print("Введите год издания книги: ");
        int year = scanner.nextInt();

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);

        for(int index = 0; index < books.length; index++) {
            Book currentBook = books[index];
            if(currentBook == null) {
                books[index] = book;
                System.out.println("Книга успешно положена на полку " + book.toString());
                return;
            }
        }

        throw new IllegalStateException("На книжной полке закончилось место.");
    }

    private void showBooks() {
        System.out.println("На книжной полке: ");
        Arrays.stream(books).forEach(
                book ->  {
                    if (book != null)  {
                        System.out.println(book);
                    }
                });
    }
}
