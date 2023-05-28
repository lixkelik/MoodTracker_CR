package page;

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

        DefaultTableModel tableModel = new DefaultTableModel(new Object[0][4], new String[]{"Mood", "Intensity", "Date", "Description"});

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        
        try {
            currentUser.getMoodDataList().forEach(moodData -> {
                tableModel.addRow(new Object[]{moodData.getMood(), moodData.getIntensity(), moodData.getDate(), moodData.getDescription()});
            });
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "No mood data found for user", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }

        add(greetings);
        add(scrollPane);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setVisible(true);
    }
}
