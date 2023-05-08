package page;

import javax.swing.*;

import data.User;
import main.Main;

import java.awt.*;
import java.awt.event.*;

public class Register extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Register() {
        // Set the title of the frame
        setTitle("Register");

        // Set the size of the frame
        setSize(500, 400);

        // Set the location of the frame
        setLocationRelativeTo(null);

        // Create a panel to hold the form fields
        JPanel formPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        // Create a label and text field for the username
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);

        // Create a label and password field for the password
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Create a button to submit the form
        JButton submitButton = new JButton("Register");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // TODO: Validate the form fields and save the user data
                Main.userDataList.add(new User(username, password));
                
                JOptionPane.showMessageDialog(Register.this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
                dispose(); // Close the current frame
                Login login = new Login();
                login.setVisible(true);
            }
        });

     // Create a panel to hold the submit button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
     // Create a button to redirect to the login page
        JButton loginButton = new JButton("Already have an account");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
                Login login = new Login();
                login.setVisible(true);
            }
        });
        
        buttonPanel.add(loginButton);
        buttonPanel.add(submitButton);
    
        // Add the form panel and button panel to the frame
        
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    
}

