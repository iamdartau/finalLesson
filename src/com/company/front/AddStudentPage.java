package com.company.front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentPage extends JPanel {

    private MainFrame parent;

    private JLabel label;
    private JLabel name, surname, age;
    private JTextField nameField, surnameField, ageTextField;
    private JButton add, back;

    public AddStudentPage(MainFrame parent) {
        this.parent = parent;
        setSize(500,500);
        setLayout(null);

        name = new JLabel("Name:");
        name.setSize(100, 30);
        name.setLocation(100, 100);
        add(name);

        nameField = new JTextField("insert name");
        nameField.setSize(150, 30);
        nameField.setLocation(250, 100);
        add(nameField);

        surname = new JLabel("Surname: ");
        surname.setSize(100, 30);
        surname.setLocation(100, 160);
        add(surname);

        surnameField = new JTextField("insert surname");
        surnameField.setSize(150, 30);
        surnameField.setLocation(250, 160);
        add(surnameField);

        age = new JLabel("Group: ");
        age.setSize(100, 30);
        age.setLocation(100, 270);
        add(age);

        ageTextField = new JTextField("insert group");
        ageTextField.setSize(150, 30);
        ageTextField.setLocation(250, 270);
        add(ageTextField);

        add = new JButton("ADD");
        add.setSize(100, 30);
        add.setLocation(100, 370);
        add(add);

        back = new JButton("Back");
        back.setSize(300,30);
        back.setLocation(100,150);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAddStudentPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }
}
