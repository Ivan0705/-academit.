package ru.academits.IvanVishnevsky;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class SimpleWindow extends JFrame {
    SimpleWindow(){
     /*   super("Пробное окно");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,3,5,10));
        panel.add(new JButton("Кнопка"));
        panel.add(new JButton("+"));
        panel.add(new JButton("-"));
        panel.add(new JButton("Кнопка с длинной надписью"));
        panel.add(new JButton("еще кнопка"));
        setContentPane(panel);
        setSize(250, 100);*/

      /*  super("Пробное окно");
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

        super("Пробное окно");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,3,5,10));
        panel.add(new JButton("Кнопка"));
        panel.add(new JButton("+"));
        panel.add(new JButton("-"));
        panel.add(new JButton("Кнопка с длинной надписью"));
        panel.add(new JButton("еще кнопка"));
        setContentPane(panel);
        setSize(250, 100);
    }
}
