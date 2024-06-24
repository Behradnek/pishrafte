public class StudentCourse {
    private PresentedCourse presentedCourse;
    private String status; // recorded ya unknown
    private Double grade;  // null agar no grade recorded
    private Boolean passed; // true for passed, false for failed, null if not determined

    public StudentCourse(PresentedCourse presentedCourse, String status, Double grade, Boolean passed) {
        this.presentedCourse = presentedCourse;
        if (setStatus(status) && setGrade(grade)) {
            this.passed = passed;
        } else {
            this.status = null;
            this.grade = null; // Invalid
        }
    }

    public PresentedCourse getPresentedCourse() {
        return presentedCourse;
    }

    public void setPresentedCourse(PresentedCourse presentedCourse) {
        this.presentedCourse = presentedCourse;
    }

    public String getStatus() {
        return status;
    }

    public boolean setStatus(String status) {
        if (status.equals("recorded") || status.equals("unknown")) {
            this.status = status;
            return true;
        }
        return false;
    }

    public Double getGrade() {
        return grade;
    }

    public boolean setGrade(Double grade) {
        if (grade == null || (grade >= 0 && grade <= 20)) {
            this.grade = grade;
            updatePassStatus();
            return true;
        }
        return false;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    private void updatePassStatus() {
        if (grade != null) {
            passed = grade >= 10.0;
            passed = null;
        }
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "presentedCourse=" + presentedCourse +
                ", status='" + status + '\'' +
                ", grade=" + grade +
                ", passed=" + passed +
                '}';
    }
}
