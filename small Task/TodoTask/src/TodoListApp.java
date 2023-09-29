import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {

    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the main menu
            System.out.println("\n\tTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View To-Do List");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add a new task
                    System.out.print("Enter a new task: ");
                    String task = scanner.nextLine();
                    todoList.add(task);
                    System.out.println("Task added: " + task);
                    break;

                case 2:
                    // Mark a task as completed
                    System.out.print("Enter the task number to mark as completed: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (taskNumber >= 1 && taskNumber <= todoList.size()) {
                        String completedTask = todoList.get(taskNumber - 1);
                        System.out.println("Marking task as completed: " + completedTask);
                        todoList.remove(taskNumber - 1);
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 3:
                    // View the to-do list
                    System.out.println("\nTo-Do List:");
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println((i + 1) + ". " + todoList.get(i));
                    }
                    break;

                case 4:
                    // Remove a task
                    System.out.print("Enter the task number to remove: ");
                    int removeTaskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (removeTaskNumber >= 1 && removeTaskNumber <= todoList.size()) {
                        String removedTask = todoList.remove(removeTaskNumber - 1);
                        System.out.println("Removed task: " + removedTask);
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 5:
                    // Exit the application
                    System.out.println("Exiting To-Do List App.");
                    scanner.close();
                    System.exit(0);

                default:
                    // Invalid option
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
