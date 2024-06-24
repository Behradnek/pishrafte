import java.util.ArrayList;

public class Student {
    String name, family, stdNo;
    float gpa;
    ArrayList<String> courses = new ArrayList<>();
    ArrayList<Float> marks = new ArrayList<>();

    public Student(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public void addMark(String course, float mark) {
        courses.add(course);
        marks.add(mark);
    }

    public float getMark(String course) {
        int index = courses.indexOf(course);
        if (index != -1) {
            return marks.get(index);
        } else {
            return -1;  // Return -1 if the course is not found
        }
    }

    public void computeGpa() {
        float sum = 0;
        for (Float mark : marks) {
            sum += mark;
        }
        gpa = sum / marks.size();
    }
    
    public String toString() {
        return name + "\t" + family + "\t" + stdNo;
    }

    public String maxMark() {
        float maxMark = marks.get(0);
        String maxCourse = courses.get(0);

        for (int i = 1; i < marks.size(); i++) {
            if (marks.get(i) > maxMark) {
                maxMark = marks.get(i);
                maxCourse = courses.get(i);
            }
        }

        return maxCourse + "," + maxMark;
    }

    public void printTranscript() {
        System.out.println("Transcript for " + name + " " + family + " (" + stdNo + "):");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i) + ": " + marks.get(i));
        }
        System.out.println("GPA: " + gpa);
    }

    public static void main(String[] args) {
        Student student = new Student("Behrad", "Nekoufar");
        student.stdNo = "402213033";
        student.addMark("Math", 17);
        student.addMark("Literature", 18);
        student.addMark("English", 20);
        student.addMark("Programming", 19);
        student.addMark("Physics", 17);
        student.computeGpa();

        System.out.println(student.toString());
        student.printTranscript();
        System.out.println("Highest Score Course: " + student.maxMark());
    }
}