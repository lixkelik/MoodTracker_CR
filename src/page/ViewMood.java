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
        super("Mood Data");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        NavigationBar navigationBar = new NavigationBar();
        setJMenuBar(navigationBar);

        User currentUser = User.getCurrentUser();

        greetings = new JLabel("Hello, " + currentUser.getUsername());

        String[] columns = {"Mood", "Intensity", "Date", "Description"};
        Object[][] data = new Object[currentUser.moodDataList.size()][4];

        for (int i = 0; i < currentUser.moodDataList.size(); i++) {
            data[i][0] = currentUser.moodDataList.get(i).getMood();
            data[i][1] = currentUser.moodDataList.get(i).getIntensity();
            data[i][2] = currentUser.moodDataList.get(i).getDate();
            data[i][3] = currentUser.moodDataList.get(i).getDescription();
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columns);

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(greetings);
        add(scrollPane);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setVisible(true);
    }
}
