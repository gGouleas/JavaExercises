package indproject_privateschool;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JohnG;
 */
public class MyMainClass {

    public static void main(String[] args) {

        dataInputFromUser();
        if (ListOfObjects.getCourses() == null) {
            syntheticCourses();
        }
        if (ListOfObjects.getTrainers() == null) {
            syntheticTrainers(ListOfObjects.getCourses());
        }
        if (ListOfObjects.getStudents() == null) {
            syntheticStudents(ListOfObjects.getCourses());
        }
        if (ListOfObjects.getAssignments() == null) {
            assignments(ListOfObjects.getCourses());
        }
        mainMenu();
        findAssignment();
    }

    //This method gets inputs regarding courses,trainers,students and fills lists with objects.
    private static void dataInputFromUser() {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        System.out.println("Please type a list of courses (each CB has 5 courses). Press 's' to stop");
        do {
            String name;
            String type;
            if (count == 5) {
                count = 1;
            }
            System.out.println("CB" + (Course.count / 6 + 1) + " stream No." + count);
            while (sc.hasNextInt()) {
                System.out.println("This is not a course name! Try again.");
                sc.next();
            }
            name = sc.next();
            if ("s".equals(name)) {
                break;
            }
            do {
                System.out.println(name + " type: ('F' for Fulltime,'P' for Partime, 'O' for Online)");
                type = sc.next();
            } while (!"F".equals(type) && !"P".equals(type) && !"O".equals(type));
            Course course = new Course(name, type);
            ListOfObjects.addCourses(course);
            System.out.println("Please give the details of all the trainers in course CB" + (Course.count / 6 + 1) + " stream:" + course.getStream() + ". Press 's' to stop.");
            int tempCounter = 1;
            do {
                System.out.println("Type the FIRST name of trainer No." + tempCounter);
                while (sc.hasNextInt()) {
                    System.out.println("This is not a trainer name! Try again.");
                    sc.next();
                }
                String fname = sc.next();
                if ("s".equals(fname)) {
                    break;
                }
                System.out.println("Type the LAST name of the trainer No." + tempCounter++);
                while (sc.hasNextInt()) {
                    System.out.println("This is not a trainer name! Try again.");
                    sc.next();
                }
                String lname = sc.next();
                Trainer trainer = new Trainer(fname, lname);
                trainer.setSubject(course.getStream());
                course.addTrainer(trainer);
                ListOfObjects.addTrainers(trainer);
            } while (true);
            System.out.println("Please give the details of all the students in course CB" + (Course.count / 6 + 1) + " stream:" + course.getStream() + ". Press 's' to stop.");
            tempCounter = 1;
            do {
                System.out.println("Type the First name of student No." + tempCounter);
                while (sc.hasNextInt()) {
                    System.out.println("This is not a student name! Try again.");
                    sc.next();
                }
                String fname = sc.next();
                if ("s".equals(fname)) {
                    break;
                }
                System.out.println("Type the LAST name of the student No." + tempCounter);
                while (sc.hasNextInt()) {
                    System.out.println("This is not a student name! Try again.");
                    sc.next();
                }
                String lname = sc.next();
                LocalDate dateOfBirth;
                while (true) {
                    try {
                        System.out.println("Give date of birth for student No." + tempCounter);
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        dateOfBirth = LocalDate.parse(sc.next(), formatter);
                        break;
                    } catch (Exception e) {
                        System.out.println("invalid date format.." + e.getMessage());
                    }
                }
                System.out.println("Give tuition fees of student No." + tempCounter++);
                int fees;
                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Money is counted in numbers, not words!");
                        sc.next();
                    }
                    fees = sc.nextInt();
                } while (fees < 0);
                Student student = new Student(fname, lname, dateOfBirth, fees);
                ListOfObjects.addStudents(student);
                course.addStudent(student);
            } while (true);
            count++;
        } while (true);
    }

    //**Synthetic courses**
    private static void syntheticCourses() {
        Course cb1a = new Course("Astrophysics", "F");
        ListOfObjects.addCourses(cb1a);
        Course cb1b = new Course("Astrophysics", "P");
        ListOfObjects.addCourses(cb1b);
        Course cb1c = new Course("Biochemistry", "F");
        ListOfObjects.addCourses(cb1c);
        Course cb1d = new Course("Biochemistry", "P");
        ListOfObjects.addCourses(cb1d);
        Course cb1e = new Course("Robotics", "O");
        ListOfObjects.addCourses(cb1e);
        Course cb2e = new Course("Robotics", "O");
        ListOfObjects.addCourses(cb2e);
    }

    //**Synthetic trainers get assigned to a random course from the list then put into their own list
    private static void syntheticTrainers(ArrayList<Course> courses) {
        Random rand = new Random();
        Course randCourse;
        Trainer trainer1 = new Trainer("Mpampis", "Sourgias");
        randCourse = courses.get(rand.nextInt(courses.size()));
        randCourse.addTrainer(trainer1);
        trainer1.setSubject(randCourse.getStream());
        ListOfObjects.addTrainers(trainer1);
        Trainer trainer2 = new Trainer("Nikos", "Korompos");
        randCourse = courses.get(rand.nextInt(courses.size()));
        randCourse.addTrainer(trainer2);
        trainer2.setSubject(randCourse.getStream());
        ListOfObjects.addTrainers(trainer2);
        Trainer trainer3 = new Trainer("Fotis", "Stravokatsavidos");
        randCourse = courses.get(rand.nextInt(courses.size()));
        randCourse.addTrainer(trainer3);
        trainer3.setSubject(randCourse.getStream());
        ListOfObjects.addTrainers(trainer3);
        Trainer trainer4 = new Trainer("Themis", "Karampouzouklis");
        randCourse = courses.get(rand.nextInt(courses.size()));
        randCourse.addTrainer(trainer4);
        trainer4.setSubject(randCourse.getStream());
        ListOfObjects.addTrainers(trainer4);
        Trainer trainer5 = new Trainer("Dimitra", "Dimitriou");
        randCourse = courses.get(rand.nextInt(courses.size()));
        randCourse.addTrainer(trainer5);
        trainer5.setSubject(randCourse.getStream());
        ListOfObjects.addTrainers(trainer5);
        Trainer trainer6 = new Trainer("Kanelos", "Foufoutos");
        randCourse = courses.get(rand.nextInt(courses.size()));
        randCourse.addTrainer(trainer6);
        trainer6.setSubject(randCourse.getStream());
        ListOfObjects.addTrainers(trainer6);
        Trainer trainer7 = new Trainer("Maria", "Marakh");
        randCourse = courses.get(rand.nextInt(courses.size()));
        randCourse.addTrainer(trainer7);
        trainer7.setSubject(randCourse.getStream());
        ListOfObjects.addTrainers(trainer7);
        Trainer trainer8 = new Trainer("Eleni", "Elenakh");
        randCourse = courses.get(rand.nextInt(courses.size()));
        randCourse.addTrainer(trainer8);
        trainer8.setSubject(randCourse.getStream());
        ListOfObjects.addTrainers(trainer8);
    }

    //**Synthetic students get assigned a random course from the list then put into their own list
    private static void syntheticStudents(ArrayList<Course> courses) {
        Random rand = new Random();
        Course randCourse;
        Student student1 = new Student("Giannis", "Gouleas", LocalDate.of(2000, 1, 23), 1300);
        ListOfObjects.addStudents(student1);
        //randCourse = courses.get(rand.nextInt(courses.size()));
        randCourse = courses.get(0);
        randCourse.addStudent(student1);
        Student student2 = new Student("Tasos", "Lelakis", LocalDate.of(2001, 11, 24), 1460);
        randCourse = courses.get(rand.nextInt(courses.size()));
        ListOfObjects.addStudents(student2);
        randCourse.addStudent(student2);
        Student student3 = new Student("Orestis", "Tanis", LocalDate.of(2004, 8, 12), 2000);
        randCourse = courses.get(rand.nextInt(courses.size()));
        ListOfObjects.addStudents(student3);
        randCourse.addStudent(student3);
        Student student4 = new Student("Odysseas", "Korovesis", LocalDate.of(2002, 3, 29), 941);
        randCourse = courses.get(rand.nextInt(courses.size()));
        ListOfObjects.addStudents(student4);
        randCourse.addStudent(student4);
        Student student5 = new Student("Despoina", "Karavia", LocalDate.of(1995, 7, 14), 3090);
        randCourse = courses.get(rand.nextInt(courses.size()));
        ListOfObjects.addStudents(student5);
        randCourse.addStudent(student5);
        Student student6 = new Student("Kuriakos", "Polkas", LocalDate.of(1999, 7, 07), 1570);
        randCourse = courses.get(rand.nextInt(courses.size()));
        ListOfObjects.addStudents(student6);
        randCourse.addStudent(student6);
        Student student7 = new Student("Petros", "Trakadas", LocalDate.of(2002, 5, 01), 1800);
        randCourse = courses.get(rand.nextInt(courses.size()));
        ListOfObjects.addStudents(student7);
        randCourse.addStudent(student7);
        Student student8 = new Student("Giannis", "Gouleas", LocalDate.of(2000, 1, 23), 1300);
        randCourse = courses.get(rand.nextInt(courses.size()));
        ListOfObjects.addStudents(student8);
        randCourse.addStudent(student8);
    }

    //Students get 6 assignments, 1 every week, and a final project that expires at the end of the course
    private static void assignments(ArrayList<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            List<Student> students = course.getStudents();
            for (Student student : students) {
                LocalDate firstMonday = course.getStartDate();
                while (firstMonday.getDayOfWeek() != DayOfWeek.MONDAY) {
                    firstMonday = firstMonday.plusDays(1);
                }
                for (int j = 1; j <= 6; j++) {
                    Assignment assignment = new Assignment("Assignment_" + j, course.getStream() + " assignment", firstMonday.plusWeeks(j));
                    ListOfObjects.addAssignments(assignment);
                    assignment.setCourse(course);
                    assignment.setStudent(student);
                }
                Assignment assignment = new Assignment("Project", course.getStream() + " final project", course.getEndDate());
                ListOfObjects.addAssignments(assignment);
                assignment.setCourse(course);
                assignment.setStudent(student);
            }
        }
    }

    private static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        char input;
        do {
            System.out.println("What would you like to do?\n1.Print list of courses\n2.Print list of trainers\n3.Print list of students\n4.Print list of assignments");
            System.out.println("5.All students per course\n6.All trainers per course\n7.All assignments per course\n8.All assignments per student\n9.Mark an assignment\ns.Exit");
            input = sc.next().charAt(0);
            switch (input) {
                case 's':
                    break;
                case '1':
                    System.out.println("\n********Printing List of COURSES*********\n");
                    for (Course mathima : ListOfObjects.getCourses()) {
                        Course.printCourse(mathima);
                    }
                    break;
                case '2':
                    System.out.println("\n********Printing List of TRAINERS*********\n");
                    for (Trainer trainer : ListOfObjects.getTrainers()) {
                        Trainer.printTrainer(trainer);
                    }
                    break;
                case '3':
                    System.out.println("\n********Printing List of STUDENTS*********\n");
                    for (Student student : ListOfObjects.getStudents()) {
                        Student.printStudent(student);
                    }
                    break;
                case '4':
                    System.out.println("\n********Printing List of ASSIGNMENTS*********\n");
                    for (Assignment assignments : ListOfObjects.getAssignments()) {
                        Assignment.printAssignment(assignments);
                    }
                    break;
                case '5':
                    System.out.println("\n********Printing List of STUDENTS per COURSE*********\n");
                    for (Course mathima : ListOfObjects.getCourses()) {
                        System.out.println("**Studnets in course " + mathima.getTitle() + " " + mathima.getStream() + " " + mathima.getType() + "**\n");
                        for (Student student : mathima.getStudents()) {
                            Student.printStudent(student);
                        }
                        System.out.println();
                    }
                    break;
                case '6':
                    System.out.println("\n********Printing List of TRAINERS per COURSE*********\n");
                    for (Course mathima : ListOfObjects.getCourses()) {
                        System.out.println("**Trainers in course " + mathima.getTitle() + " " + mathima.getStream() + " " + mathima.getType() + "**\n");
                        for (Trainer trainer : mathima.getTrainers()) {
                            Trainer.printTrainer(trainer);
                        }
                        System.out.println();
                    }
                    break;
                case '7':
                    System.out.println("\n********Printing List of ASSIGNMENTS per COURSE*********\n");
                    for (Course mathima : ListOfObjects.getCourses()) {
                        System.out.println("**Assignments in course " + mathima.getTitle() + " " + mathima.getStream() + " " + mathima.getType() + "**\n");
                        for (Assignment assignment : ListOfObjects.getAssignments()) {
                            if (mathima.getTitle().equals(assignment.getCourse().getTitle()) && mathima.getStream().equals(assignment.getCourse().getStream())
                                    && mathima.getType().equals(assignment.getCourse().getType())) {
                                Assignment.printAssignment(assignment);
                            }
                        }
                        System.out.println();
                    }
                    break;
                case '8':
                    // For the following suppose there are no students with the same combination of name-surname. In case there are duplicates, dateOfBirth must be checked as well. 
                    System.out.println("\n********Printing List of ASSIGNMENTS per STUDENT*********\n");
                    for (Course mathima : ListOfObjects.getCourses()) {
                        List<Student> students = mathima.getStudents();
                        for (Student mathitis : students) {
                            System.out.printf("**Assignments for student %s %s %s %s** \n\n", mathitis.getFirstName(), mathitis.getLastName(), mathima.getTitle(), mathima.getStream());
                            for (Assignment assignment : ListOfObjects.getAssignments()) {
                                if (mathitis.getFirstName().equals(assignment.getStudent().getFirstName()) && mathitis.getLastName().equals(assignment.getStudent().getLastName())
                                        && assignment.getCourse().getStream().equals(mathima.getStream())) {
                                    Assignment.printAssignment(assignment);
                                }
                            }
                            System.out.println();
                        }
                    }
                    break;
                case '9':
                    try {
                        System.out.println("Select the assignment/project you want to mark");
                        System.out.println("Give the course of the assignment/project.");
                        String assignCourse = sc.next();
                        System.out.println("Give the first name of the student");
                        String assignFname = sc.next();
                        System.out.println("Give the last name of the student");
                        String assignLname = sc.next();
                        System.out.println("Specify the asssignment number of student " + assignFname + " " + assignLname + " that you want to mark.");
                        String assignNum = "Assignment_" + sc.nextInt();
                        boolean assignFound = false;
                        for (Assignment assignment : ListOfObjects.getAssignments()) {
                            if (assignment.getCourse().getTitle().equals(assignCourse) && assignment.getStudent().getFirstName().equals(assignFname)
                                    && assignment.getStudent().getLastName().equals(assignLname) && assignment.getTitle().equals(assignNum)) {
                                System.out.println("OK. Assignment found. Give your mark");
                                assignment.setTotalMark(sc.nextInt());
                                assignFound = true;
                            }
                        }
                        if (assignFound != true) {
                            System.out.println("Error 404 Assignment not found.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Oops, something went wrong...");
                        sc.next();
                        continue;
                    }
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while (input != 's');
        System.out.println("Would you like to show a list with all students that belong to more than a course? 'y' or 'n'");
        switch (sc.next().charAt(0)) {
            case 'y':
                if (ListOfObjects.getRecurringStudents().isEmpty()) {
                    System.out.println("No students in more than one course");
                } else {
                    System.out.println("****Showing students in more than one courses****\n");
                    for (Student student : ListOfObjects.getRecurringStudents()) {
                        boolean found = false;
                        for (Course course : ListOfObjects.getCourses()) {
                            if (course.getStudents().contains(student) && found == false) {
                                System.out.printf("Name: %-12s Surname: %-12s Courses: %-4s %-10s | ", student.getFirstName(), student.getLastName(),
                                        course.getTitle(), course.getStream());
                                found = true;
                            } else if ((course.getStudents().contains(student) && found == true)) {
                                System.out.printf("%-4s %-10s\n\n", course.getTitle(), course.getStream());
                            }
                        }
                    }
                }
        }
    }

    //Find assignments on specified date and print it along with the students. 
    private static void findAssignment() {
        Scanner sc = new Scanner(System.in);
        LocalDate date = null;
        boolean found = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.println("Give a date to see the assignment and the students who need to submit it");
            try {
                date = LocalDate.parse(sc.next(), formatter);
                while (date.getDayOfWeek() != DayOfWeek.MONDAY) {
                    date = date.minusDays(1);
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format.." + e.getMessage());
            }
        }
        System.out.println("****Assignments for sub week " + date.format(formatter) + " - " + date.plusDays(5).format(formatter) + "****\n");
        for (int i = 0; i < ListOfObjects.getAssignments().size(); i++) {
            Assignment assignment = ListOfObjects.getAssignments().get(i);
            if (assignment.getSubDateTime().equals(date)) {
                found = true;
                System.out.printf("Assignemt: %-10s  %-20s %-10s %s\n", assignment.getTitle(), assignment.getCourse().getStream(),
                        assignment.getStudent().getFirstName(), assignment.getStudent().getLastName());
            }
        }
        if (found == false) {
            System.out.println("No assignment found on " + date.format(formatter));
        }
        sc.close();
    }
}
