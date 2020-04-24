package wordfinder;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author JohnG;
 */
public class MainClass {

    public static void main(String[] args) {
        String file = "C:\\Users\\Alex local\\Documents\\NetBeansProjects\\TestFiles\\aJourneyToTheInteriorOfTheEarth.txt";
        List<String> content = MainMethods.storeFile(file);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word you want to count");
        String word = sc.next();
        int wordCount = MainMethods.countWords(word, content);
        System.out.printf("Word %s was found %d times in the file\n", word, wordCount);

        TreeSet<String> sortedKeys = MainMethods.moreThan500(content);
        System.out.println("****Words that were found more than 500 times****");

        for (String key : sortedKeys) {
            System.out.print(key+" , ");
        }
    }
}
