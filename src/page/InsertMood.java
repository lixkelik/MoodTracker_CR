package page;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import com.toedter.calendar.JCalendar;

import data.Mood;
import data.User;
import main.NavigationBar;

public class InsertMood extends JFrame implements ActionListener {

    // Declare the components
    JLabel moodLabel, intensityLabel, dateLabel, descriptionLabel;
    JComboBox<String> moodComboBox;
    JSlider intensitySlider;
    JCalendar dateCalendar;
    JTextArea descriptionTextArea;
    JButton submitButton;

    // Constructor
    public InsertMood() {
        // Set the frame properties
        setTitle("Mood Tracker - Insert Mood");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        NavigationBar navigationBar = new NavigationBar();
        setJMenuBar(navigationBar);
        
        // Create the components
        moodLabel = new JLabel("Mood:");
        intensityLabel = new JLabel("Intensity:");
        dateLabel = new JLabel("Date:");
        descriptionLabel = new JLabel("Description:");
        moodComboBox = new JComboBox<>(new String[]{"Happy", "Sad", "Angry", "Stressed", "Excited"});
        intensitySlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        dateCalendar = new JCalendar();
        descriptionTextArea = new JTextArea();
        submitButton = new JButton("Submit");

        // Set the layout
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Add the components to the frame
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(5, 5, 5, 5);
        add(moodLabel, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(moodComboBox, c);

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;
        add(intensityLabel, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(intensitySlider, c);

        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_END;
        add(dateLabel, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(dateCalendar, c);

        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_END;
        add(descriptionLabel, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        add(new JScrollPane(descriptionTextArea), c);

        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        add(submitButton, c);

        // Add the action listeners
        submitButton.addActionListener(this);

        
        
        // Show the frame
        setVisible(true);
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent ae) {
        // Get the selected values
        String mood = (String) moodComboBox.getSelectedItem();
        int intensity = intensitySlider.getValue();
        Date date = dateCalendar.getDate();
        String description = descriptionTextArea.getText();

        // Do something with the selected values (e.g. save to database)
        if(User.getCurrentUser() != null) {
        	User u = User.getCurrentUser();
        	u.insertMood(new Mood(mood, intensity, date, description));
        	// Show a message to the user
            JOptionPane.showMessageDialog(this, "Mood saved successfully!");
        }
        
    }

    // Main method
    public static void main(String[] args) {
        new InsertMood();
    }
}
