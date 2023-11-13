import javax.swing.*;
import java.awt.*;

//render the GUI components (frontend)
public class PasswordGeneratorGUI extends JFrame {
    public PasswordGeneratorGUI(){
        //render frame and a titile
        super("Password Generator");

        //set the size of the GUI
        setSize(540,570);

        setResizable(false);
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Center the GUI to the screen
        setLocationRelativeTo(null);


        //render GUI components
        addGUIComponents();


    }



    private void addGUIComponents(){
        //create title text
        JLabel titleLabel= new JLabel("Password Generator");

        //increase the fontSize
        titleLabel.setFont(new Font("Dialog", Font.BOLD , 32));

        //center the text on the screen
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //set x y coordinates
        titleLabel.setBounds(0,10,540,39);

        // add to GUI
        add(titleLabel);


        //CREATE Result text
        JTextArea passwordOutput = new JTextArea();

        //prevent editing the textArea
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("dialog",Font.BOLD, 32));

        //add scrollablity in case output becomes too big
        JScrollPane passwordOutputPane= new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25,97,479,70);

        //create a black border around the text area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        //create passwordLength label
        JLabel passwordLengthLabel = new JLabel("Password Length");
        passwordLengthLabel.setFont(new Font("Dialog",Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25,215,271,39);
        add(passwordLengthLabel);

        //Password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("dialog",Font.PLAIN,32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310, 215, 192,39);
        add(passwordLengthInputArea);



        //create toggle buttons
        //uppercase latter toggle
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setBounds(25,302,225,56);
        uppercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        add(uppercaseToggle);

        //lowercase toggle button
        JToggleButton lowercaseToggle= new JToggleButton("Lowercase");
        lowercaseToggle.setBounds(282,302,225,56);
        lowercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        add(lowercaseToggle);

        //Numbers latter toggle
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setBounds(25,373,225,56);
        numbersToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        add(numbersToggle);

        //Symbols toggle button
        JToggleButton symbolsToggle= new JToggleButton("Symbols");
        symbolsToggle.setBounds(282,373,225,56);
        symbolsToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        add(symbolsToggle);


        //create generate BUtton
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog",Font.PLAIN,32));
        generateButton.setBounds(155,477,222,41);
        add(generateButton);
    }
}
