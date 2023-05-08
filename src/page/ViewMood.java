package page;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import data.User;
import main.NavigationBar;

public class ViewMood extends JFrame {
    private JLabel greetings;

    public ViewMood() {
        // Create a new frame
        super("Mood Data");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        // Create the navigation bar
        NavigationBar navigationBar = new NavigationBar();
        setJMenuBar(navigationBar);

        // Get the current user
        User currentUser = User.getCurrentUser();

        // Create the greetings label
        greetings = new JLabel("Hello, " + currentUser.getUsername());

        // Create the table model with the mood data
        String[] columns = {"Mood", "Intensity", "Date", "Description"};
        Object[][] data = new Object[currentUser.moodDataList.size()][4];

        for (int i = 0; i < currentUser.moodDataList.size(); i++) {
            data[i][0] = currentUser.moodDataList.get(i).getMood();
            data[i][1] = currentUser.moodDataList.get(i).getIntensity();
            data[i][2] = currentUser.moodDataList.get(i).getDate();
            data[i][3] = currentUser.moodDataList.get(i).getDescription();
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columns);

        // Create the table and scroll pane
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the greetings and scroll pane to the frame
        add(greetings);
        add(scrollPane);

        // Set the layout of the frame
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Show the frame
        setVisible(true);
    }
}
