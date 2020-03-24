package indproject_privateschool;

import java.time.LocalDate;

/**
 *
 * @author JohnG;
 */
public class Assignment {

    private String title;
    private String description;
    private LocalDate subDateTime;
    private int totalMark;
    private Course course;
    private Student student;

    public Assignment(String title, String description, LocalDate subDateTime) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
    }

    public static void printAssignment(Assignment assignment) {
        System.out.printf("Title: %-10s\tDescription: %-20s\tCourse: %-15s\tTotal mark:%d", assignment.getTitle(), assignment.getDescription(), assignment.getCourse().getStream(), assignment.getTotalMark());
        System.out.print("\tSub Date: " + assignment.getSubDateTime()+"\n");
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

}
