package guis;

import constans.CommonConstants;

import javax.swing.*;
import java.awt.*;

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


   }
}
