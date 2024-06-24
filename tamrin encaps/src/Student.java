import java.util.Arrays;

public class Student {
    private String name;
    private String studentNumber;
    private StudentCourse[] studentCourses;

    public Student(String name, String studentNumber, StudentCourse[] studentCourses) {
        this.name = name;
        if (isValidStudentNumber(studentNumber)) {
            this.studentNumber = studentNumber;
        } else {
            this.studentNumber = null; // Invalid
        }
        this.studentCourses = studentCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public boolean setStudentNumber(String studentNumber) {
        if (isValidStudentNumber(studentNumber)) {
            this.studentNumber = studentNumber;
            return true;
        }
        return false;
    }

    public StudentCourse[] getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(StudentCourse[] studentCourses) {
        this.studentCourses = studentCourses;
    }

    private boolean isValidStudentNumber(String studentNumber) {
        return studentNumber.matches("\\d{7}");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentCourses=" + Arrays.toString(studentCourses) +
                '}';
    }
}
