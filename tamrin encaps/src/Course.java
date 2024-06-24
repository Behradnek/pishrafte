public class Course {
    private String courseName;
    private String courseNumber;
    private final int creditHours;

    public Course(String courseName, String courseNumber, int creditHours) {
        this.courseName = courseName;
        if (isValidCourseNumber(courseNumber) && isValidCreditHours(creditHours)) {
            this.courseNumber = courseNumber;
            this.creditHours = creditHours;
        } else {
            this.courseNumber = null;
            this.creditHours = -1; // Invalid state
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public boolean setCourseNumber(String courseNumber) {
        if (isValidCourseNumber(courseNumber)) {
            this.courseNumber = courseNumber;
            return true;
        }
        return false;
    }

    public int getCreditHours() {
        return creditHours;
    }

    private boolean isValidCourseNumber(String courseNumber) {
        if (courseNumber.length() == 8) {
            char level = courseNumber.charAt(0);
            return level == 'B' || level == 'M' || level == 'P';
        }
        return false;
    }

    private boolean isValidCreditHours(int creditHours) {
        return creditHours >= 1 && creditHours <= 4;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                ", creditHours=" + creditHours +
                '}';
    }
}
