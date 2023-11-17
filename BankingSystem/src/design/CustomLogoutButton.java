package design;

import javax.swing.*;
import java.awt.*;

public class CustomLogoutButton extends JButton {
    public CustomLogoutButton(String text){
        super(text);
        initialize();
    }
    private void initialize(){
        setBackground(new Color(0xe56b6f)); // Set your desired background color
        setForeground(Color.WHITE); // Set your desired text color
        setFocusPainted(false); // Remove the default border
    }
}
