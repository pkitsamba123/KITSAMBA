package student_registration_system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentProcessor studentProcessor = new StudentProcessor();
        ExitApplication quit = new ExitApplication();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n----------STUDENT REGISTRATION SYSTEM----------\n");
        System.out.println("Enter username and password\n");

        String correctUsername = "admin";
        String correctPassword = "root";

        // Validate user name input
        String username = "";
        while (username.isEmpty()) {
            System.out.print("Username: ");
            username = scanner.nextLine().trim();
            if (username.isEmpty()) {
                System.out.println("Username cannot be empty. Please enter a valid username.");
            }
        }

        // Validate password input
        String password = "";
        while (password.isEmpty()) {
            System.out.print("Enter your password: ");
            password = scanner.nextLine().trim();
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty. Please enter a valid password.");
            }
        }

        // Validate login credentials
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("\nLogin successful!");

            int choice;
            do {
                // Menu options
                System.out.println("""
                        \nSelect action to continue:
                        1. Create a Student
                        2. Display the registered students
                        3. Update student data
                        4. Delete existing student
                        5. Exit the application
                        """);

                // Input validation for menu choice
                while (true) {
                    System.out.print("Enter a number (1-5): ");
                    try {
                        choice = scanner.nextInt();
                        if (choice >= 1 && choice <= 5) {
                            break;  // Valid choice
                        } else {
                            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine();  // Clear the invalid input
                    }
                }

                // Switch case for menu options
                switch (choice) {
                    case 1: // Create student
                        studentProcessor.AddStudent();
                        break;
                    case 2: // Display registered students
                        studentProcessor.GetStudents();
                        break;
                    case 3: // Update student data
                        studentProcessor.EditStudent();
                        break;
                    case 4: // Delete student
                        studentProcessor.DeleteStudent();
                        break;
                    case 5: // Exit application
                        quit.exit();
                        System.out.println("xiting the application...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } while (choice != 5);  // Continue until "Exit" is selected
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

        scanner.close();
    }
}
