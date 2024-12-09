import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n----------STUDENT REGISTRATION SYSTEM----------\n");
        System.out.println("Enter username and password\n");

        String correctUsername = "admin";
        String correctPassword = "root";

        Scanner scanner = new Scanner(System.in);

        // Prompt user for username
        System.out.print("username: ");
        String username = scanner.nextLine();

        // Prompt user for password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Validate login credentials
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("""
                    \nLogin successful! Select action to continue:
                    \n1. Create a student id
                    2. Display the registered students
                    3. Update student data
                    4. Delete existing student
                    5. Exit the application
                    """
            );
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
        scanner.close();
    }
}