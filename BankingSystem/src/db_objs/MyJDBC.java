package db_objs;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

//JDBC class is used to interact with our MYSQL database to perform activites such as retrieving and updatin our db
public class MyJDBC {
    //database configuration
    private static final String DB_URL ="jdbc:mysql://127.0.0.1:3306/bankapp";
    private static final String DB_USERNAME= "root";
    private static  final String DB_PASSWORD="asdf";

    //if valid return an object with the user's information
    public static User validateLogin(String username, String password){
        try {
            //establish a connerction to the database using configuration
            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            //create sql query
            PreparedStatement preparedStatement= connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND password= ?"
            );
            //replace the ? with values
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            //execute query and store into a resut set
            ResultSet resultSet = preparedStatement.executeQuery();

            //next() return true or false
            //true - query returned data and result set now points to the firtst row
            // false - quwry returned no dat aand resut set wquals to null
            if(resultSet.next()){
                //success
                //get id
                int userId=resultSet.getInt("id");

                //get currentbalance
                BigDecimal currentBalance= resultSet.getBigDecimal("current_balance");

                //return user object
                return  new User(userId,username,password,currentBalance);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        //not valid user
        return  null;
    }

    //true - register success
    //false - rtegister failed
    public static boolean register(String username,String password){
        try{
            //first we will need to check if the username has already been taken
            if(!checkUser(username)){
                Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);

                PreparedStatement preparedStatement= connection.prepareStatement(
                        "INSERT INTO users(username,password,current_balance)"+"VALUES(? ,?,?)"
                );
                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                preparedStatement.setBigDecimal(3,new BigDecimal(0));

                preparedStatement.executeUpdate();
                return true;
            }
    }catch (SQLException e){
        e.printStackTrace();}
        return false;
    }

    //check if username already wxists in the db
    //true - user exists
    //false - user doesn't exist
    private  static boolean checkUser(String username){
        try{
            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            PreparedStatement preparedStatement= connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"
            );
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            //this means that the query returned no data meaning that the username is available
            if(!resultSet.next()){
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    //true- update to db was a success
    //false- wpdate to db was not success
    public static boolean addTransactionToDatabase(Transaction transaction){
        try{
            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            PreparedStatement insertTransaction= connection.prepareStatement(
                    "INSERT transactions(user_id, transaction_type,transaction_amount,transaction_date)"+
                            "VALUES(?,?,?, NOW())"
            );

            insertTransaction.setInt(1,transaction.getUserId());
            insertTransaction.setString(2,transaction.getTransactionType());
            insertTransaction.setBigDecimal(3,transaction.getTransactionAmount());

            //update database
            insertTransaction.executeUpdate();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //true- update balance success
    //false- wpdate blance was not success
    public static  boolean updateCurrentBalance(User user){
        try{
            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            PreparedStatement updateBalance= connection.prepareStatement(
                    "UPDATE users SET current_balance = ? WHERE id = ?"
            );

            updateBalance.setBigDecimal(1,user.getCurrentBalance());
            updateBalance.setInt(2,user.getId());

            updateBalance.executeUpdate();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    //true- transfer was a success
    //false - transfer was a fail
    public static boolean transfer(User user, String transferredUsername, float transferAmount){
        try {
            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            PreparedStatement queryUser= connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"
            );

            queryUser.setString(1,transferredUsername);
            ResultSet resultSet= queryUser.executeQuery();

            while(resultSet.next()){
                User transferredUser = new User(
                        resultSet.getInt("id"),
                        transferredUsername,
                        resultSet.getString("password"),
                        resultSet.getBigDecimal("current_balance")
                );
                //create transaction
                Transaction transferTransaction = new Transaction(
                        user.getId(),
                        "Transfer",
                        new BigDecimal(-transferAmount),
                        null
                );

                //this transaction will belong to the transferred user
                Transaction recievedTransaction = new Transaction(
                        transferredUser.getId(),
                        "Transfer",
                new BigDecimal(transferAmount),
                null
                );

                //update transfer user
                transferredUser.setCurrentBalance(transferredUser.getCurrentBalance().add(BigDecimal.valueOf(transferAmount)));
                updateCurrentBalance(transferredUser);

                //update user current balance
                user.setCurrentBalance(user.getCurrentBalance().subtract(BigDecimal.valueOf(transferAmount)));
                updateCurrentBalance(user);

                //add this thransaction to the database
                addTransactionToDatabase(transferTransaction);
                addTransactionToDatabase(recievedTransaction);
                return true;
            }




        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //get all transactions (used for past transaction )
    public static ArrayList <Transaction> getPastTransaction(User user){
        ArrayList <Transaction> pastTransaction = new ArrayList<>();
        try {
            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            PreparedStatement selectAllTransaction= connection.prepareStatement(
                    "SELECT * FROM transactions WHERE user_id = ? ORDER BY transaction_date DESC"
            );
            selectAllTransaction.setInt(1,user.getId());

            ResultSet resultSet = selectAllTransaction.executeQuery();

            //iteration through rhe result (if any)
            while(resultSet.next()){
                //create transaction obj
                Transaction transaction = new Transaction(
                        user.getId(),
                        resultSet.getString("transaction_type"),
                        resultSet.getBigDecimal("transaction_amount"),
                        resultSet.getDate("transaction_date")
                );
                //store into arraylist
                pastTransaction.add(transaction);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return pastTransaction;
    }


}
