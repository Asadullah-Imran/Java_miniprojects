package guis;


import db_objs.MyJDBC;
import db_objs.Transaction;
import db_objs.User;
import design.CustomButton;
import design.CustomLabel;
import design.CustomPanel;
import design.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

//Display a custom dialog for our BankingAPPGui
public class BankingAppDialog extends JDialog implements ActionListener {
    private User user;
    private BankingAppGui bankingAppGui;
    private CustomLabel balanceLabel, enterAmountLabel, enterUserLabel;
    private CustomTextField enterAmountField, enterUserField;
    private CustomButton actionButton;
//past transaction components
    private CustomPanel pastTransactionPanel;
    private ArrayList <Transaction> pastTransactions;
    public BankingAppDialog(BankingAppGui bankingAppGui,User user){
        setSize(400,400);
        //add focus to the dialog (can't interact with anything else untiol dialog is closed
        setModal(true);
        //loads in the center of out banking gui
        setLocationRelativeTo(bankingAppGui);

       //when user closes dialog it releases its resources that are being used
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);

       setResizable(false);
       setLayout(null);
       //we will need reference to gui so that we can update the current balance
       this.bankingAppGui=bankingAppGui;
       //we will need access to access the user info to make updates to our db or retrieve data about the user
       this.user=user;
    }
    public  void addCurrentBalanceAndAmount(){
        //balance label
        balanceLabel = new CustomLabel("Balance: $"+user.getCurrentBalance());
        balanceLabel.setBounds(0,10,getWidth()-20,20);
        balanceLabel.setFont(new Font("Dialog" ,Font.BOLD,16));
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(balanceLabel);

        //enter amount label
        enterAmountLabel = new CustomLabel("Enter Amount:");
        enterAmountLabel.setBounds(0,50,getWidth()-20,20);
        enterAmountLabel.setFont(new Font("Dialog" ,Font.BOLD,16));
        enterAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterAmountLabel);

        //enter amount field
        enterAmountField = new CustomTextField();
        enterAmountField.setBounds(15,80,getWidth()-50,40);
        enterAmountField.setFont(new Font("Dialog" ,Font.BOLD,20));
        enterAmountField.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterAmountField);
    }

    public void addActionButton(String actionButtonType){
        actionButton = new CustomButton(actionButtonType);
        actionButton.setBounds(15,300,getWidth()-50,40);
        actionButton.setFont(new Font("Dialog" ,Font.BOLD,20));
        actionButton.addActionListener(this);
        add(actionButton);
    }

    public void addUserField(){
        //enter user label
        enterUserLabel = new CustomLabel("Enter User:");
        enterUserLabel.setBounds(0,160,getWidth()-20,20);
        enterUserLabel.setFont(new Font("Dialog" ,Font.BOLD,16));
        enterUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterUserLabel);

        //enter user field
        enterUserField = new CustomTextField();
        enterUserField.setBounds(15,190,getWidth()-50,40);
        enterUserField.setFont(new Font("Dialog" ,Font.BOLD,20));
        enterUserField.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterUserField);
    }

    public void addPastTransactionComponents(){
        //container where we will store each transaction
        pastTransactionPanel= new CustomPanel();

        //make layout 1x1
        pastTransactionPanel.setLayout(new BoxLayout(pastTransactionPanel, BoxLayout.Y_AXIS));
        //add scrollablity to the container
        JScrollPane scrollPane= new JScrollPane(pastTransactionPanel);
        //displays the vertical scroll only when it is required
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(10,20,getWidth()-30,getHeight()-70);

        //perform db call to retrieve all of the past transaction and store intto arraylist
        pastTransactions=MyJDBC.getPastTransaction(user);

        //iterate through the list and to the gui
        for(int i=0; i<pastTransactions.size();i++){
            //store current transaction
            Transaction pastTransaction = pastTransactions.get(i);

            //create a container to store an individual transaction
            CustomPanel pastTransactionContainer = new CustomPanel();
            pastTransactionContainer.setLayout(new BorderLayout());

            //create transaction type label
            CustomLabel transactionTypeLabel = new CustomLabel(pastTransaction.getTransactionType());
            transactionTypeLabel.setFont(new Font("Dialog",Font.BOLD,20));

            //create transaction amount label
            CustomLabel transactionAmountLabel = new CustomLabel(String.valueOf(pastTransaction.getTransactionAmount()));
            transactionAmountLabel.setFont(new Font("Dialog",Font.BOLD,20));

            //create transactiondate label
            CustomLabel transactionDateLabel = new CustomLabel(String.valueOf(pastTransaction.getTransactionDate()));
            transactionDateLabel.setFont(new Font("Dialog",Font.BOLD,20));

            //add to the container
            pastTransactionContainer.add(transactionTypeLabel,BorderLayout.WEST);
            pastTransactionContainer.add(transactionAmountLabel,BorderLayout.EAST);
            pastTransactionContainer.add(transactionDateLabel,BorderLayout.SOUTH);

            //give a while background to each container
            pastTransactionContainer.setBackground(Color.WHITE);

            //give a black border to each transaction container
            pastTransactionContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            //add transaction component to the transaction label
            pastTransactionPanel.add(pastTransactionContainer);

        }


        //add to the dialog
        add(scrollPane);

    }
    private void handleTransaction(String transactionType, float amountVal){
        Transaction transaction;
        if(transactionType.equalsIgnoreCase("Deposit")){
            //deposit transactiontype
            //add to current balance
            user.setCurrentBalance(user.getCurrentBalance().add(new BigDecimal(amountVal)));

            //create transaction
            //leaving date null because we get date by now function later
            transaction= new Transaction(user.getId(),transactionType,new BigDecimal(amountVal),null);
        }else{
            //withdraw transactiontype
            //subtrract current balance
            user.setCurrentBalance(user.getCurrentBalance().subtract(new BigDecimal(amountVal)));
            //we want to show a negative sign for the amount val whel=n withdrawing
            transaction= new Transaction(user.getId(),transactionType,new BigDecimal(-amountVal),null);
        }
        //update database
        if(MyJDBC.addTransactionToDatabase(transaction) && MyJDBC.updateCurrentBalance(user)){
            //show success dialog
            JOptionPane.showMessageDialog(this,transactionType+" Successfully!");

            //reset the field
            resetFieldAndUpdateCurrentBalance();
        }else{
            JOptionPane.showMessageDialog(this,"Failed...");
        }
    }

    private void resetFieldAndUpdateCurrentBalance(){
        enterAmountField.setText("");;

        //only appears when transfer is clicked
        if(enterUserField!=null){
            enterUserField.setText("");
        }

        //update current balance on dialog
        balanceLabel.setText("Balance: $"+user.getCurrentBalance());

        //update current balance on main gui
        bankingAppGui.getCurrentBalanceField().setText("$"+user.getCurrentBalance());

    }

    private void handleTransfer(User user, String transferredUser, float amount){
            //attempt to perform transfer
        if(MyJDBC.transfer(user,transferredUser,amount)){
            //show success message dialog
            JOptionPane.showMessageDialog(this,"Transfer Success!");
            resetFieldAndUpdateCurrentBalance();
        }else{
            //show failure dialog
            JOptionPane.showMessageDialog(this,"Transfer Failed...");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonPressed= e.getActionCommand();

        //get amoutnt val
        float   amountVal =Float.parseFloat(enterAmountField.getText());
        //pressed deposit
        if(buttonPressed.equalsIgnoreCase("Deposit")){
            //We want to handle the deposit transaction
        handleTransaction(buttonPressed,amountVal);
        }else{
            //pressed withdraw or transfer

            //validate input by making sure that withdraw or transfer amount is less than current balance
            //if result is -1 it means that the entered amount is more, 0 means they are equal , and 1 means that
            // the entered amount is less
            int result = user.getCurrentBalance().compareTo(BigDecimal.valueOf(amountVal));
                if(result<0){
                    //display error dialog
                    JOptionPane.showMessageDialog(this,"Error: Input value is more than current balance ");
                 return;
                }
                //check to seee if withdraw or transfer was pressed
                if(buttonPressed.equalsIgnoreCase("Withdraw")){
                    handleTransaction(buttonPressed,amountVal);;
                }else{
                    //transfer
                    String transferedUser = enterUserField.getText();

                    //handle transfer
                    handleTransfer(user,transferedUser,amountVal);
                }
            }
        }
    }

