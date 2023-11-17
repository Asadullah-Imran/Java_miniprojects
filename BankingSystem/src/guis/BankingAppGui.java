package guis;

import db_objs.User;
import design.CustomButton;
import design.CustomLabel;
import design.CustomLogoutButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    Performs banking function such as Depositiong , withdreawing , seeing past transaction , and transferring
    this extendes from the BaseFrame which means we will need to define out own addGuiComponents
* */
public class BankingAppGui  extends BaseFrame implements ActionListener {
    private JTextField currentBalanceField;
    public JTextField getCurrentBalanceField(){
        return currentBalanceField;
    }
public BankingAppGui(User user){
    super("Banking App",user);

}
    @Override
    protected void addGuiComponents() {
    String welcomeMessage = "<html><body style='text-align:center'><b>Hello " +user.getUsername()+
            "</b><br>What would you like to do today?</body></html>";
        CustomLabel welcomMessageLabel = new CustomLabel(welcomeMessage);
        welcomMessageLabel.setBounds(0,20,getWidth()-10,40);
        welcomMessageLabel.setFont(new Font("dialog",Font.PLAIN,16));
        welcomMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomMessageLabel);



        //CREATE CURRENT BALANCE LABEL
        CustomLabel currentBalanceLabel = new CustomLabel("Current Balance");
        currentBalanceLabel.setBounds(0,80,getWidth()-10,30);
        currentBalanceLabel.setFont(new Font("dialog",Font.PLAIN,22));
        currentBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(currentBalanceLabel);


        //CREATE CURRENT BALANCE FIELD
        currentBalanceField= new JTextField("$"+user.getCurrentBalance());
        currentBalanceField.setBounds(15,120,getWidth()-50,40);
        currentBalanceField.setFont(new Font("dialog",Font.BOLD,28));
        currentBalanceField.setHorizontalAlignment(SwingConstants.RIGHT);
        currentBalanceField.setEditable(false);
        add(currentBalanceField);

        //DEPOSIT BUTTON
        CustomButton depositButton = new CustomButton("Deposit");
        depositButton.setBounds(15,180,getWidth()-50,50);
        depositButton.setFont(new Font("dialog",Font.BOLD,22));
        depositButton.addActionListener(this);
        add(depositButton);

        //WITHDRAW BUTTON
        CustomButton withdrawButton = new CustomButton("Withdraw");
        withdrawButton.setBounds(15,250,getWidth()-50,50);
        withdrawButton.setFont(new Font("dialog",Font.BOLD,22));
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        //PAST TRANSACTION BUTTON
        CustomButton pastTransactionButton = new CustomButton("Past Transaction");
        pastTransactionButton.setBounds(15,320,getWidth()-50,50);
        pastTransactionButton.setFont(new Font("dialog",Font.BOLD,22));
        pastTransactionButton.addActionListener(this);
        add(pastTransactionButton);

        //Transfer BUTTON
        CustomButton transferButton = new CustomButton("Transfer");
        transferButton.setBounds(15,390,getWidth()-50,50);
        transferButton.setFont(new Font("dialog",Font.BOLD,22));
        transferButton.addActionListener(this);
        add(transferButton);

        //Logout BUTTON

        CustomLogoutButton logoutButton = new CustomLogoutButton ("Logout");
        logoutButton.setBounds(15,500,getWidth()-50,50);
        logoutButton.setFont(new Font("dialog",Font.BOLD,22));
        logoutButton.addActionListener(this);
        add(logoutButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        new BankingAppDialog(this, user).setVisible(true);
        String buttonPressed = e.getActionCommand();

        //user pressed logout
        if(buttonPressed.equalsIgnoreCase("Logout")){
            new LoginGui().setVisible(true);
            //dispose of this gui
            this.dispose();

            // don't bother runing the  rest of the code
            return;

        }

        //other functions
        BankingAppDialog bankingAppDialog= new BankingAppDialog(this,user);

        //set the title of the dialog header to the action
        bankingAppDialog.setTitle(buttonPressed);
        //if the button pressed is deposit ,withdraw  or transfer
        if(buttonPressed.equalsIgnoreCase("deposit")||buttonPressed.equalsIgnoreCase("Withdraw")||buttonPressed.equalsIgnoreCase("Transfer")){
            // add in the current balance and amount gui components to the dialog
            bankingAppDialog.addCurrentBalanceAndAmount();

            //add action button
            bankingAppDialog.addActionButton(buttonPressed);


            //for the trasfer action it will require more components
            if(buttonPressed.equalsIgnoreCase("Transfer")){
                bankingAppDialog.addUserField();
            }

        }else if(buttonPressed.equalsIgnoreCase("Past Transaction")) {
            bankingAppDialog.addPastTransactionComponents();
        }
        //make the app dialog visible
        bankingAppDialog.setVisible(true);
    }
}
