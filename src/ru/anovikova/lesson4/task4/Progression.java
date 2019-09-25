package ru.anovikova.lesson4.task4;

import java.util.Scanner;

public class Progression {

    public static void main(String[] args) {
        System.out.println("Пожалуйста, выберите вид прогрессии - арифметическая (1) или геометрическая (2): ");
        Scanner s = new Scanner (System.in);
        int x = s.nextInt();
        if (x == 1) {
            System.out.println("Пожалуйста, введите разность арифметической прогрессии: ");
            Scanner s1 = new Scanner (System.in);
            int d = s1.nextInt();
            System.out.println("Пожалуйста, введите значение первого члена прогрессии: ");
            Scanner s2 = new Scanner (System.in);
            int a = s2.nextInt();
            System.out.println("Пожалуйста, введите нужное количество следующих членов прогрессии: ");
            Scanner s3 = new Scanner (System.in);
            int n = s3.nextInt();
            if (n < 0) {
                System.out.println("Неверное количество, пожалуйста перезапустите программу.");
            } else {
                for (int n1 = 1; n1 <= n; n1++) {
                    System.out.print(a + " ");
                    a = a + d;
                }
                System.out.println();
            }
        } else if (x==2) {
            System.out.println("Пожалуйста, введите знаменатель геометрической прогрессии: ");
            Scanner s1 = new Scanner (System.in);
            double d = s1.nextDouble();
            System.out.println("Пожалуйста, введите значение первого члена прогрессии: ");
            Scanner s2 = new Scanner (System.in);
            double a = s2.nextDouble();
            System.out.println("Пожалуйста, введите нужное количество следующих членов прогрессии: ");
            Scanner s3 = new Scanner (System.in);
            int n = s3.nextInt();
            if (n < 0) {
                System.out.println("Неверное количество, пожалуйста перезапустите программу.");
            } else {
                for (int n1 = 1; n1 <= n; n1++) {
                    System.out.println(a + " ");
                    a = a + d;
                }
            }
            for (int n1 = 1; n1 <= n; n1++) {
                System.out.print(a + " ");
                a = a * d;
            }
            System.out.println();
        } else {
            System.out.println("Недопустимое значение, пожалуйста, перезапустите программу.");
        }
    }
}
