package ru.academit.IvanVishnevsky.Tree;

public class Tree<T> {
    private T head;
    private Tree<T> left;
    private Tree<T> right;

    public Tree(T data, Tree<T> left, Tree<T> right) {
        this.head = data;
        this.right = right;
        this.left = left;
    }

    public Tree(T data) {
        this.head= head;
    }
}
