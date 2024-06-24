import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
    private static final int MAX_STUDENTS = 1000;
    private static final int MAX_COURSES = 500;
    private List<Student> students;
    private List<Course> courses;

    public University() {
        students = new ArrayList<>(MAX_STUDENTS);
        courses = new ArrayList<>(MAX_COURSES);
    }

    public static void main(String[] args) {
        University university = new University();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1- Add Student");
            System.out.println("2- Delete Student");
            System.out.println("3- Add Course");
            System.out.println("4- Delete Course");
            System.out.println("5- Print Students Info");
            System.out.println("6- Print Courses Info");
            System.out.println("7- Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    university.addStudent(scanner);
                    break;
                case 2:
                    university.deleteStudent(scanner);
                    break;
                case 3:
                    university.addCourse(scanner);
                    break;
                case 4:
                    university.deleteCourse(scanner);
                    break;
                case 5:
                    university.printStudentsInfo(scanner);
                    break;
                case 6:
                    university.printCoursesInfo();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private void addStudent(Scanner scanner) {
        if (students.size() >= MAX_STUDENTS) {
            System.out.println("Max capacity reached.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student number (7 digits): ");
        String studentNumber = scanner.nextLine();

        if (isValidStudentNumber(studentNumber)) {
            Student student = new Student(name, studentNumber, new StudentCourse[0]);
            students.add(student);
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Invalid student number. Must be 7 digits.");
        }
    }

    private void deleteStudent(Scanner scanner) {
        System.out.print("Enter student number to delete: ");
        String studentNumber = scanner.nextLine();

        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student is not found.");
        }
    }

    private void addCourse(Scanner scanner) {
        if (courses.size() >= MAX_COURSES) {
            System.out.println("Max capacity reached.");
            return;
        }

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter course number: ");
        String courseNumber = scanner.nextLine();
        System.out.print("Enter vahed (1-4): ");
        int creditHours = scanner.nextInt();
        scanner.nextLine();

        if (isValidCourseNumber(courseNumber) && creditHours >= 1 && creditHours <= 4) {
            Course course = new Course(courseName, courseNumber, creditHours);
            courses.add(course);
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Invalid course number or vahed.");
        }
    }

    private void deleteCourse(Scanner scanner) {
        System.out.print("Enter course number to delete: ");
        String courseNumber = scanner.nextLine();

        Course courseToRemove = null;
        for (Course course : courses) {
            if (course.getCourseNumber().equals(courseNumber)) {
                courseToRemove = course;
                break;
            }
        }

        if (courseToRemove != null) {
            courses.remove(courseToRemove);
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course is not found.");
        }
    }

    private void printStudentsInfo(Scanner scanner) {
        System.out.print("Enter student number or 'all': ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("all")) {
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            for (Student student : students) {
                if (student.getStudentNumber().equals(input)) {
                    System.out.println(student);
                    return;
                }
            }
            System.out.println("Student is not found.");
        }
    }

    private void printCoursesInfo() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private boolean isValidStudentNumber(String studentNumber) {
        return studentNumber.matches("\\d{7}");
    }

    private boolean isValidCourseNumber(String courseNumber) {
        return courseNumber.length() == 8 && 
               (courseNumber.charAt(0) == 'B' || courseNumber.charAt(0) == 'M' || courseNumber.charAt(0) == 'P');
    }
}
