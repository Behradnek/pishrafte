public class PresentedCourse {
    private String courseName;
    private Professor instructor;
    private Room room;
    private Section sectionTime;

    public PresentedCourse(String courseName, Professor instructor, Room room, Section sectionTime) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.room = room;
        this.sectionTime = sectionTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Professor getInstructor() {
        return instructor;
    }

    public void setInstructor(Professor instructor) {
        this.instructor = instructor;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Section getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(Section sectionTime) {
        this.sectionTime = sectionTime;
    }

    @Override
    public String toString() {
        return "PresentedCourse{" +
                "courseName='" + courseName + '\'' +
                ", instructor=" + instructor +
                ", room=" + room +
                ", sectionTime=" + sectionTime +
                '}';
    }
}
