package design;

import javax.swing.*;
import java.awt.*;

public class CustomPasswordField extends JPasswordField {
    public CustomPasswordField(){
        initialize();
    }
    private void initialize() {
//        setFont(new Font("Dialog", Font.BOLD, 20));
//        setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(new Color(0xf5f1ed)); // Set your desired background color
        setForeground(new Color(0x252323)); // Set your desired text color

        // You can add more customizations here as needed
    }
}
