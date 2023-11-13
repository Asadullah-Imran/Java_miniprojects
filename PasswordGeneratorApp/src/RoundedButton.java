import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    // Default and clicked colors for the button
    private static final Color DEFAULT_COLOR = Color.decode("#00b4d8");
    private static final Color CLICKED_COLOR = Color.decode("#0077b6"); // Light blue color

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false); // Disable focus effect
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Check if the button is pressed or selected
        if (getModel().isArmed() || getModel().isSelected()) {
            g.setColor(CLICKED_COLOR); // Set background color when clicked or selected
            setForeground(Color.WHITE); // Set text color to white
        } else {
            g.setColor(DEFAULT_COLOR); // Set default background color
            setForeground(Color.WHITE); // Set text color to white
        }
        // Draw rounded rectangle as the background
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Draw rounded rectangle as the border
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
    }
}

class RoundedToggleButton extends JToggleButton {
    public RoundedToggleButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false); // Disable focus effect
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Check if the toggle button is selected
        if (getModel().isSelected()) {
            g.setColor(Color.decode("#0C63E7")); // Set background color when selected
            setForeground(Color.WHITE); // Set text color to white
        } else {
            g.setColor(Color.lightGray); // Set background color when not selected
            setForeground(Color.WHITE); // Set text color to white
        }
        // Draw rounded rectangle as the background
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Draw rounded rectangle as the border
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
    }
}
