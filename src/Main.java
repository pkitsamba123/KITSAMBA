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
            System.out.println("\nLogin successful! Welcome, " + username + ".");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
        scanner.close();
    }
}