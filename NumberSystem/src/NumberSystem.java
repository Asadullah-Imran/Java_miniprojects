import java.util.Scanner;

public class NumberSystem {



    static  void menu(){
        System.out.println("Choose any option: ");
        System.out.println("1. Binary");
        System.out.println("2. Octal");
        System.out.println("3. Hexadecimal");
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal number to convert: ");
        int decimal= sc.nextInt();
        int digit;
        int i = 0;
        //int len =String.valueOf(decimal).length();
        int arr[]= new int[32];
        String sarr[]=new String[32];

        //System.out.println(len);


        menu();
        int option =sc.nextInt();
        //int tempLen=len;
        switch (option) {
            case 1:

                while (decimal != 0) {
                    digit = decimal % 2;
                    decimal = decimal / 2;
                    arr[i] = digit;
                    i++;
                }
                i--;
                for(;i>=0;i--){
                    System.out.print(arr[i]);
                }
                break;
            case 2:
                while (decimal != 0) {
                    digit = decimal % 8;
                    decimal = decimal / 8;
                    arr[i] = digit;
                    i++;
                }
                i--;
                for(;i>=0;i--){
                    System.out.print(arr[i]);
                }
                break;
            case 3:
                String sdigit;
                while (decimal != 0) {
                    digit = decimal % 16;
                    sdigit= String.valueOf(digit);
                    if(sdigit.equals("10")){
                        sdigit="A";
                    }else if(sdigit.equals("11")){
                        sdigit="B";
                    }else if(sdigit.equals("12")){
                        sdigit="C";
                    }else if(sdigit.equals("13")){
                        sdigit="D";
                    }else if(sdigit.equals("14")){
                        sdigit="E";
                    }else if(sdigit.equals("15")){
                        sdigit="F";
                    }
                    decimal = decimal / 16;
                    sarr[i] = sdigit;
                    i++;
                }
                i--;
                for(;i>=0;i--){
                    System.out.print(sarr[i]);
                }
                break;
            default:
                System.out.println("Invalid option");
                System.out.println("input a number between 1 to 3");

        }


    }
}