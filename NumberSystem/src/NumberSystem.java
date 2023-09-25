import java.util.Scanner;

public class NumberSystem {

    // Function to display the menu options
    static void menu() {
        System.out.println("Choose any option: ");
        System.out.println("1. Convert to Binary");
        System.out.println("2. Convert to Octal");
        System.out.println("3. Convert to Hexadecimal");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Number System Converter!");

        // Input: Get the decimal number from the user
        System.out.print("Enter a decimal number to convert: ");
        int decimal = sc.nextInt();
        int digit;
        int i = 0;
        int arr[] = new int[32];
        String sarr[] = new String[32];

        // Display the conversion menu
        menu();
        int option = sc.nextInt();

        switch (option) {
            case 1:
                // Convert to Binary
                while (decimal != 0) {
                    digit = decimal % 2;
                    decimal = decimal / 2;
                    arr[i] = digit;
                    i++;
                }
                i--;

                System.out.print("Binary: ");
                for (; i >= 0; i--) {
                    System.out.print(arr[i]);
                }
                break;
            case 2:
                // Convert to Octal
                while (decimal != 0) {
                    digit = decimal % 8;
                    decimal = decimal / 8;
                    arr[i] = digit;
                    i++;
                }
                i--;

                System.out.print("Octal: ");
                for (; i >= 0; i--) {
                    System.out.print(arr[i]);
                }
                break;
            case 3:
                // Convert to Hexadecimal
                String sdigit;
                while (decimal != 0) {
                    digit = decimal % 16;
                    sdigit = String.valueOf(digit);
                    if (sdigit.equals("10")) {
                        sdigit = "A";
                    } else if (sdigit.equals("11")) {
                        sdigit = "B";
                    } else if (sdigit.equals("12")) {
                        sdigit = "C";
                    } else if (sdigit.equals("13")) {
                        sdigit = "D";
                    } else if (sdigit.equals("14")) {
                        sdigit = "E";
                    } else if (sdigit.equals("15")) {
                        sdigit = "F";
                    }
                    decimal = decimal / 16;
                    sarr[i] = sdigit;
                    i++;
                }
                i--;

                System.out.print("Hexadecimal: ");
                for (; i >= 0; i--) {
                    System.out.print(sarr[i]);
                }
                break;
            default:
                System.out.println("Invalid option");
                System.out.println("Please choose a number between 1 to 3.");
        }
    }
}
