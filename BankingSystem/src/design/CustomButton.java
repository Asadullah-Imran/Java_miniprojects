package design;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    public CustomButton(String text){
        super(text);
        initialize();
    }
    private void initialize(){
        setBackground(new Color(0x023e8a)); // Set your desired background color
        setForeground(Color.WHITE); // Set your desired text color
        setFocusPainted(false); // Remove the default border
    }
}
