package ru.anovikova.lesson32;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.append(10);
        tree.append(7);
        tree.append(15);
        tree.append(2);
        tree.append(5);
        tree.append(9);
        tree.append(8);
        System.out.println("Количество листовых узлов: " + tree.numbersOfLeaf());
    }
}
