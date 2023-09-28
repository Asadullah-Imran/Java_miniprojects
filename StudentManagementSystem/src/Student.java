import java.util.Scanner;

public class Student {
    // Define the attributes of the Student class
    String fullName;
    String studentId;
    String address;
    double cgpa;
    double gpa;
    int trimester;
    String phoneNo;
    String studentEmail;
    String bloodGroup;

    // A static method to generate a student email based on full name and ID
    static String emailMaker(String fullName, String id) {
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0].toLowerCase();
        String lastName = "";
        if (nameParts.length > 1) {
            lastName = nameParts[nameParts.length - 1].toLowerCase();
        }
        String modifiedId = id;
        if (id.length() > 3) {
            modifiedId = id.substring(3);
        }
        return firstName.charAt(0) + lastName + modifiedId + "@bscse.uiu.ac.bd";
    }

    // A static method to display student information
    static void display(int i, int count, Student[] students) {
        System.out.println("Student Name is " + students[i].fullName);
        System.out.println("Student ID is " + students[i].studentId);
        System.out.println("Student Email is " + students[i].studentEmail);
        System.out.println("Student Address is " + students[i].address);
        System.out.println("Student Trimester is " + students[i].trimester);
        System.out.println("Student CGPA is " + students[i].cgpa);
        System.out.println("Student GPA is " + students[i].gpa);
        System.out.println("Student Phone No is " + students[i].phoneNo);
        System.out.println("Student Blood Group is " + students[i].bloodGroup);
    }

    public static void main(String[] args) {
        int count = 0;
        Student[] students = new Student[100];
        System.out.println("Welcome to Student Record System");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Students");
            System.out.println("2. Display Students");
            System.out.println("3. Search for a Student");
            System.out.println("4. Update Student Information");
            System.out.println("5. Exit");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int i = count;
                    students[i] = new Student();
                    System.out.println("\nFor Student " + (i + 1));

                    sc.nextLine();
                    System.out.print("Enter Student Full Name: ");
                    students[i].fullName = sc.nextLine();

                    System.out.print("Enter Student ID: ");
                    students[i].studentId = sc.next();

                    sc.nextLine();
                    System.out.print("Enter Address: ");
                    students[i].address = sc.nextLine();

                    System.out.print("Enter Trimester: ");
                    students[i].trimester = sc.nextInt();

                    System.out.print("Enter CGPA: ");
                    students[i].cgpa = sc.nextDouble();

                    System.out.print("Enter GPA: ");
                    students[i].gpa = sc.nextDouble();

                    System.out.print("Enter Phone Number: ");
                    students[i].phoneNo = sc.next();

                    System.out.print("Enter Blood Group: ");
                    students[i].bloodGroup = sc.next();

                    // Generate the student email
                    students[i].studentEmail = emailMaker(students[i].fullName, students[i].studentId);

                    count++;
                    break;

                case 2:
                    System.out.println("\n\tTotal Students: " + count +"\n");

                    if (count > 0) {
                        // Display student information for all students
                        for (i = 0; i < count; i++) {
                            display(i, count, students);
                            System.out.println("===========================================\n");
                        }

                    } else {
                        System.out.println("No students to display.\n");
                    }
                    break;

                case 3:
                    System.out.println("\nSearch for a Student");
                    System.out.print("Search by Student ID: ");
                    String searchVal = sc.next();
                    boolean found = false;
                    for (i = 0; i < count; i++) {
                        if (students[i].studentId.equals(searchVal)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        // Display student information for the found student
                        System.out.println();
                        display(i, count, students);
                    } else {
                        System.out.println("No matching student found.");
                    }
                    break;

                case 4:
                    System.out.println("\nUpdate Student Information");
                    System.out.print("Search for a Student by ID: ");
                    String searchVal2 = sc.next();
                    boolean found2 = false;
                    for (i = 0; i < count; i++) {
                        if (students[i].studentId.equals(searchVal2)) {
                            found2 = true;
                            break;
                        }
                    }
                    if (found2) {
                        System.out.println("\nEnter an option to update:");
                        System.out.println("1. Change Name");
                        System.out.println("2. Change Student ID");
                        System.out.println("3. Change Address");
                        System.out.println("4. Change Trimester");
                        System.out.println("5. Change CGPA");
                        System.out.println("6. Change GPA");
                        System.out.println("7. Change Phone Number");
                        System.out.println("8. Change Blood Group");
                        System.out.println("9. Go back to the main menu");

                        int option = sc.nextInt();
                        switch (option) {
                            case 1:
                                sc.nextLine();
                                System.out.print("Enter new Student Full Name: ");
                                students[i].fullName = sc.nextLine();
                                students[i].studentEmail = emailMaker(students[i].fullName, students[i].studentId);
                                break;
                            case 2:
                                System.out.print("Enter new  Student ID: ");
                                students[i].studentId = sc.next();
                                students[i].studentEmail = emailMaker(students[i].fullName, students[i].studentId);
                                break;
                            case 3:
                                sc.nextLine();
                                System.out.print("Enter new  Address: ");
                                students[i].address = sc.nextLine();
                                break;
                            case 4:
                                System.out.print("Enter new  Trimester: ");
                                students[i].trimester = sc.nextInt();
                                break;
                            case 5:
                                System.out.print("Enter new  CGPA: ");
                                students[i].cgpa = sc.nextDouble();
                                break;
                            case 6:
                                System.out.print("Enter new  GPA: ");
                                students[i].gpa = sc.nextDouble();
                                break;
                            case 7:
                                System.out.print("Enter new  Phone Number: ");
                                students[i].phoneNo = sc.next();
                                break;
                            case 8:
                                System.out.print("Enter new  Blood Group: ");
                                students[i].bloodGroup = sc.next();
                                break;
                            case 9:
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    } else {
                        System.out.println("No matching student found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Student Record System. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
