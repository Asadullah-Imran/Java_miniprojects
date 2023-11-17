package design;



import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel {
    public CustomLabel(String text) {
        super(text);
        initialize();
    }

    private void initialize() {
//        setFont(new Font("Dialog", Font.BOLD, 16));
        setForeground(new Color(0x1d3557)); // Set your desired text color
//        setHorizontalAlignment(SwingConstants.CENTER);

        // You can add more customizations here as needed
    }
}

