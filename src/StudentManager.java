import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students ;

    public StudentManager() {
        students = new ArrayList<Student>();
    }

    public void addStudent(int roll, String name, float math, float english, float science) {
        Student student = new Student(roll, name, math, english, science);
        students.add(student);
    }

    public void DisplayStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students found!");
            return;
        }

        System.out.println("\n📋 ALL STUDENTS REPORT CARDS");
        System.out.println("===================================");

        for (Student s : students) {
            System.out.println("\n------------------------------");
            System.out.printf("🎓 Roll No       : %d\n", s.getRollNo());
            System.out.printf("📛 Name          : %s\n", s.getName());
            System.out.printf("📐 Math Marks    : %.2f\n", s.getMathMarks());
            System.out.printf("🔬 Science Marks : %.2f\n", s.getScienceMarks());
            System.out.printf("📖 English Marks : %.2f\n", s.getEnglishMarks());
            System.out.printf("📊 Total         : %.2f / 300\n", s.getTotal());
            System.out.printf("📈 Percentage    : %.2f%%\n", s.getPercentage());
            System.out.println("🏅 Grade         : " + s.getGrade());
        }

        System.out.println("\n===================================");
    }


    public void deleteStudent(int roll) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNo() == roll) {
                students.remove(i);
                System.out.println("✅ Student deleted.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Student not found!");
        }
    }

    public void SearchByRoll(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                System.out.println("\n📄 STUDENT REPORT CARD");
                System.out.println("------------------------------");
                System.out.println("Roll No     : " + s.getRollNo());
                System.out.println("Name        : " + s.getName());
                System.out.println("------------------------------");
                System.out.println("📚 Subjects       Marks");
                System.out.println("------------------------------");
                System.out.printf("Maths         : %.2f\n", s.getMathMarks());
                System.out.printf("English       : %.2f\n", s.getEnglishMarks());
                System.out.printf("Science       : %.2f\n", s.getScienceMarks());
                System.out.println("------------------------------");
                System.out.printf("Total Marks   : %.2f / 300\n", s.getTotal());
                System.out.printf("Percentage    : %.2f%%\n", s.getPercentage());
                System.out.println("Grade         : " + s.getGrade());
                System.out.println("------------------------------");
                return;
            }
        }
        System.out.println("❌ No student found with roll number: " + rollNo);
    }


    public void UpdateStudent(int roll) {
        boolean found = false;

        for(int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNo() == roll) {
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter updated name: ");
                String name = sc.nextLine();

                System.out.println("Enter updated Maths marks: ");
                int newMathsMarks = sc.nextInt();

                System.out.println("Enter updated Science marks: ");
                int newScienceMarks = sc.nextInt();

                System.out.println("Enter updated English marks: ");
                int newEnglishMarks = sc.nextInt();

                students.get(i).setName(name);
                students.get(i).setMathMarks(newMathsMarks);
                students.get(i).setScienceMarks(newScienceMarks);
                students.get(i).setEnglishMarks(newEnglishMarks);

                System.out.println("✅ Student record updated successfully.");
                found = true;
                break; // No need to keep looping
            }
        }

        if (!found) {
            System.out.println("❌ Student with roll number " + roll + " not found.");
        }
    }

    public void saveToFile() {
        try{
            FileWriter fw = new FileWriter("Students.txt");
            for (Student s : students) {
                String data = s.getRollNo() + "," + s.getName() + "," + s.getMathMarks() + "," + s.getEnglishMarks() + "," + s.getScienceMarks();
                fw.write(data + "\n");
            }
            fw.close();
            System.out.println("✅ Students saved to file.");
        }catch (Exception e){
            System.out.println("Something Went Wrong!");
        }

    }

    public void loadFromFile() {
        File file = new File("Students.txt");

        if (!file.exists()) {
            System.out.println("📂 No saved data found. Starting fresh.");
            return;
        }

        try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
            students.clear(); // Clear existing list to avoid duplicates

            String line;
            while ((line = fr.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int roll = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    float math = Float.parseFloat(parts[2]);
                    float english = Float.parseFloat(parts[3]);
                    float science = Float.parseFloat(parts[4]);

                    Student s = new Student(roll, name, math, english, science);
                    students.add(s);
                }
            }

            System.out.println("✅ Data loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("❌ Error loading data: " + e.getMessage());
        }
    }


}
