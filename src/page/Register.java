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
        setTitle("Register");

        setSize(500, 400);

        setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        JButton submitButton = new JButton("Register");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // TODO: Validate the form fields and save the user data
                Main.userDataList.add(new User(username, password));
                
                JOptionPane.showMessageDialog(Register.this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
                showLoginPage();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton loginButton = new JButton("Already have an account");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginPage();
            }
        });
        
        buttonPanel.add(loginButton);
        buttonPanel.add(submitButton);
    
        
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void showLoginPage() {
    	dispose();
        Login login = new Login();
        login.setVisible(true);
    }
}

