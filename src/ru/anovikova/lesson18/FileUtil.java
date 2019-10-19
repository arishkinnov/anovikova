package ru.anovikova.lesson18;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtil {
    public static void main(String[] args) throws IOException {
        copyFile(
                newFile("newFile"), StandardCharsets.UTF_8.name(),
                new File("files/lesson18/secondFile.txt"),  "Windows-1251");
    }

    public static void copyFile(File sourceFile, String sourceFileCharsetName, File destFile, String destFileCharsetName) throws IOException {
        try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(destFile), destFileCharsetName);
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), sourceFileCharsetName))
        ) {
            String str;
            while ((str = in.readLine()) != null) {
                writer.write(str + '\n');
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    private static File newFile(String fileName) throws IOException {
        directoryCreateFile();
        System.out.println("Создаем файл files/lesson18/" + fileName);
        File newFile = new File("files/lesson18/" + fileName);
        try {
            newFile.createNewFile();
            System.out.println("Абсолютный путь " + newFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(newFile);
        return newFile;
    }


    private static void directoryCreateFile() {
        File filesDirectory = new File("files/lesson18");
        System.out.println("Создаем директорию files/lesson18");
        if (!filesDirectory.exists()) {
            filesDirectory.mkdirs();
        }
    }

    private static void writeToFile(File newFile) throws IOException {
        try (OutputStreamWriter writer =
                     new OutputStreamWriter(new FileOutputStream(newFile), StandardCharsets.UTF_8)) {
            writer.write("Привет! Я тупень.\n");
            writer.write("Хотя, если подумать\n");
            writer.write("То нет");
        }
    }
}
