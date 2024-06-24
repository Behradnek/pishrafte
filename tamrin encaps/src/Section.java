public class Section {
    private String startTime;
    private String endTime;
    private String[] daysOfWeek;
    private String semester;
    private String validationError;

    public Section(String startTime, String endTime, String[] daysOfWeek, String semester) {
        this.validationError = "";
        if (setStartTime(startTime) && setEndTime(endTime) && setDaysOfWeek(daysOfWeek)) {
            this.semester = semester;
        }
    }

    public String getStartTime() {
        return startTime;
    }

    public boolean setStartTime(String startTime) {
        if (!isValidTime(startTime)) {
            validationError = "Invalid start time format.";
            return false;
        }
        this.startTime = startTime;
        if (!validateDuration()) {
            return false;
        }
        return true;
    }

    public String getEndTime() {
        return endTime;
    }

    public boolean setEndTime(String endTime) {
        if (!isValidTime(endTime)) {
            validationError = "Invalid end time format.";
            return false;
        }
        this.endTime = endTime;
        if (!validateDuration()) {
            return false;
        }
        return true;
    }

    public String[] getDaysOfWeek() {
        return daysOfWeek;
    }

    public boolean setDaysOfWeek(String[] daysOfWeek) {
        if (daysOfWeek.length > 2) {
            validationError = "Section can be scheduled for a maximum of two days.";
            return false;
        }
        this.daysOfWeek = daysOfWeek;
        if (!validateDaysAndTimes()) {
            return false;
        }
        return true;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getValidationError() {
        return validationError;
    }

    private boolean isValidTime(String time) {
        if (time == null || time.length() != 5) return false;

        char c1 = time.charAt(0);
        char c2 = time.charAt(1);
        char c3 = time.charAt(2);
        char c4 = time.charAt(3);
        char c5 = time.charAt(4);

        if (c3 != ':' || !Character.isDigit(c1) || !Character.isDigit(c2) || !Character.isDigit(c4) || !Character.isDigit(c5)) {
            return false;
        }

        int hours = (c1 - '0') * 10 + (c2 - '0');
        int minutes = (c4 - '0') * 10 + (c5 - '0');

        return hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60;
    }

    private boolean validateDuration() {
        int startHour = Integer.parseInt(startTime.substring(0, 2));
        int startMinute = Integer.parseInt(startTime.substring(3));
        int endHour = Integer.parseInt(endTime.substring(0, 2));
        int endMinute = Integer.parseInt(endTime.substring(3));

        int durationMinutes = (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
        if (durationMinutes != 90 && durationMinutes != 120) {
            validationError = "Section duration must be either 90 minutes or 120 minutes.";
            return false;
        }
        return true;
    }

    private boolean validateDaysAndTimes() {
        if (daysOfWeek.length == 2) {
            if (daysOfWeek[0].equals(daysOfWeek[1]) || (!startTime.equals(endTime))) {
                validationError = "Start and end times must be the same on both days.";
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Section{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", daysOfWeek='" + String.join(", ", daysOfWeek) + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}
