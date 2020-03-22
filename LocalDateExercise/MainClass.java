package localdatetimeexercise;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JohnG;
 */
public class MainClass {

    public static void main(String[] args) {
        List<Bootcamp> listOfBootcamps = inputToList();
        availableBootcamp(listOfBootcamps);
    }

    private static List<Bootcamp> inputToList() {
        List<Bootcamp> listOfBootcamps = new ArrayList();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter name for bootcamp No." + (i + 1));
            while (sc.hasNextInt()) {
                System.out.println("This is a number not a name");
                sc.next();
            }
            String name = sc.next();
            while (true) {
                try {
                    System.out.println("Enter Bootcamp starting date.");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate start = LocalDate.parse(sc.next(), formatter);
                    System.out.println("Enter Bootcamp ending date");
                    LocalDate end = LocalDate.parse(sc.next(), formatter);
                    Bootcamp bootcamp = new Bootcamp(name, start, end);
                    System.out.println("***Bootcamp created***");
                    listOfBootcamps.add(bootcamp);
                    break;
                } catch (Exception e) {
                    System.out.println("invalid date format. " + e.getMessage());
                }
            }
        }
        return listOfBootcamps;
    }

    private static void availableBootcamp(List<Bootcamp> list) {
        LocalDate date = null;
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Now enter a date to show available bootcamp.");
        while (true) {
            try {
                date = LocalDate.parse(sc.next(), formatter);
                break;
            } catch (Exception e) {
                System.out.println("invalid date format. " + e.getMessage());
            }
        }
        boolean found = false;
        for (Bootcamp b : list) {
            if (date.isAfter(b.getStartingDate()) && date.isBefore(b.getEndingDate())) {
                System.out.println("***Found available bootcamp!***");
                System.out.printf("Name: %s Start date: %s End date: %s\n", b.getName(), b.getStartingDate(), b.getEndingDate());
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Sorry, no available bootacamp at date " + date.format(formatter));
        }
        sc.close();
    }
}
