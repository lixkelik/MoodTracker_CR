package main;

import javax.swing.*;

import data.User;
import page.InsertMood;
import page.Login;
import page.ViewMood;

import java.awt.event.*;

public class NavigationBar extends JMenuBar {
    public NavigationBar() {
        // Create the "File" menu
        JMenu fileMenu = new JMenu("Navigation");

        // Create the "Login" menu item
        JMenuItem loginMenuItem = new JMenuItem("Logout");
        loginMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	User.setCurrentUser(null);
            	SwingUtilities.getWindowAncestor(getRootPane()).dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        });
        fileMenu.add(loginMenuItem);

        // Create the "View Mood" menu item
        JMenuItem viewMoodMenuItem = new JMenuItem("View Mood");
        viewMoodMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.getWindowAncestor(getRootPane()).dispose();
                ViewMood viewMood = new ViewMood();
                viewMood.setVisible(true);
            }
        });
        fileMenu.add(viewMoodMenuItem);

        // Create the "Insert Mood" menu item
        JMenuItem insertMoodMenuItem = new JMenuItem("Insert Mood");
        insertMoodMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.getWindowAncestor(getRootPane()).dispose();
                InsertMood insertMood = new InsertMood();
                insertMood.setVisible(true);
            }
        });
        fileMenu.add(insertMoodMenuItem);

        // Add the "File" menu to the menu bar
        add(fileMenu);
    }
}

