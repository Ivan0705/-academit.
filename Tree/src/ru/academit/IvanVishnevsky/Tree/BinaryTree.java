package ru.academit.IvanVishnevsky.Tree;


public class BinaryTree<T> {
    Node<T> root = null;

    class Node<T> {
        private int key;
        private T value;
        Node<T> left;
        Node<T> right;
        private T parent;

        public Node(T value, int key, T parent) {
            this.value = value;
            this.key = key;
            this.parent = parent;
        }
    }

    Node search(Node t, int key) {
        if (t == null || t.key == key) {
            return t;
        }
        if (key > t.key) {
            return search(t.left, key);
        } else {
            return search(t.right, key);
        }
    }

    Node search(int key) {
        return search(root, key);
    }

    public void insert()
    {}
}
