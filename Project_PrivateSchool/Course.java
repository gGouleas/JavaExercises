package indproject_privateschool;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JohnG;
 */
public class Course {

    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private final LocalDate end_date;
    private List<Student> students;
    private List<Trainer> trainers;
    public static int count;

    public Course(String stream, String type) {
        count++;
        this.title = "CB" + (count / 6 + 1); //when you exceed 5 streams per course, move to the next CB 
        this.stream = stream;
        this.type = type;
        this.start_date = "F".equals(type) ? LocalDate.now().plusMonths(count / 6 * 3) : LocalDate.now().plusMonths(count / 6 * 4);
        this.end_date = "F".equals(type) ? start_date.plusMonths(3) : start_date.plusMonths(4);//3 months full time 4 for online
        this.students = new ArrayList();
        this.trainers = new ArrayList();
    }

    //Unused method
    public static void resetCoursesCounter() {
        count = 1;
    }

    public static void printCourse(Course mathima) {
        System.out.printf("Title: %s  Stream: %-14s Type: %-10s\t", mathima.getTitle(), mathima.getStream(), mathima.getType());
        System.out.print("Start Date: " + mathima.getStartDate());
        System.out.print("\tEnd Date: " + mathima.getEndDate() + "\n");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return this.stream;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        if ("F".equals(this.type)) {
            return "Fulltime";
        } else if ("P".equals(this.type)) {
            return "Partime";
        } else if ("O".equals(this.type)) {
            return "Online";
        } else {
            return "None";
        }
    }

    public void setStartDate(LocalDate date) {
        this.start_date = date;
    }

    public LocalDate getStartDate() {
        return this.start_date;
    }

    public void setEndDate(LocalDate date) {
        this.start_date = date;
    }

    public LocalDate getEndDate() {
        return this.end_date;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }else{
            ListOfObjects.getRecurringStudents().remove(student);
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

}
