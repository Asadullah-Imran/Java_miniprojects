import java.util.Scanner;

public class TempConversion {
    static double degree;

     static void menu(){
        System.out.println("*********Choice***Section*******");
        System.out.println("what is the "+ degree +"'s current state?");
        System.out.println("\t#press 1 for Celsius");
        System.out.println("\t#press 2 for Fahrenheit");
        System.out.println("\t#press 3 for Kelvin");
    }

    public static void main(String[] args) {
        System.out.println("*** Welcome to Temperature Conversion system ***");
        System.out.println();
        System.out.println("Type the temperature you would like to convert:");
        Scanner sc= new Scanner(System.in);
        TempConversion tempConv = new TempConversion();
        tempConv.degree= sc.nextDouble();
        menu();

        int option=sc.nextInt();
        switch (option){
            case 1:
                Celsius celsius= new Celsius(degree);
//                System.out.println(celsius.result);
                break;
            case 2:
                Fahrenheit fahrenheit = new Fahrenheit(degree);
                break;
            case 3:
                Kelvin kelvin = new Kelvin(degree);
                break;
        }
    }
}

class Celsius{
    double result;
    Celsius(double degree){
        System.out.println("*********Choice***Section*******");
        System.out.println("which state you want to convert?");
        System.out.println("\t# press 1 for Fahrenheit");
        System.out.println("\t# press 2 for Kelvin");
        Scanner sc= new Scanner(System.in);


        int option=sc.nextInt();
        switch (option){
            case 1:
                 result = ((degree*9)/5)+32;
                System.out.println(degree+ " degree Celsius equal to "+ result + " degree Fahrenheit");

                break;
            case 2:
                 result= (degree+ 273.15);
                System.out.println(degree+ " degree Celsius equal to "+ result + " degree Fahrenheit");
                break;
        }

    }
}


class Fahrenheit{
    double result;
    Fahrenheit(double degree){
        System.out.println("*********Choice***Section*******");
        System.out.println("which state you want to convert?");
        System.out.println("\t# press 1 for Celsius");
        System.out.println("\t# press 2 for Kelvin");
        Scanner sc= new Scanner(System.in);


        int option=sc.nextInt();
        switch (option){
            case 1:
                result = ((degree-32)*5)/9;
                System.out.println(degree+ " degree fahrenheit equal to "+ result + " degree Celsius");

                break;
            case 2:
                result= (((degree-32)*5)/9)+ 273.15;
                System.out.println(degree+ " degree fahrenheit equal to "+ result + " degree kelvin");
                break;
        }

    }
}

class Kelvin{
    double result;
    Kelvin(double degree){
        System.out.println("*********Choice***Section*******");
        System.out.println("which state you want to convert?");
        System.out.println("\t# press 1 for Celsius");
        System.out.println("\t# press 2 for fahrenheit");
        Scanner sc= new Scanner(System.in);


        int option=sc.nextInt();
        switch (option){
            case 1:
                result = degree-273.15;
                System.out.println(degree+ " degree Kelvin equal to "+ result + " degree Celsius");

                break;
            case 2:
                result= (((degree-273.15)*9)/5)+32;
                System.out.println(degree+ " degree Kelvin equal to "+ result + " degree fahrenheit");
                break;
        }

    }
}