package indproject_privateschool;

import static indproject_privateschool.Course.count;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author JohnG;
 */
public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;
    private Course course;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    public static void printStudent(Student student) {
        System.out.printf("first name: %-10s\tlast name: %-10s\tdate of birth: %-8s\t fees:%d\u20AC\n", student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getFees());
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

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public int getFees() {
        return tuitionFees;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public boolean containsStudent() {
        if (ListOfObjects.getStudents().contains(this)) {
            return true;
        }
        return false;
    }

    //Override equals, which is used in "contains" method
    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student toCompare = (Student) o;
            return this.firstName.equals(toCompare.firstName) && this.lastName.equals(toCompare.lastName) && this.dateOfBirth.equals(toCompare.dateOfBirth);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.firstName);
        hash = 37 * hash + Objects.hashCode(this.lastName);
        hash = 37 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }

}
