package ru.anovikova.lesson15;


import java.io.*;
import java.nio.file.Files;

public class WriteToFile {

    public static void main(String[] args) throws IOException {
        File filesDirectory = directoryCreateFile();
        readFolder(new File("src"), 0);
        readFolder(filesDirectory, 0);

        File newFile = newFile();


        writeToFile(filesDirectory, newFile);

        File destFile = renameToFile(filesDirectory, newFile);

        File source = copyToFile(filesDirectory, destFile);

        deleteToFile(filesDirectory, destFile, source);

    }

    private static void deleteToFile(File filesDirectory, File destFile, File source) throws IOException {
        System.out.println("Удаляем файл files/dex.txt");
        Files.delete(destFile.toPath());
        readFolder(filesDirectory, 0);
        System.out.println("Удаляем файл files/source.txt");
        Files.delete(source.toPath());
        readFolder(filesDirectory, 0);
    }

    private static File copyToFile(File filesDirectory, File destFile) throws IOException {
        System.out.println("Копируем файл files/dex.txt в files/source.txt");
        File source = new File("files/source.txt");   // создаем новый файл source
        Files.copy(destFile.toPath(), source.toPath());       // копируем содержание файла file в файл source

        readFolder(filesDirectory, 0);
        return source;
    }

    private static File renameToFile(File filesDirectory, File newFile) {
        System.out.println("Переименовываем файл files/newFile.txt в files/dex.txt");
        File destFile = new File("files/dex.txt");   //переименовываем файл newFile.txt в dex.txt
        boolean renamed = newFile.renameTo(destFile);
        System.out.println("Renamed: " + renamed);

        readFolder(filesDirectory, 0);
        return destFile;
    }

    private static void writeToFile(File filesDirectory, File newFile) throws IOException {
        FileWriter fw = new FileWriter(newFile); // записываем в файл Привет Мир!
        fw.write("Привет,Мир!");
        fw.close();

        readFolder(filesDirectory, 0);
    }

    private static File newFile() {
        System.out.println("Создаем файл files/newFile.txt");
        File newFile = new File("files/newFile.txt");
        try {
            newFile.createNewFile();      // создаем файл newFile.txt
            System.out.println("Абсолютный путь " + newFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

    private static File directoryCreateFile() {
        File filesDirectory = new File("files");
        System.out.println("Создаем директорию files");
        if (!filesDirectory.exists()) {
            filesDirectory.mkdir();
        }
        return filesDirectory;
    }

    private static void readFolder(File directory, int level) {
        int nextLevel = level+1;
        System.out.println("Начинается получение списка файлов в директории: " + directory.getAbsolutePath());
        if (directory.isDirectory()) {
            if (directory.listFiles().length == 0) {
                System.out.println("Директория " + directory.getAbsolutePath()+ " пустая");
            }
            for (File child : directory.listFiles()) {
                fileInfo(child, level);
                if (child.getAbsoluteFile().isDirectory()) {
                    readFolder(child, nextLevel);
                }
            }
        } else {
            fileInfo(directory, level);
        }
    }

    private static void fileInfo(File file, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        if (file.isDirectory()) {
            System.out.println(file.getName() + " is directory");
        } else {
            System.out.println(file.getName() + " is file");
        }
    }
}
