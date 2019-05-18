package ru.academits.IvanVishnevsky;

import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class AAA extends JFrame{


    // Текстовые поля
    JTextField smallField, bigField;

    public AAA()
    {
        super("Текстовые поля");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Создание текстовых полей
        smallField = new JTextField(15);
        smallField.setToolTipText("Короткое поле");
        bigField = new JTextField("Текст поля", 25);
        bigField.setToolTipText("Длиное поле");
        // Настройка шрифта
        bigField.setFont(new Font("Dialog", Font.PLAIN, 14));
        bigField.setHorizontalAlignment(JTextField.RIGHT);
        // Слушатель окончания ввода
        smallField.addActionListener(e -> {
            // Отображение введенного текста
            JOptionPane.showMessageDialog(AAA.this,
                    "Ваше слово: " + smallField.getText());
        });
        // Поле с паролем
        JPasswordField password = new JPasswordField(12);
        password.setEchoChar('*');
        // Создание панели с текстовыми полями
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(smallField);
        contents.add(bigField  );
        contents.add(password  );
        setContentPane(contents);
        // Определяем размер окна и выводим его на экран
        setSize(400, 130);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AAA();
    }
}
