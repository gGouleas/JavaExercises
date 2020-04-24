import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author JohnG
 */
public class Student_seats {

    public static void main(String[] args) {
        int classRows;
        int numOfStudents;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please choose the number of rows.");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Must be a number!");
            }
            classRows = sc.nextInt();
        } while (classRows <= 0);
        do {
            System.out.println("Please choose the number of students.");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Must be a number!");
            }
            numOfStudents = sc.nextInt();
        } while (numOfStudents <= 0);

        int seats = numOfStudents / classRows;
        int lastRow = (numOfStudents / classRows) + (numOfStudents % classRows);
        String[][] classroom = new String[classRows][];
        for (int i = 0; i < classroom.length - 1; i++) {
             classroom[i] = new String[seats];
            for (int j = 0; j < seats; j++) {
                System.out.print(" " + classroom[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < lastRow; i++) {
            classroom[classroom.length - 1] = new String[lastRow];
            System.out.print(" " + classroom[classroom.length - 1][i]);
        }
        System.out.println();
        Random rand = new Random();
        int count = 0;
        int randRow;
        int randSeat;
        while (count < numOfStudents) {
            randRow = rand.nextInt(classRows);
            if(randRow == classRows-1) {
                randSeat = rand.nextInt(lastRow);
            } else if(seats == 1){
                randSeat = 0;
            }else{  
                randSeat = rand.nextInt(seats);  
            }
            if (classroom[randRow][randSeat] == null) {
                System.out.println(numOfStudents-count+" seats are empty.");
                System.out.println("Please give me the name of the student at seat:["+(randRow+1)+"],["+(randSeat+1)+"]");
                classroom[randRow][randSeat] = sc.next();
                count++;
            } 
        }
        System.out.println("Thank you! here is the class:");
        for (int i = 0; i < classroom.length - 1; i++) {
            for (int j = 0; j < seats; j++) {
                System.out.print(classroom[i][j]+"\t");
            }
            System.out.println();
        }
        for (int i = 0; i < lastRow; i++) {
            System.out.print(classroom[classroom.length - 1][i]+"\t");
        }
    }
}
