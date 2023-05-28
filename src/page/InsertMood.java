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

    JLabel moodLabel, intensityLabel, dateLabel, descriptionLabel;
    JComboBox<String> moodComboBox;
    JSlider intensitySlider;
    JCalendar dateCalendar;
    JTextArea descriptionTextArea;
    JButton submitButton;

    public InsertMood() {
        setTitle("Mood Tracker - Insert Mood");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        NavigationBar navigationBar = new NavigationBar();
        setJMenuBar(navigationBar);

        initializeComponents();
        addComponentsToLayout();
        attachListeners();

        setVisible(true);
    }
    
    private void initializeComponents() {
        moodLabel = new JLabel("Mood:");
        intensityLabel = new JLabel("Intensity:");
        dateLabel = new JLabel("Date:");
        descriptionLabel = new JLabel("Description:");
        moodComboBox = new JComboBox<>(new String[]{"Happy", "Sad", "Angry", "Stressed", "Excited"});
        intensitySlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        dateCalendar = new JCalendar();
        descriptionTextArea = new JTextArea();
        submitButton = new JButton("Submit");
    }
    
    private void addComponentsToLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

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
        add(intensityLabel, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(intensitySlider, c);

        c.gridx = 0;
        c.gridy = 2;
        add(dateLabel, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(dateCalendar, c);

        c.gridx = 0;
        c.gridy = 3;
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
    }
    
    private void attachListeners() {
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String mood = (String) moodComboBox.getSelectedItem();
        int intensity = intensitySlider.getValue();
        Date date = dateCalendar.getDate();
        String description = descriptionTextArea.getText();

        if(User.getCurrentUser() != null) {
        	User u = User.getCurrentUser();
        	u.insertMood(new Mood(mood, intensity, date, description));
            JOptionPane.showMessageDialog(this, "Mood saved successfully!");
        }
        
    }

    
}
