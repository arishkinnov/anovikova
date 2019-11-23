package ru.anovikova.lesson32;

import java.util.LinkedList;
import java.util.List;

public class Tree<T extends Comparable<T>> {

    private class Node {
        final T value;
        Node left;
        Node right;

        public Node(T val) {
            value = val;
            left = null;
            right = null;
        }
    }

    private Node root;

    public Tree() {
        this.root = null;
    }

    public void append(T value) {
        root = appendNode(root, value);
    }

    private Node appendNode(Node rootNode, T val) {
        if ( rootNode == null )
            return new Node(val);
        else {
            int compareResult = rootNode.value.compareTo(val);
            if ( compareResult > 0 ) {
                rootNode.left = appendNode(rootNode.left, val);
            } else if ( compareResult < 0 ) {
                rootNode.right = appendNode(rootNode.right, val);
            }
        }
        return rootNode;
    }

    public List<T> toListInOrder() {
        List<T> list = new LinkedList<>();
        inOrderTraversal(list, root);
        return list;
    }

    private void inOrderTraversal(List<T> list, Node rootNode) {
        if ( rootNode != null ) {
            inOrderTraversal(list, rootNode.left);
            list.add(rootNode.value);
            inOrderTraversal(list, rootNode.right);
        }
    }

    public List<T> toListPreOrder() {
        List<T> list = new LinkedList<>();
        preOrderTraversal(list, root);
        return list;
    }

    private void preOrderTraversal(List<T> list, Node rootNode) {
        if ( rootNode != null ) {
            list.add(rootNode.value);
            preOrderTraversal(list, rootNode.left);
            preOrderTraversal(list, rootNode.right);
        }
    }

    public List<T> toListPostOrder() {
        List<T> list = new LinkedList<>();
        postOrderTraversal(list, root);
        return list;
    }

    private void postOrderTraversal(List<T> list, Node rootNode) {
        if ( rootNode != null ) {
            postOrderTraversal(list, rootNode.left);
            postOrderTraversal(list, rootNode.right);
            list.add(rootNode.value);
        }
    }

    public int numbersOfLeaf() {
        return countLeaf(root);
    }

    private int countLeaf(Node rootNode) {
        int count = 0;
        if ( rootNode != null ) {
            count += countLeaf(rootNode.left);
            count += countLeaf(rootNode.right);
            if (rootNode.left == null && rootNode.right == null) {
                return 1;
            }
        }
        return count;
    }

}