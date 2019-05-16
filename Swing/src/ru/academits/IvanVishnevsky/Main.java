package ru.academits.IvanVishnevsky;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
       /* JFrame myWindow = new JFrame("Пробное окно");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(400, 300);
        myWindow.setVisible(true);*/
       /* JFrame myWindow = new SimpleWindow();
        myWindow.setVisible(true);*/
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("окно");
            frame.setSize(200, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JButton button = new JButton("Ok");
            frame.add(button);
            frame.setVisible(true);
        });

    }
}
