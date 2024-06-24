import java.util.Arrays;

public class Professor {
    private String name;
    private String professorNumber;
    private Course[] courses;

    public Professor(String name, String professorNumber, Course[] courses) {
        this.name = name;
        this.professorNumber = professorNumber;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessorNumber() {
        return professorNumber;
    }

    public void setProfessorNumber(String professorNumber) {
        this.professorNumber = professorNumber;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", professorNumber='" + professorNumber + '\'' +
                ", courses=" + Arrays.toString(courses) +
                '}';
    }
}
