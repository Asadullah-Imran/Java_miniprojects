import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener {
    String[] questions={"Which Company Created Java?",
            "Which year was Java created?",
            "What was Java originally called?",
            "Who is credited with creating Java",
            "Keyword is used to define a constant variable?",
            "What is the purpose of the 'this' keyword?",
            "Accessible only within the same package?",
            "Prevent a method from being overridden?",
            "keyword used to create an instance of a class?",
            "What does the static keyword indicate?"
    };



    String[][] options= {
            {"Sun Microsystem","Starbucks","Microsoft","Alphabet"},
            {"1989","1996","1972","1492"},
            {"Apple","Latte","Oak","Koffing"},
            {"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerberg"},
            {"static", "final", "const", "var"},
            { "references the current object." ,"declares a new variable." ,"used for exception handling.", "creates a new class."},
            { "public" ,"private" ,"protected" ,"default"},
            {"static", "final", "abstract", "void"},
            {"instanceof", "new", "class", "this"},
            {"it can be overridden." ,"it belongs to the class.", "The method is abstract.", "it belongs to instance"}
    };
    char[] answers={'A','B','C','C','B','A','D','B','B','B'};
    char guess;
    char answer;
    int index;
    int correctGuesses;
    int totalQuestion=questions.length;
    int result;
    int seconds=15;

    JFrame frame= new JFrame();
    JTextField textField= new JTextField();
    JTextArea textArea= new JTextArea();
    JButton buttonA= new JButton();
    JButton buttonB= new JButton();
    JButton buttonC= new JButton();
    JButton buttonD= new JButton();
    JLabel answerLabelA= new JLabel();
    JLabel answerLabelB= new JLabel();
    JLabel answerLabelC= new JLabel();
    JLabel answerLabelD= new JLabel();
    JLabel timeLabel= new JLabel();
    JLabel secondsLeft = new JLabel();
    JTextField numberRight= new JTextField();
    JTextField percentage = new JTextField();


    Timer timer= new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));
            if(seconds<=0){
                displayAnswer();
            }

        }
    });

    int clr1=0x0077ff;
    int clr2=0x00c3ff;
    int clr3=0x2e77cb;
    int titleBack=0x114d97;


    public Quiz(){
        ImageIcon appIcon= new ImageIcon("src/assets/logo.png");
frame.setIconImage(appIcon.getImage());
        frame.setTitle("Quiz App");

            // 00c3ff
        //0077ff
        // FFDE59  FF914D
        // Create a custom gradient color for the background
        //Color color2 = new Color(0x0077ff); // #ffde59 (Yellow)
        //Color color1 = new Color(0x00c3ff); // #ff914d (Orange)

        //GradientPaint gradient = new GradientPaint(0, 0, color1, 0, frame.getHeight(), color2);

        frame.setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                //super.paintComponent(g);

                // Create a custom gradient paint
                GradientPaint gradient = new GradientPaint(0, 0, new Color(titleBack), 0, getHeight(), new Color(clr3));
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        });






        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        //frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        //textField
        textField.setBounds(0,0,650,50);
        textField.setBackground(new Color(titleBack));
        textField.setForeground(new Color(255,255,255));
        textField.setFont(new Font("Ink Free",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        //textField.setText("Testing Text");

        //textArea

        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
//        textArea.setOpaque(false);
        textArea.setBackground(new Color(titleBack));
        textArea.setForeground(new Color(255,255,255));
        textArea.setFont(new Font("MV Boli",Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
//        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
//        textArea.setAlignmentY(Component.CENTER_ALIGNMENT);


        textArea.setEditable(false);
        //textArea.setText("sample textarea");

        //buttons
        buttonA.setBounds(0,100,100,100);
        buttonA.setBackground(new Color(titleBack));
        buttonA.setForeground(new Color(255,255,255));
        buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,100);
        buttonB.setBackground(new Color(titleBack));
        buttonB.setForeground(new Color(255,255,255));
        buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,300,100,100);
        buttonC.setBackground(new Color(titleBack));
        buttonC.setForeground(new Color(255,255,255));
        buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setBackground(new Color(titleBack));
        buttonD.setForeground(new Color(255,255,255));
        buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");


        answerLabelA.setBounds(125,100,500,100);
        answerLabelA.setBackground(new Color(50,50,50));
        answerLabelA.setForeground(new Color(255,255,255));
        answerLabelA.setFont(new Font("MV Boli",Font.PLAIN,30));

        answerLabelB.setBounds(125,200,500,100);
        answerLabelB.setBackground(new Color(50,50,50));
        answerLabelB.setForeground(new Color(255,255,255));
        answerLabelB.setFont(new Font("MV Boli",Font.PLAIN,30));

        answerLabelC.setBounds(125,300,500,100);
        answerLabelC.setBackground(new Color(50,50,50));
        answerLabelC.setForeground(new Color(255,255,255));
        answerLabelC.setFont(new Font("MV Boli",Font.PLAIN,30));

        answerLabelD.setBounds(125,400,500,100);
        answerLabelD.setBackground(new Color(50,50,50));
        answerLabelD.setForeground(new Color(255,255,255));
        answerLabelD.setFont(new Font("MV Boli",Font.PLAIN,30));


        secondsLeft.setBounds(535,510,100,100);
        secondsLeft.setBackground(new Color(25,25,25));
        secondsLeft.setForeground(new Color(255,15,15));
        secondsLeft.setFont(new Font("Ink Free",Font.BOLD,60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        timeLabel.setBounds(535,475,100,25);
//        timeLabel.setBackground(new Color(0,255,0));
        timeLabel.setForeground(new Color(165,0,33));
        timeLabel.setFont(new Font("Ink Free",Font.BOLD,20));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("timer: ");

        numberRight.setBounds(225,225,200,100);
        numberRight.setBackground(new Color(25,25,25));
        numberRight.setForeground(new Color(25,255,0));
        numberRight.setFont(new Font("Ink Free",Font.BOLD,50));
        numberRight.setBorder(BorderFactory.createBevelBorder(1));
        numberRight.setHorizontalAlignment(JTextField.CENTER);
        numberRight.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Ink Free",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);




//    frame.add(percentage);
//    frame.add(numberRight);

        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textField);
        frame.add(textArea);
        frame.add(timeLabel);
        frame.add(secondsLeft);
        frame.setVisible(true);

        //method start
        nextQuestion();


    }
    public void nextQuestion(){
    if (index>=totalQuestion){
        results();
    }else{
        textField.setText("Question "+(index+1));
        textArea.setText(questions[index]);
        answerLabelA.setText(options[index][0]);
        answerLabelB.setText(options[index][1]);
        answerLabelC.setText(options[index][2]);
        answerLabelD.setText(options[index][3]);
        timer.start();
    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%HERE BRO DO NOT USE ELSE%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        if(e.getSource()==buttonA){
            answer='A';
            if (answer==answers[index]){
                correctGuesses++;
            };
        } else if(e.getSource()==buttonB){
            answer='B';
            if (answer==answers[index]){
                correctGuesses++;
            };
        }else if(e.getSource()==buttonC){
            answer='C';
            if (answer==answers[index]){
                correctGuesses++;
            };
        }else if(e.getSource()==buttonD){
            answer='D';
            if (answer==answers[index]){
                correctGuesses++;
            };
        }
        displayAnswer();
    }
    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index]!='A'){
            answerLabelA.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='B'){
            answerLabelB.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='C'){
            answerLabelC.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='D'){
            answerLabelD.setForeground(new Color(255,0,0));
        }

        //we are creating a timer
        Timer pause= new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerLabelA.setForeground(new Color(255,255,255));
                answerLabelB.setForeground(new Color(255,255,255));
                answerLabelC.setForeground(new Color(255,255,255));
                answerLabelD.setForeground(new Color(255,255,255));

                answer= ' ';
                seconds=15;
                secondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();

    }
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result=(int)((correctGuesses/(double)totalQuestion)*100);
        textField.setText("Results!");

        answerLabelA.setText("");
        answerLabelB.setText("");
        answerLabelC.setText("");
        answerLabelD.setText("");
        if(result>=50){
            textArea.setText("Well done!");
        }else if (result>=80){
            textArea.setText("That's a great shot man!");
        } else if (result==100) {
            textArea.setText("Excellent!");
        } else if (result<50) {
            textArea.setText("Nice try!");
        }


        numberRight.setText("("+correctGuesses+"/"+totalQuestion+")");
        percentage.setText(result+"%");

        frame.add(numberRight);
        frame.add(percentage);

    }
}
