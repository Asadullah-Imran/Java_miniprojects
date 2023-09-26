import java.util.Scanner;

public class Main {
    // Function to display the main menu
    static void menu() {
        System.out.println("Which type of base is your number:");
        System.out.println("\t# Press 1 for Decimal");
        System.out.println("\t# Press 2 for Binary");
        System.out.println("\t# Press 3 for Octal");
        System.out.println("\t# Press 4 for Hexadecimal");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Number System Conversion Calculator");
        Scanner sc = new Scanner(System.in);

        menu(); // Display the main menu
        int option = sc.nextInt(); // Get user choice

        switch (option) {
            case 1:
                System.out.println("You choose Decimal\n");
                decTo(); // Convert decimal
                break;
            case 2:
                System.out.println("You choose Binary\n");
                binTo(); // Convert binary
                break;
            case 3:
                System.out.println("You choose Octal\n");
                octTo(); // Convert octal
                break;
            case 4:
                System.out.println("You choose Hexadecimal\n");
                hexaTo(); // Convert hexadecimal
                break;
            default:
                System.out.println("Invalid Number");
                System.out.println("Please select an option between 1 to 4");
        }
    }

    // Function to convert decimal to other bases
    private static void decTo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the decimal number you want to convert: ");
        int number = sc.nextInt();
        Menu2 menu = new Menu2("Binary", "Octal", "Hexadecimal");

        int option = sc.nextInt(); // Get user choice

        switch (option) {
            case 1:
                System.out.println("You choose Binary");
                decToAny(number, 2); // Convert to binary
                break;
            case 2:
                System.out.println("You choose Octal");
                decToAny(number, 8); // Convert to octal
                break;
            case 3:
                System.out.println("You choose Hexadecimal");
                decToAny(number, 16); // Convert to hexadecimal
                break;
            default:
                System.out.println("Invalid Number");
                System.out.println("Please select an option between 1 to 3");
        }
    }

    // Function to convert decimal to any base
    private static void decToAny(int number, int n) {
        char[] arr2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int[] arr = new int[32];
        int digit;
        int i = 0;
        while (number != 0) {
            digit = number % n;
            number /= n;
            arr[i] = digit;
            i++;
        }
        i--;
        System.out.print("\tConverted Number: ");
        for (; i >= 0; i--) {
            System.out.print(arr2[arr[i]]);
        }
        System.out.println(); // Newline for clarity
    }

    // Function to convert binary to other bases
    private static void binTo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the binary number you want to convert: ");
        int number = sc.nextInt();
        int sum;
        Menu2 menu = new Menu2("Decimal", "Octal", "Hexadecimal");

        int option = sc.nextInt(); // Get user choice

        switch (option) {
            case 1:
                System.out.println("You choose Decimal");
                sum = otherToAny(number, 2); // Convert to decimal
                System.out.println("\tConverted Number: " + sum);
                break;
            case 2:
                System.out.println("You choose Octal");
                sum = otherToAny(number, 2); // Convert to decimal
                decToAny(sum, 8); // Convert decimal to octal
                break;
            case 3:
                System.out.println("You choose Hexadecimal");
                sum = otherToAny(number, 2); // Convert to decimal
                decToAny(sum, 16); // Convert decimal to hexadecimal
                break;
            default:
                System.out.println("Invalid Number");
                System.out.println("Please select an option between 1 to 3");
        }
    }

    // Function to convert any base to decimal
    private static int otherToAny(int number, int n) {
        int digit;
        int k = 1;
        int sum = 0;
        while (number != 0) {
            digit = number % 10;
            sum += digit * k;
            number /= 10;
            k *= n;
        }
        return sum;
    }

    // Function to convert octal to other bases
    private static void octTo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the octal number you want to convert: ");
        int number = sc.nextInt();
        int sum;
        Menu2 menu = new Menu2("Decimal", "Binary", "Hexadecimal");

        int option = sc.nextInt(); // Get user choice

        switch (option) {
            case 1:
                System.out.println("You choose Decimal");
                sum = otherToAny(number, 8); // Convert to decimal
                System.out.println("\tConverted Number: " + sum);
                break;
            case 2:
                System.out.println("You choose Binary");
                sum = otherToAny(number, 8); // Convert to decimal
                decToAny(sum, 2); // Convert decimal to binary
                break;
            case 3:
                System.out.println("You choose Hexadecimal");
                sum = otherToAny(number, 8); // Convert to decimal
                decToAny(sum, 16); // Convert decimal to hexadecimal
                break;
            default:
                System.out.println("Invalid Number");
                System.out.println("Please select an option between 1 to 3");
        }
    }

    // Function to convert hexadecimal to other bases
    private static void hexaTo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the hexadecimal number you want to convert: ");
        String hexInput = sc.next(); // Read as a string
        int arr[] = new int[32];
        int i = 0;
        // Iterate through the characters in the input string
        for (char c : hexInput.toCharArray()) {
            // Convert each character to its decimal equivalent
            int decimalValue = Character.digit(c, 16);
            arr[i] = decimalValue;
            i++;
        }
        i--;
        int digit;
        int k = 1;
        int sum = 0;
        for (; i >= 0; i--) {
            sum += arr[i] * k;
            k *= 16;
        }
        Menu2 menu = new Menu2("Decimal", "Binary", "Octal");
        int option = sc.nextInt(); // Get user choice

        switch (option) {
            case 1:
                System.out.println("You choose Decimal");
                System.out.println("Converted Number: " + sum);
                break;
            case 2:
                System.out.println("You choose Binary");
                decToAny(sum, 2); // Convert decimal to binary
                break;
            case 3:
                System.out.println("You choose Octal");
                decToAny(sum, 8); // Convert decimal to octal
                break;
            default:
                System.out.println("Invalid Number");
                System.out.println("Please select an option between 1 to 3");
        }
    }
}

class Menu2 {
    String name1;
    String name2;
    String name3;

    Menu2(String name1, String name2, String name3) {
        System.out.println("Which type of base is your number:");
        System.out.println("\t# Press 1 for " + name1);
        System.out.println("\t# Press 2 for " + name2);
        System.out.println("\t# Press 3 for " + name3);
    }
}
