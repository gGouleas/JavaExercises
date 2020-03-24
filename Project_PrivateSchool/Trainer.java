package indproject_privateschool;

/**
 *
 * @author JohnG;
 */
public class Trainer {

    private String firstName;
    private String lastName;
    private String subject;
    private Course course;

    public Trainer(String firstName, String lastName, Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.subject = course.getStream();
    }

    public static void printTrainer(Trainer trainer) {
        System.out.printf("first name: %-10s\tlast name: %-15s\tsubject: %-10s\n", trainer.getFirstName(), trainer.getLastName(), trainer.getSubject());
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public String getSubject() {
        return subject;
    }
}
