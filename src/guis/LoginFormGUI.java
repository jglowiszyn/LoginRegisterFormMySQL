package guis;

import constans.CommonConstants;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFormGUI extends Form {
    public LoginFormGUI() {
        super("Login");
        addGuiComponents();
    }

       private void addGuiComponents(){
            JLabel loginLabel = new JLabel("Login");
            loginLabel.setBounds(0, 25, 520, 100);
            loginLabel.setForeground(CommonConstants.TEXT_COLOR);
            loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));
            loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(loginLabel);

            JLabel usernameLabel = new JLabel("Username: ");
            usernameLabel.setBounds(30,150,400,25);
            usernameLabel.setForeground(CommonConstants.TEXT_COLOR);
            usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            JTextField usernameField = new JTextField();
            usernameField.setBounds(30,185,450,55);
            usernameField.setBackground(CommonConstants.SECONDARY_COLOR);
            usernameField.setForeground(CommonConstants.TEXT_COLOR);
            usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));

            add(usernameLabel);
            add(usernameField);

           JLabel passwordLabel = new JLabel("Password: ");
           passwordLabel.setBounds(30,335,400,25);
           passwordLabel.setForeground(CommonConstants.TEXT_COLOR);
           passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

           JTextField passwordField = new JPasswordField();
           passwordField.setBounds(30,365,450,55);
           passwordField.setBackground(CommonConstants.SECONDARY_COLOR);
           passwordField.setForeground(CommonConstants.TEXT_COLOR);
           passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

           add(passwordLabel);
           add(passwordField);

           JButton loginButton = new JButton("Login");
           loginButton.setFont(new Font("Dialog", Font.BOLD, 18));

           loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           loginButton.setBackground(CommonConstants.TEXT_COLOR);
           loginButton.setBounds(125,520,250,50);
           loginButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   String username = usernameField.getText();

                   String password = new String(((JPasswordField) passwordField).getPassword());

                   if (MyJDBC.validateLogin(username, password)){
                       JOptionPane.showMessageDialog(LoginFormGUI.this,
                               "Login Succesful!");
                   } else {
                       JOptionPane.showMessageDialog(LoginFormGUI.this,
                               "Login Failed...");
                   }
               }
           });
           add(loginButton);

           JLabel registerLabel = new JLabel("Not a user? Register Here");
           registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
           registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           registerLabel.setForeground(CommonConstants.TEXT_COLOR);

           registerLabel.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   LoginFormGUI.this.dispose();

                   new RegisterFormGUI().setVisible(true);
               }
           });
           registerLabel.setBounds(125,600,250,30);
           add(registerLabel);
   }
}
