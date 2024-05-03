package View;
import javax.swing.*;

import Controller.DBController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        
        add(usernameField);
        add(passwordField);
        add(loginButton);
        add(registerButton);

        DBController dbController = new DBController();

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dbController.checkUser(usernameField.getText(), new String(passwordField.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Welcome!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dbController.addUser(usernameField.getText(), new String(passwordField.getPassword()));
                JOptionPane.showMessageDialog(null, "Registration successful.");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
