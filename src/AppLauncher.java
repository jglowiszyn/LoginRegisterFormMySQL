import db.MyJDBC;
import guis.Form;
import guis.LoginFormGUI;
import guis.RegisterFormGUI;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
               new LoginFormGUI().setVisible(true);

                //System.out.println(MyJDBC.checkUser("username"));

               // System.out.println(MyJDBC.register("username124", "$ocz3wki"));

               // System.out.println(MyJDBC.validateLogin("username1234", "$ocz3wki"));
            }
        });
    }
}