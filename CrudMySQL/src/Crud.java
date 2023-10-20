import java.sql.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Crud {
    public static void main(String[] args) {
            updateData();
    }

    public static Connection getConnection(){
        try {
            String driver="com.mysql.cj.jdbc.Driver";
            String databaseURL="jdbc:mysql://localhost:3306/studendb";

            String username="root";
            String password="amarmonease";
            Class.forName(driver);
            Connection conn= DriverManager.getConnection(databaseURL,username,password);
            System.out.println("Database Connected Successfully");
            return conn;
        }catch (Exception e){
            System.out.println(e);;
        }
        System.out.println("Database Connection failed");
    return null;
    }

    public static void getData(){
        boolean state=true;
        try {
            Statement statement= getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
                System.out.println("viewing all data");
                state=false;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        if (state){
            System.out.println("There is no data");
        }

    }



    public static void insertData()  {
        int id=112310583;
        String name="asad Imran";
        String department="CSE";
        String studentMail= "aimran2310574@bscse.uiu.ac.bd";
        int trimester=6;
        double cgpa=3.90;
        String city="Barishal";
        String phone="01633356249";
        String bloodGroup="O+";
        try {
            Statement statement= getConnection().createStatement();
            int result= statement.executeUpdate("insert into students (id,name,dempartment,studentMail, trimester, cgpa, city, phone, bloodGroup) values(" +
                    id +
                    ",'" +
                    name+
                    "','" +
                    department +
                    "','" +
                   studentMail +
                    "'," +
                    trimester +
                    "," +
                    cgpa +
                    ",'" +
                    city +
                    "','" +
                    phone +
                    "','" +
                    bloodGroup +
                    "')");
            System.out.println("result= "+result);
            if (result==1){
                System.out.println("Data Inserted successfully");
            }else{
                System.out.println("some error occars");
            }
        }catch (Exception e){
            System.out.println("some error: "+e);
        }
    }

    public static void  deleteData(){
        int id=112310579;
        try {
            Statement statement= getConnection().createStatement();
            int result= statement.executeUpdate("delete from students where id=" +
                    id);
            System.out.println("result= "+result);
            if (result==1){
                System.out.println("Data Deleted successfully");
            }else{
                System.out.println("some error occars");
            }
        }catch (Exception e){
            System.out.println("some error: "+e);
        }
    }


    public static void updateData(){
        int id=112310577;
        try{
            Statement statement=getConnection().createStatement();
            int result= statement.executeUpdate("UPDATE students SET id=112310544 WHERE ID="+id);
            if(result==1){
                System.out.println("Data Updated Successfully");
            }else{
                System.out.println("Some error occars");
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }


}