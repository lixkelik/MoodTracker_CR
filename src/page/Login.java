package page;

import javax.swing.*;
import data.User;
import main.Main;

import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JLabel userLabel, passwordLabel;
    JTextField userTextField;
    JPasswordField passwordField;
    JButton loginButton, resetButton, regisButton;
    public Login() {
        setTitle("Login Form");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        userLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        regisButton = new JButton("Create new account");
        
        JLabel[] lblPanelList = {userLabel, passwordLabel};
        JTextField[] txtFieldList = {userTextField, passwordField};
        JButton[] btnPanelList = {loginButton, resetButton, regisButton};
        
        JPanel labelPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel textFieldPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        for(int i = 0; i < 2; i++) {
        	labelPanel.add(lblPanelList[i]);
        	textFieldPanel.add(txtFieldList[i]);
        }
        for(int i = 0; i < 3; i++) {
        	buttonPanel.add(btnPanelList[i]);
        }

        setLayout(new BorderLayout(10, 10));

        add(labelPanel, BorderLayout.WEST);
        add(textFieldPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        resetButton.addActionListener(this);
        regisButton.addActionListener(this);
        loginButton.addActionListener(this);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            performLogin();
        } else if (ae.getSource() == resetButton) {
            resetFields();
        } else if (ae.getSource() == regisButton) {
            navigateToRegistration();
        }
    }

    private void performLogin() {
        String username = userTextField.getText();
        String password = new String(passwordField.getPassword());

        boolean validLogin = validateLogin(username, password);

        if (validLogin) {
            showLoginSuccessMessage();
            dispose();
            navigateToViewMood();
        } else {
            showLoginFailureMessage();
        }
    }

    private boolean validateLogin(String username, String password) {
        for (User userData : Main.userDataList) {
            if (userData.getUsername().equals(username) && userData.getPassword().equals(password)) {
                User.setCurrentUser(userData);
                return true;
            }
        }
        return false;
    }

    private void showLoginSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Login successful");
    }

    private void showLoginFailureMessage() {
        JOptionPane.showMessageDialog(this, "Invalid username or password");
    }

    private void resetFields() {
        userTextField.setText("");
        passwordField.setText("");
    }

    private void navigateToRegistration() {
        dispose();
        Register regis = new Register();
        regis.setVisible(true);
    }

    private void navigateToViewMood() {
        ViewMood viewMood = new ViewMood();
        viewMood.setVisible(true);
    }

}
