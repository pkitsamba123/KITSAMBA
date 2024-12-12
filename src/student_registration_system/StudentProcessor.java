package student_registration_system;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentProcessor {

	ArrayList<Student> students;
	 Scanner scanner = new Scanner(System.in);
	 
	public StudentProcessor() {
		this.students = new ArrayList<>();
	}
	
	   public void AddStudent() {
	        // Input student ID
	        int id;
	        while (true) {
	            System.out.print("student_id: ");
	            if (scanner.hasNextInt()) {
	                id = scanner.nextInt();
	                scanner.nextLine(); // Consume newline
	                break;
	            } else {
	                System.out.println("Invalid input. Please enter a numeric ID.");
	                scanner.nextLine(); // Clear invalid input
	            }
	        }

	        // Input student name
	        String name;
	        while (true) {
	            System.out.print("student_name: ");
	            name = scanner.nextLine().trim();
	            if (!name.isEmpty()) {
	                break;
	            } else {
	                System.out.println("Student name cannot be empty. Please enter a valid name.");
	            }
	        }

	        // Input student email
	        String email;
	        while (true) {
	            System.out.print("student_email: ");
	            email = scanner.nextLine().trim();
	            if (validateEmail(email)) {
	                break;
	            } else {
	                System.out.println("Invalid email format. Please enter a valid email address.");
	            }
	        }

	        // Create a Student object and add it to the list
	        Student student = new Student(id, name, email);
	        students.add(student);

	        // Display the entered student information
	        System.out.println("\nStudent Details Entered:");
	        student.displayInfo();
	    }

	    // Validate email using a regular expression
	    private boolean validateEmail(String email) {
	        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,}$";
	        return email.matches(emailRegex);
	    }
    
    
    public void GetStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("-------------------");
        }
    }
    

    public void EditStudent() {
    	// Input student ID
        System.out.print("Enter the Student Id you want to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input student name
        System.out.print("Enter the Student Name you want to edit: ");
        String name = scanner.nextLine();

        // Input student email
        System.out.print("Enter the Student Email you want to edit: ");
        String email = scanner.nextLine();
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setEmail(email);
                System.out.println("Student with ID " + id + " has been updated.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }


    public void DeleteStudent() {
    	
    	// Input student ID
        System.out.print("Enter the Student Id you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student with ID " + id + " has been removed.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}
