# 🎓 Student Report Card Management System

This is a simple Java-based console application that helps manage student records and generate report cards. You can add, view, update, delete, and search for students — and all the data is saved persistently in a file called `Students.txt`.

---

## 📁 Features

* ➕ Add new students
* 👁️ View all students with total, percentage, and grade
* 🔍 Search student by roll number
* ✏️ Update student details
* 🗑️ Delete student
* 💾 Save data to a file and load it automatically at startup
* ❌ Gracefully handles invalid input (e.g., typing letters instead of numbers)

---

## 📂 File Structure

* `Main.java` - Entry point with menu handling
* `Student.java` - Student class with data and logic
* `StudentManager.java` - Handles operations like add, delete, update, load, save

---

## 📦 Data Format in `Students.txt`

Each line represents one student:

```
rollNo,name,mathMarks,englishMarks,scienceMarks
```

### Example:

```
1,Diwakar,90.0,85.0,88.0
2,Bhaskar,78.0,82.0,80.0
```

---

## 🏁 How to Run

### Step 1: Compile

```bash
javac Main.java Student.java StudentManager.java
```

### Step 2: Run

```bash
java Main
```

---

## 💡 Example Menu Output

```
📚 Student Management Menu:
1. ➕ Add Student
2. 👁️ View All Students
3. 🔍 Search Student by Roll No
4. ✏️ Update Student by Roll No
5. 🗑️ Delete Student by Roll No
6. 💾 Save & Exit
Enter your choice:
```

---

## ✅ Sample Report Card Output

```
📋 ALL STUDENTS REPORT CARDS
===================================
------------------------------
Roll No       : 1
Name          : Diwakar
Math Marks    : 90.00
Science Marks : 88.00
English Marks : 85.00
Total         : 263.00 / 300
Percentage    : 87.67%
Grade         : A
------------------------------
===================================
```

---

## ⚠️ Notes

* If `Students.txt` is not found at startup, it starts fresh without crashing.
* Data is saved on exit automatically.
* Prevents crashes from invalid inputs using try-catch blocks.

---

## 👨‍💻 Author

Developed by **Diwakar**
Java Project for learning file handling, OOP, and error management.

---

## 📌 License

This project is open-source and free to use for educational purposes.
