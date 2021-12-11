import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Action {
    public static void action(List<Person> personList) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        String continuee = "1";
        String action = "";
        String choice = "";
        while (continuee.equals("1") || continuee.equals("YES")) {
            System.out.println("What do you want to do? CREATE PERSON(1) | ADD VALUES(2) | UPDATE VALUES(3) | " +
                    "DELETE PERSON(4) | GET LIST OF PEOPLE(5) | GET INFORMATION ABOUT A PERSON(6)");
            action = scanner.nextLine();
            int personNumber = 0;
            switch (action) {
                case "1":
                    Cases.createPerson(personList);
                    break;
                case "2":
                    Cases.addValues(personList, personNumber, choice, continuee);
                    break;
                case "3":
                    Cases.updateValues(personList, personNumber, choice, continuee);
                    break;
                case "4":
                    Cases.deletePerson(personList, personNumber, continuee);
                    break;
                case "5":
                    Person.getListOfPeople(personList);
                    break;
                case "6":
                    Cases.getPersonInformation(personList, personNumber, continuee);
                    break;
                default:
                    System.out.println("Something went wrong");
            }

            Action.writeInFile(personList, "text.txt");

            System.out.println("Do you want to continue? Enter YES(1) or NO(2)");

            continuee = scanner.nextLine();
        }
    }



    public static void writeInFile(List<Person> personList, String path) throws FileNotFoundException {
        File file1 = new File(path);
        PrintWriter pw = new PrintWriter(file1);
        for(Person person : personList){
            pw.println(person.toString());
        }
        pw.close();
    }
}
