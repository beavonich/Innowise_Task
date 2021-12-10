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
            int number;
            switch (action) {
                case "1":
                    personList.add(new Person(null, null));
                    System.out.println("Enter name: ");
                    personList.get(personList.size() - 1).updateName();
                    System.out.println("Enter surname: ");
                    personList.get(personList.size() - 1).updateSurname();
                    personList.get(personList.size() - 1).setEmail();
                    personList.get(personList.size() - 1).addRole();
                    personList.get(personList.size() - 1).addPhoneNumber();

                    break;
                case "2":
                    System.out.println("Enter person number: ");
                    for(int i = 0; i < personList.size(); i++){
                        System.out.println((i + 1) + ") " + personList.get(i).getName() + " "
                                + personList.get(i).getSurname());
                    }
                    number = scanner.nextInt() - 1;
                    System.out.println("What value do you want to add? role(1) | phone number(2)");
                    choice = scanner.nextLine();  // Почему-то если оставить один сканнер, то он не срабатывает
                    choice = scanner.nextLine();
                    switch (choice){
                        case "1":
                            personList.get(number).addRole();
                            break;
                        case "2":
                            personList.get(number).addPhoneNumber();
                            break;
                        default:
                            System.out.println("Something went wrong");
                    }

                    break;
                case "3":
                    System.out.println("Enter person number: ");
                    for(int i = 0; i < personList.size(); i++){
                        System.out.println((i + 1) + ") " + personList.get(i).getName() + " "
                                + personList.get(i).getSurname());
                    }
                    number = scanner.nextInt() - 1;
                    System.out.println("What value do you want to update? Name(1) | Surname(2) | " +
                            "email(3) | roles(4) | phone numbers(5)");
                    choice = scanner.nextLine();
                    choice = scanner.nextLine();
                    switch (choice){
                        case "1":
                            System.out.println("Enter new name");
                            personList.get(number).updateName();
                            break;
                        case "2":
                            System.out.println("Enter new surname");
                            personList.get(number).updateSurname();
                            break;
                        case "3":
                            personList.get(number).setEmail();
                            break;
                        case "4":
                            personList.get(number).updateRole();
                            break;
                        case "5":
                            personList.get(number).updatePhoneNumber();
                            break;
                        default:
                            System.out.println("Something went wrong");
                    }

                    break;
                case "4":
                    System.out.println("\nEnter person number: ");
                    for(int i = 0; i < personList.size(); i++){
                        System.out.println((i + 1) + ") " + personList.get(i).getName() + " "
                                + personList.get(i).getSurname());
                    }
                    int index = scanner.nextInt() - 1;
                    try{
                        personList.remove(index);
                        System.out.println("Person " + (index + 1) + " has been deleted successfully");
                    }catch (Exception e){
                        System.out.println("Something went wrong");
                    }

                    continuee = scanner.nextLine();
                    break;
                case "5":
                    Person.getListOfPeople(personList);
                    break;
                case "6":
                    Person.getListOfPeople(personList);
                    int personNumber = scanner.nextInt() - 1;
                    System.out.println(personList.get(personNumber).toString());
                    continuee = scanner.nextLine(); // Опять проблема со scanner

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
