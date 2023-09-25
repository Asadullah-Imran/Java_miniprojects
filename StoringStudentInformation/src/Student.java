import java.util.Scanner;

public class Student{

    String name;
    int id;
    String city;
    double  cgpa;
    double gpa;
    int trimester;




    public static void main(String[] args){
        System.out.println("how many student you want to add:");
        Scanner sc= new Scanner(System.in);
        int len= sc.nextInt();
        //creating an array of object/instance
        Student[] students= new Student[len];
        for(int i=0;i<len;i++){
            System.out.println("for the student "+(i+1));

            students[i]= new Student();
            sc.nextLine();
            System.out.println("Enter name:");
            students[i].name= sc.nextLine();


            System.out.println("Enter id:");
            students[i].id= sc.nextInt();


            System.out.println("Enter City:");
            students[i].city= sc.next();

            System.out.println("Enter CGPA:");
            students[i].cgpa= sc.nextDouble();



            System.out.println("Enter GPA:");
            students[i].gpa= sc.nextDouble();


            System.out.println("Enter trimester:");
            students[i].trimester= sc.nextInt();


        }


        for(int i=0;i<len;i++){
            System.out.println("for the student "+(i+1));

            System.out.println("Enter name: "+ students[i].name);

            System.out.println("Enter id: "+ students[i].id);

            System.out.println("Enter City:" +  students[i].city);

            System.out.println("Enter CGPA:" +students[i].cgpa);

            System.out.println("Enter GPA:" + students[i].gpa);

            System.out.println("Enter trimester:"+ students[i].trimester);

            System.out.println("===============");
            System.out.println();

        }

    }



}