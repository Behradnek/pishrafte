public class Room {
    private String roomNumber;
    private String facultyName;
    private int seatingCapacity;
    private boolean suitableForClass;

    public Room(String roomNumber, String facultyName) {
        this.roomNumber = roomNumber;
        this.facultyName = facultyName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public boolean isSuitableForClass() {
        return suitableForClass;
    }

    public void setSuitableForClass(boolean suitableForClass) {
        this.suitableForClass = suitableForClass;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", suitableForClass=" + suitableForClass +
                '}';
    }
}
