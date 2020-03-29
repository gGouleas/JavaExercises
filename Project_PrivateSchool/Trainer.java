package indproject_privateschool;

/**
 *
 * @author JohnG;
 */
public class Trainer {

    private String firstName;
    private String lastName;
    private String subject;
    
    public Trainer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
