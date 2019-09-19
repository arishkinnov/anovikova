package ru.anovikova.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
          int mod ;
          mod = number % 2;
          if (number != 0) {
              if (mod == 0) {
                  System.out.println("Число четное");
              } else {
                  System.out.println("Число нечетное");
              }
          }
          if (number == 0) {
              System.out.println("Число нулевое");
          } else if (number < 0 ) {
              System.out.println("Число отрицательное");
          }     else {
              System.out.println("Число положительное");
          }
    }
}

