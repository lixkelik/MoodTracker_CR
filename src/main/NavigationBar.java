package main;

import javax.swing.*;

import data.User;
import page.InsertMood;
import page.Login;
import page.ViewMood;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationBar extends JMenuBar {
    public NavigationBar() {
        createFileMenu();
    }

    private void createFileMenu() {
        JMenu fileMenu = new JMenu("Navigation");
        fileMenu.add(createMenuItem("Logout", this::logout));
        fileMenu.add(createMenuItem("View Mood", this::navigateToViewMood));
        fileMenu.add(createMenuItem("Insert Mood", this::navigateToInsertMood));
        add(fileMenu);
    }

    private JMenuItem createMenuItem(String label, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(label);
        menuItem.addActionListener(actionListener);
        return menuItem;
    }

    private void logout(ActionEvent e) {
        User.setCurrentUser(null);
        closeCurrentWindow();
        openLoginWindow();
    }

    private void navigateToViewMood(ActionEvent e) {
        closeCurrentWindow();
        openViewMoodWindow();
    }

    private void navigateToInsertMood(ActionEvent e) {
        closeCurrentWindow();
        openInsertMoodWindow();
    }

    private void closeCurrentWindow() {
        SwingUtilities.getWindowAncestor(getRootPane()).dispose();
    }

    private void openLoginWindow() {
        Login login = new Login();
        login.setVisible(true);
    }

    private void openViewMoodWindow() {
        ViewMood viewMood = new ViewMood();
        viewMood.setVisible(true);
    }

    private void openInsertMoodWindow() {
        InsertMood insertMood = new InsertMood();
        insertMood.setVisible(true);
    }
}
