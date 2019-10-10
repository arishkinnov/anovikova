package ru.anovikova.lesson15;

import java.io.*;

public class WriteToFile {

    public static  void main(String[] args) throws IOException {
        File file = new File("newFile.txt");
        try {
            file.createNewFile();      // создаем файл newFile.txt
            System.out.println("Абсолютный путь " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fw = new FileWriter(file); // записываем в файл Привет Мир!
        fw.write("Привет,Мир!");
        fw.close();

        File destFile = new File("dex.txt");
        boolean renamed = file.renameTo(destFile);
        System.out.println("Renamed: "+ renamed);




    }
}
