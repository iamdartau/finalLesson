package com.company.front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondPage extends JPanel {


    private MainFrame parent;

    private JLabel label;
    private JButton back;


    public SecondPage(MainFrame parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("list users");
        label.setSize(300,30);
        label.setLocation(100,100);
        add(label);

        back = new JButton("Back");
        back.setSize(300,30);
        back.setLocation(100,150);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getSecondPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }
}
