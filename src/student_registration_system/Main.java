package student_registration_system;

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

        // Prompt user for username
        System.out.print("username: ");
        String username = scanner.nextLine();

        // Prompt user for password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Validate login credentials
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("\nLogin successful!");

            int choice;
            do {
                System.out.println("""
                        \nSelect action to continue:
                        1. Create a Student
                        2. Display the registered students
                        3. Update student data
                        4. Delete existing student
                        5. Exit the application
                        """);
                System.out.print("Enter a number (1-5): ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1: // create student
                        studentProcessor.AddStudent();
                        break;
                    case 2: // display registered students
                        studentProcessor.GetStudents();
                        break;
                    case 3: // update existing student
                        studentProcessor.EditStudent();
                        break;
                    case 4: // delete student
                        studentProcessor.DeleteStudent();
                        break;
                    case 5: // exit application
                        quit.exit();
                        System.out.println("Exiting the application...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } while (choice != 5); // Continue until "Exit" is selected
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}
