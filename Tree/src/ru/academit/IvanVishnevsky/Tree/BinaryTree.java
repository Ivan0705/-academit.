package ru.academit.IvanVishnevsky.Tree;


public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;
    private int size;


    public BinaryTree(T data) {
        this.data = data;
    }

    public int size() {
        return size;
    }

   
   /* @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (BinaryTree<T> p = this.data, p!=null;)
        {
            str
        }
        return str.toString();
    }*/
}
