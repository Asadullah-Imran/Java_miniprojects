import java.util.Scanner;

public class TempConversion {
    static double degree;

    static void menu() {
        System.out.println("********* Temperature Conversion Menu *********");
        System.out.println("What is the current temperature in " + degree + "°?");
        System.out.println("\t# Press 1 for Celsius");
        System.out.println("\t# Press 2 for Fahrenheit");
        System.out.println("\t# Press 3 for Kelvin");
    }

    public static void main(String[] args) {
        System.out.println("*** Welcome to Temperature Conversion System ***");
        System.out.println();
        System.out.println("Type the temperature you would like to convert:");
        Scanner sc = new Scanner(System.in);
        TempConversion tempConv = new TempConversion();
        tempConv.degree = sc.nextDouble();
        menu();

        int option = sc.nextInt();
        switch (option) {
            case 1:
                Celsius celsius = new Celsius(degree);
                break;
            case 2:
                Fahrenheit fahrenheit = new Fahrenheit(degree);
                break;
            case 3:
                Kelvin kelvin = new Kelvin(degree);
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}

class Celsius {
    double result;

    Celsius(double degree) {
        System.out.println("********* Celsius Conversion Menu *********");
        System.out.println("Which temperature scale do you want to convert to?");
        System.out.println("\t# Press 1 for Fahrenheit");
        System.out.println("\t# Press 2 for Kelvin");
        Scanner sc = new Scanner(System.in);

        int option = sc.nextInt();
        switch (option) {
            case 1:
                result = ((degree * 9) / 5) + 32;
                System.out.println(degree + "° Celsius is equal to " + result + "° Fahrenheit");
                break;
            case 2:
                result = degree + 273.15;
                System.out.println(degree + "° Celsius is equal to " + result + "° Kelvin");
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}

class Fahrenheit {
    double result;

    Fahrenheit(double degree) {
        System.out.println("********* Fahrenheit Conversion Menu *********");
        System.out.println("Which temperature scale do you want to convert to?");
        System.out.println("\t# Press 1 for Celsius");
        System.out.println("\t# Press 2 for Kelvin");
        Scanner sc = new Scanner(System.in);

        int option = sc.nextInt();
        switch (option) {
            case 1:
                result = ((degree - 32) * 5) / 9;
                System.out.println(degree + "° Fahrenheit is equal to " + result + "° Celsius");
                break;
            case 2:
                result = (((degree - 32) * 5) / 9) + 273.15;
                System.out.println(degree + "° Fahrenheit is equal to " + result + "° Kelvin");
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}

class Kelvin {
    double result;

    Kelvin(double degree) {
        System.out.println("********* Kelvin Conversion Menu *********");
        System.out.println("Which temperature scale do you want to convert to?");
        System.out.println("\t# Press 1 for Celsius");
        System.out.println("\t# Press 2 for Fahrenheit");
        Scanner sc = new Scanner(System.in);

        int option = sc.nextInt();
        switch (option) {
            case 1:
                result = degree - 273.15;
                System.out.println(degree + "° Kelvin is equal to " + result + "° Celsius");
                break;
            case 2:
                result = (((degree - 273.15) * 9) / 5) + 32;
                System.out.println(degree + "° Kelvin is equal to " + result + "° Fahrenheit");
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
