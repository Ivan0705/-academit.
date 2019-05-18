package ru.academits.IvanVishnevsky;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.text.NumberFormat;

public class SimpleWindow extends JFrame {

//    private final JFormattedTextField fahrenheitTextField;
    private JButton fahrenheit;

    SimpleWindow() {
        super("Пробное окно");
        Font font = new Font("Arial", 23, 34);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel, panel2;
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3, 5, 10));
        panel.add(new JButton("Кнопка"));
        panel.setFont(font);
        panel.setForeground(Color.RED);
        panel.add(new JButton("+"));
        panel.add(new JButton("-"));
        panel.add(new JButton("Кнопка с длинной надписью"));
        panel.add(new JButton("еще кнопка"));
        setContentPane(panel);
        setSize(250, 100);

        JTextField textField = new JTextField("Text", 20);
        String text = textField.getText();
        int number = Integer.parseInt(text);
        
    /*      fahrenheitTextField = new JFormattedTextField(NumberFormat.getNumberInstance());
        add(fahrenheitTextField);
        add(new JLabel("Fahrenheit"));
        fahrenheitTextField.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fahrenheitTextField.setEditable(false);
        fahrenheitTextField.setColumns(8);
        fahrenheit = new JButton("Fahrenheit");
        fahrenheit.setForeground(Color.RED);
        fahrenheit.setFont(font);


      super("Пробное окно");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,3,5,10));
        panel.add(createPanel(new TitledBorder("Рамка с заголовком"), "TitledBorder"));
        panel.add(createPanel(new EtchedBorder(), "EtchedBorder"));
        panel.add(createPanel(new BevelBorder(BevelBorder.LOWERED), "BevelBorder"));
        panel.add(createPanel(new SoftBevelBorder(BevelBorder.RAISED), "SoftBevelBorder"));
        panel.add(createPanel(new LineBorder(Color.ORANGE, 4), "LineBorder"));
        panel.add(createPanel(new MatteBorder(new ImageIcon("1.gif")), "MatteBorder"));
        setContentPane(panel);
        pack();

*/

      /*  super("Пробное окно");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,3,5,10));
        panel.add(new JButton("Кнопка"));
        panel.add(new JButton("+"));
        panel.add(new JButton("-"));
        panel.add(new JButton("Кнопка с длинной надписью"));
        panel.add(new JButton("еще кнопка"));
        setContentPane(panel);
        setSize(250, 100);*/
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

}
