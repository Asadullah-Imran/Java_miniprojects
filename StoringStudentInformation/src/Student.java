import java.util.Scanner;

public class Student {

    String name;
    int id;
    String city;
    double cgpa;
    double gpa;
    int trimester;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Record Management!");

        int option;
        int len = 0;
        Student[] students = {};

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Students");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("How many students do you want to add?");
                    len = sc.nextInt();
                    students = new Student[len];
                    sc.nextLine();

                    for (int i = 0; i < len; i++) {
                        System.out.println("For Student " + (i + 1));
                        students[i] = new Student();

                        System.out.println("Enter name:");
                        students[i].name = sc.nextLine();

                        System.out.println("Enter id:");
                        students[i].id = sc.nextInt();

                        sc.nextLine();

                        System.out.println("Enter City:");
                        students[i].city = sc.nextLine();

                        System.out.println("Enter CGPA:");
                        students[i].cgpa = sc.nextDouble();

                        System.out.println("Enter GPA:");
                        students[i].gpa = sc.nextDouble();

                        System.out.println("Enter trimester:");
                        students[i].trimester = sc.nextInt();
                    }
                    break;

                case 2:
                    if (len == 0) {
                        System.out.println("No students added yet.");
                    } else {
                        System.out.println("Student Records:");
                        for (int i = 0; i < len; i++) {
                            System.out.println("For Student " + (i + 1));
                            System.out.println("Name: " + students[i].name);
                            System.out.println("ID: " + students[i].id);
                            System.out.println("City: " + students[i].city);
                            System.out.println("CGPA: " + students[i].cgpa);
                            System.out.println("GPA: " + students[i].gpa);
                            System.out.println("Trimester: " + students[i].trimester);
                            System.out.println("=================");
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting the Student Record Management system.");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
