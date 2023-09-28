import java.util.Scanner;

public class StringOperation {

    public static void main(String[] args) {
        System.out.println("Type any sentence or paragraph");
        Scanner sc =new Scanner(System.in);
        String str1= sc.nextLine();

        char index1= str1.charAt(0);
        int index2 = str1.charAt(3);
        System.out.println( "at index " +0+ " character is "+index1+" and ascii value is "+(int)index1 );
        System.out.println( "at index " +3+ " character is "+(char)index2+" and ascii value is "+index2 );

        int unicode = str1.codePointAt(2); //to get unicode at index 2
        System.out.println("at index " +2+ " character is "+str1.charAt(2)+" and its unicode is "+unicode); //unicode is same as ascii value
        int unicode2= str1.codePointBefore(3); //it will print before index 3
        System.out.println("before index " +3+ " character is "+str1.charAt(2)+" and its unicode is "+unicode); //unicode is same as ascii value

    }
}