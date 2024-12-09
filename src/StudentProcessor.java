import java.util.Scanner;

public class StudentProcessor {

    public void UserInputProcessor() {
        Scanner scanner = new Scanner(System.in);

        // Input student ID
        System.out.print("student_id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input student name
        System.out.print("student_name: ");
        String name = scanner.nextLine();

        // Input student email
        System.out.print("student_email: ");
        String email = scanner.nextLine();

        // Create a CreateStudent object
        Student student = new Student(id, name, email);

        // Display the entered student information
        System.out.println("\nStudent Details Entered:");
        student.displayInfo();

        System.out.println("""
                    \nPlease select action to continue:
                    1. Add another student
                    2. Exit
                    """);
    }
}
