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
            System.out.println("Enter a number (1-5): ");
            int choice = scanner.nextInt();
                switch (choice) {
                    case 1://create student
                        StudentProcessor obj = new StudentProcessor();
                        obj.UserInputProcessor();
                        break;
                    case 2://display registered students
                        System.out.println("r");
                        break;
                    case 3://update existing student
                        StudentEditor edit = new StudentEditor();
                        edit.UserUpdate();
                        break;
                    case 4://delete student
                        DeleteStudent remove = new DeleteStudent();
                        remove.RemoveStudent();
                        break;
                    case 5://exit application
                        ExitApplication quit = new ExitApplication();
                        quit.exit();
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}