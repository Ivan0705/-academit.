package ru.academit.IvanVishnevsky.Main;

public class TreeMain {
    public static void main(String[] args) {
        BynarySearchTree tree = new BynarySearchTree();
        tree.insert(3, 1);
        tree.insert(2, 2);
        tree.insert(4, 5);
        tree.print();
        tree.remove(2);
        tree.remove(3);
        tree.print();
        tree.remove(4);

    }
}
