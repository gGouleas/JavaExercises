package exercise_luckyday;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author JohnG
 */
public class Exercise_LuckyDay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age;
        String name;
        char gender;
        int favSeason;
        double height;
        double weight;

        while (true) {
            try {       
                do {
                    System.out.println("Hello please enter your name and then your gender(M for Male or F for Female).");
                    name = sc.next();
                    gender = sc.next().charAt(0);
                    if (gender == 'M') {
                        System.out.print("Ok Mr " + name + ", please enter your age. ");
                        break;
                    } else if (gender == 'F') {
                        System.out.print("Ok Ms " + name + ", please enter your age. ");
                        break;
                    } else {
                        System.out.println("Invalid gender. Try again!");
                    }
                } while (true);

                int counter = 0;
                do {
                    System.out.println("Age is a positive number.");
                    while (!sc.hasNextInt()) {
                        sc.next();
                        if (counter < 1) {
                            System.out.println("That is not a number. Please try again.");
                        } else if (counter >= 1) {
                            System.out.println(name + ", please be serious. We have work to do!");
                        }
                        counter++;
                    }
                    age = sc.nextInt();
                } while (age <= 0);

                printAgeInfo(age, name);

//                System.exit(0); This method terminates the program.
//                System.gc(); This method attempts to clear the memory.
                System.out.println("Very well " + name + " now choose your favorite season. Press:\n1 for winter\n2 for spring\n3 for summer\n4 for autumn.");

                do {
                    while (!sc.hasNextInt()) {
                        sc.next();
                        System.out.println(name + ", that is not a number. Did you skip classes at school?");
                    }
                    favSeason = sc.nextInt();
                    if (favSeason < 1 || favSeason > 4) {
                        System.out.println(name + ", I just showed you the valid values to press. Please try again.");
                    }
                } while (favSeason < 1 || favSeason > 4);
                favSeason(favSeason);

                System.out.println(name + " now enter your height in meters and then your weight in kgs..");
                height = sc.nextDouble();
                weight = sc.nextDouble();

                BMI(height, weight);

                int luckyDay = luckyDay(age);
                // System.out.println("lucky day value: " + luckyDay);
                if (luckyDay > 6) {
                    luckyDay = luckyDay % 7;
                }
                switch (luckyDay) {
                    case 0:
                        System.out.println("Your lucky day is Monday");
                        break;
                    case 1:
                        System.out.println("Your lucky day is Tuesday");
                        break;
                    case 2:
                        System.out.println("Your lucky day is Wednesday");
                        break;
                    case 3:
                        System.out.println("Your lucky day is Thursday");
                        break;
                    case 4:
                        System.out.println("Your lucky day is Friday");
                        break;
                    case 5:
                        System.out.println("Your lucky day is Saturday");
                        break;
                    case 6:
                        System.out.println("Your lucky day is Sunday");
                        break;
                }
                if (luckyDay == 2 && age >= 20 && age <= 40) {
                    if (gender == 'M') {
                        System.out.println("Welcome Mr. " + name + ", you can enter the club!");
                    } else {
                        System.out.println("Are you married?");
                        do {
                            String married = sc.next();
                            if ("yes".equals(married)) {
                                System.out.println("Welcome Mrs. " + name + ", you can enter the club!");
                                break;
                            } else if ("no".equals(married)) {
                                System.out.println("Welcome Ms. " + name + ", you can enter the club!");
                                break;
                            } else {
                                System.out.println("invalid input. Please answer with 'yes' or 'no'.");
                            }
                        } while (true);
                    }
                } else {
                    System.out.println("Sorry " + name + ", you do not fill the requirements to enter the private club because: ");
                    if (luckyDay != 2) {
                        System.out.println("your lucky day is not Wednesday.");
                    }
                    if (age < 20) {
                        System.out.println("you are too young.");
                    } else if (age > 40) {
                        System.out.println("you are too old.");
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("****Restarting****");
            }
        }
    }

    static void printAgeInfo(int age, String name) {
        if (age >= 0 && age <= 5) {
            System.out.print(name + " you are too young for this app.");
            if (6 - age == 1) {
                System.out.println("Come back next year when you will be a student.");
            } else {
                System.out.println("Come back in " + (6 - age) + " years when you will be a student.");
            }
        } else if (age >= 6 && age <= 18) {
            System.out.println(name + " you are a student.");
            if (18 - age == 1) {
                System.out.println("Keep up... 1 more year left and afterwards you will make money.");
            } else {
                System.out.println("Keep up... " + (18 - age) + " more years left and afterwards you will make money.");
            }
        } else if (age >= 19 && age <= 40) {
            System.out.println(name + " Well, you must be emplyed.");
            if (age - 18 == 1) {
                System.out.println("You finished school last year.");
            } else {
                System.out.println("You finished school " + (age - 18) + " years ago.");
            }
        } else {
            System.out.println("You are too old for this app.");
        }
        if (age > LocalDate.now().getYear() - 1980) {
            System.out.println(name + " you were " + (1980 - (LocalDate.now().getYear() - age)) + " years old in 1980, and you will be " + (2040 - (2020 - age)) + " years old in 2040.");
        } else {
            System.out.println("you were not born in 1980!");
        }
    }

    static void favSeason(int a) {
        if (a == 1) {
            System.out.println("It must be cold outside");
        } else if (a == 2) {
            System.out.println("Ohh, flowers are very beautiful these days");
        } else if (a == 3) {
            System.out.println("Let's go for swimming");
        } else if (a == 4) {
            System.out.println("The trees are full of brown leaves");
        } else {
            System.out.println("Invalid number");
        }
    }

    static void BMI(double h, double w) {
        double bmi = w / Math.pow(h, 2);
        System.out.println("Your bmi is: " + bmi);
        if (bmi < 18.5) {
            System.out.println("you are underweight.");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("you have normal weight.");
        } else if (bmi >= 25 && bmi <= 29.9) {
            System.out.println("you are overweight.");
        } else if (bmi >= 30) {
            System.out.println("you are obese! you could use a diet!");
        } else {
            System.out.println("invalid values");
        }
    }

    static int luckyDay(int age) {
        int ageToDays = age * 365;

        int sum = 0;
        while (ageToDays > 0) {
            sum += ageToDays % 10;
            ageToDays = ageToDays / 10;
        }
        return sum;
    }
}
