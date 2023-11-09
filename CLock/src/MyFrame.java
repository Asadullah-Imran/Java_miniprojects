import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String date;
    String day;
    int color1=0x012a4a;
    int color2=0x2a6f97;
    int padding = 20;
    Border paddingBorder = BorderFactory.createEmptyBorder(padding, padding, padding, padding);
    ImageIcon appIcon= new ImageIcon("src/assets/clock.png");
    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("CLock");
        this.setLayout(new FlowLayout());
        this.setSize(390,240);
        this.setResizable(false);
        this.setIconImage(appIcon.getImage());

        this.setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Create a custom gradient paint
                GradientPaint gradient = new GradientPaint(0, 0, new Color(color1), 0, getHeight(), new Color(color2));
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        });
        // Get the content pane and set the EmptyBorder to it
        Container contentPane = this.getContentPane();
        if (contentPane instanceof JComponent) {
            ((JComponent) contentPane).setBorder(paddingBorder);
        }


        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("E");
        dateFormat= new SimpleDateFormat("MMMM dd, yyyy");
        timeLabel= new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN,50));
        timeLabel.setForeground(new Color(0xffffff));



        dayLabel=new JLabel();
        dayLabel.setFont(new Font("Verdana", Font.PLAIN,35));
        dayLabel.setForeground(new Color(0xffffff));



        dateLabel=new JLabel();
        dateLabel.setFont(new Font("Verdana", Font.PLAIN,28));
        dateLabel.setForeground(new Color(0xffffff));





        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);
        setTime();
    }

    public void setTime(){
        while (true){
            time= timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day= dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date= dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
