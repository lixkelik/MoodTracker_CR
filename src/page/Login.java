package page;

import javax.swing.*;
import data.User;
import main.Main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Login extends JFrame implements ActionListener {
	// Declare the components
    JLabel userLabel, passwordLabel;
    JTextField userTextField;
    JPasswordField passwordField;
    JButton loginButton, resetButton, regisButton;

    // Constructor
    public Login() {
        // Set the frame properties
        setTitle("Login Form");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create the components
        userLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        regisButton = new JButton("Create new account");

        // Create panels for the components
        JPanel labelPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel textFieldPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Add the components to the panels
        labelPanel.add(userLabel);
        labelPanel.add(passwordLabel);

        textFieldPanel.add(userTextField);
        textFieldPanel.add(passwordField);

        buttonPanel.add(loginButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(regisButton);

        // Set the layout
        setLayout(new BorderLayout(10, 10));

        // Add the panels to the frame
        add(labelPanel, BorderLayout.WEST);
        add(textFieldPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add the action listeners
        resetButton.addActionListener(this);
        regisButton.addActionListener(this);
        loginButton.addActionListener(this);

        // Show the frame
        setVisible(true);
    }


    // ActionListener implementation
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            // Check if the username and password are correct
            String username = userTextField.getText();
            String password = new String(passwordField.getPassword());

            boolean validLogin = false;

            for (User userData : Main.userDataList) {
                if (userData.getUsername().equals(username) && userData.getPassword().equals(password)) {
                    validLogin = true;
                    User.setCurrentUser(userData);
                    break;
                }
            }

            if (validLogin) {
            	
                JOptionPane.showMessageDialog(this, "Login successful");
                dispose();
                ViewMood viewMood = new ViewMood();
                viewMood.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } else if (ae.getSource() == resetButton) {
            // Clear the username and password fields
            userTextField.setText("");
            passwordField.setText("");
        }
        else if(ae.getSource() == regisButton) {
        	dispose(); // Close the current frame
            Register regis = new Register();
            regis.setVisible(true);
        }
    }
}
