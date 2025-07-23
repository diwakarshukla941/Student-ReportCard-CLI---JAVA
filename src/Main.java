import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        // 🔁 Load students from file at start
        manager.loadFromFile();

        int choice = 0;
        while (choice != 6) {
            System.out.println("\n📚 Student Management Menu:");
            System.out.println("1. ➕ Add Student");
            System.out.println("2. 👁️ View All Students");
            System.out.println("3. 🔍 Search Student by Roll No");
            System.out.println("4. ✏️ Update Student by Roll No");
            System.out.println("5. 🗑️ Delete Student by Roll No");
            System.out.println("6. 💾 Save & Exit");

            while (true) {
                System.out.print("Enter your choice: ");
                String input = sc.next();
                try {
                    choice = Integer.parseInt(input);
                    break; // valid input, break loop
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input! Please enter a number (1–6).");
                }
            }


            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Maths Marks: ");
                    float math = sc.nextFloat();

                    System.out.print("Enter English Marks: ");
                    float english = sc.nextFloat();

                    System.out.print("Enter Science Marks: ");
                    float science = sc.nextFloat();

                    manager.addStudent(roll, name, math, english, science);
                    break;

                case 2:
                    manager.DisplayStudents();
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollSearch = sc.nextInt();
                    manager.SearchByRoll(rollSearch);
                    break;

                case 4:
                    System.out.print("Enter roll number to update: ");
                    int rollUpdate = sc.nextInt();
                    manager.UpdateStudent(rollUpdate);
                    break;

                case 5:
                    System.out.print("Enter roll number to delete: ");
                    int rollDelete = sc.nextInt();
                    manager.deleteStudent(rollDelete);
                    break;

                case 6:
                    // 💾 Save all students to file before exit
                    manager.saveToFile();
                    System.out.println("✅ Data saved. Exiting...");
                    break;

                default:
                    System.out.println("❗ Invalid choice! Try again.");
            }
        }
    }
}
