package com.company.front;

import javax.swing.*;

public class MainFrame extends JFrame {
    private MainMenu mainMenuPage;
    private AddStudentPage addStudentPage;
    private SecondPage secondPage;

    public MainMenu getMainMenuPage() {
        return mainMenuPage;
    }

    public AddStudentPage getAddStudentPage() {
        return addStudentPage;
    }

    public SecondPage getSecondPage() {
        return secondPage;
    }

    public MainFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BITLAB Application");
        setSize(500,500);
        setLayout(null);

        mainMenuPage = new MainMenu(this);
        mainMenuPage.setVisible(true);
        add(mainMenuPage);

        addStudentPage = new AddStudentPage(this);
        addStudentPage.setVisible(false);
        add(addStudentPage);

        secondPage = new SecondPage(this);
        secondPage.setVisible(false);
        add(secondPage);


    }
}
