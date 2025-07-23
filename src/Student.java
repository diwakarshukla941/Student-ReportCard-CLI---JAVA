public class Student {
    private int rollNo;
    private String name;
    private float mathMarks;
    private float englishMarks;
    private float scienceMarks;

    public Student(int rollNo, String name, float mathMarks, float englishMarks, float scienceMarks ) {
        this.rollNo = rollNo;
        this.name = name;
        this.mathMarks = mathMarks;
        this.englishMarks = englishMarks;
        this.scienceMarks = scienceMarks;
    }

    public int getRollNo(){
        return rollNo;
    }

    public float getTotal() {
        return mathMarks + englishMarks + scienceMarks;
    }

    public float getPercentage() {
        return getTotal() / 3;
    }

    public String getGrade() {
        float percentage = getPercentage();
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B+";
        else if (percentage >= 60) return "B";
        else if (percentage >= 50) return "C";
        else return "F";
    }


    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", mathMarks=" + mathMarks +
                ", englishMarks=" + englishMarks +
                ", scienceMarks=" + scienceMarks +
                '}';
    }

    public String getName(){
        return name;
    }
    public float getMathMarks(){
        return mathMarks;
    }
    public float getEnglishMarks(){
        return englishMarks;
    }
    public float getScienceMarks(){
        return scienceMarks;
    }


    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMathMarks(float mathMarks) {
        this.mathMarks = mathMarks;
    }

    public void setEnglishMarks(float englishMarks) {
        this.englishMarks = englishMarks;
    }

    public void setScienceMarks(float scienceMarks) {
        this.scienceMarks = scienceMarks;
    }

    public int getTotalMarks(){
        return (int) (mathMarks + englishMarks + scienceMarks);
    }
}
