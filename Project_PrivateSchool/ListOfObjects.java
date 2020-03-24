package indproject_privateschool;

import static indproject_privateschool.Course.count;
import java.util.ArrayList;

/**
 *
 * @author JohnG;
 */
public class ListOfObjects {

    private static ArrayList<Course> courses;
    private static ArrayList<Trainer> trainers;
    private static ArrayList<Student> students;
    private static ArrayList<Assignment> assignments;
    private static ArrayList<Student> recurringStudents; //Contains all students in more courses than one

    public static void addCourses(Course course) {
        if (courses == null) {
            courses = new ArrayList();
        }
        courses.add(course);
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    public static void addTrainers(Trainer trainer) {
        if (trainers == null) {
            trainers = new ArrayList();
        }
        if (!trainers.contains(trainer)) {
            trainers.add(trainer);
        }
    }

    public static ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public static void addStudents(Student student) {
        if (students == null) {
            students = new ArrayList();
        }
        //If the student is already in a course put this instance in an other list.
        if (student.containsStudent()== true) {
            if (recurringStudents == null) {
                recurringStudents = new ArrayList();
            }
            recurringStudents.add(student);
        }
        students.add(student);
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void addAssignments(Assignment assignment) {
        if (assignments == null) {
            assignments = new ArrayList();
        }
        assignments.add(assignment);
    }

    public static ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public static ArrayList<Student> getRecurringStudents() {
        return recurringStudents;
    }

}
