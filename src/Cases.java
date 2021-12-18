import java.util.List;
import java.util.Scanner;

public class Cases {
    private static Scanner scanner = new Scanner(System.in);


    public static void createPerson(List<Person> personList){
        personList.add(new Person(null, null));
        System.out.println("Enter name: ");
        personList.get(personList.size() - 1).updateName();
        System.out.println("Enter surname: ");
        personList.get(personList.size() - 1).updateSurname();
        personList.get(personList.size() - 1).setEmail();
        personList.get(personList.size() - 1).addRole();
        personList.get(personList.size() - 1).addPhoneNumber();
    }


    public static void addValues(List<Person> personList, int personNumber, String choice, String continuee){
        System.out.println("Enter person number: ");
        for(int i = 0; i < personList.size(); i++){
            System.out.println((i + 1) + ") " + personList.get(i).getName() + " "
                    + personList.get(i).getSurname());
        }

        try {
            personNumber = scanner.nextInt() - 1;
            personList.get(personNumber);
            System.out.println("What value do you want to add? role(1) | phone number(2)");
            choice = scanner.nextLine();  // Почему-то если оставить один сканнер, то он не срабатывает
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    personList.get(personNumber).addRole();
                    break;
                case "2":
                    personList.get(personNumber).addPhoneNumber();
                    break;
                default:
                    System.out.println("Something went wrong");
            }
        } catch(Exception e){
            System.out.println("Something went wrong");
            continuee = scanner.nextLine();
        }
    }


    public static void updateValues(List<Person> personList, int personNumber, String choice, String continuee){
        System.out.println("Enter person number: ");
        for(int i = 0; i < personList.size(); i++){
            System.out.println((i + 1) + ") " + personList.get(i).getName() + " "
                    + personList.get(i).getSurname());
        }
        try {
            personNumber = scanner.nextInt() - 1;
            personList.get(personNumber);
            System.out.println("What value do you want to update? Name(1) | Surname(2) | " +
                    "email(3) | roles(4) | phone numbers(5)");
            choice = scanner.nextLine();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter new name");
                    personList.get(personNumber).updateName();
                    break;
                case "2":
                    System.out.println("Enter new surname");
                    personList.get(personNumber).updateSurname();
                    break;
                case "3":
                    personList.get(personNumber).setEmail();
                    break;
                case "4":
                    personList.get(personNumber).updateRole();
                    break;
                case "5":
                    personList.get(personNumber).updatePhoneNumber();
                    break;
                default:
                    System.out.println("Something went wrong");
            }
        }catch (Exception e){
            System.out.println("Something went wrong");
            continuee = scanner.nextLine();
        }
    }


    public static void deletePerson(List<Person> personList, int personNumber, String continuee){
        System.out.println("\nEnter person number: ");
        for(int i = 0; i < personList.size(); i++){
            System.out.println((i + 1) + ") " + personList.get(i).getName() + " "
                    + personList.get(i).getSurname());
        }
        try {
            personNumber = scanner.nextInt() - 1;
            personList.remove(personNumber);
            System.out.println("Person " + (personNumber + 1) + " has been deleted successfully");

        }catch(Exception e){
            System.out.println("Something went wrong");
            continuee = scanner.nextLine();
        }
    }


    public static void getPersonInformation(List<Person> personList, int personNumber, String continuee){
        Person.getListOfPeople(personList);
        System.out.println("Enter number of person");
        try {
            personNumber = scanner.nextInt() - 1;
            System.out.println(personList.get(personNumber).toString());
            continuee = scanner.nextLine(); // Опять проблема со scanner
        }catch(Exception e){
            System.out.println("Something went wrong");
            continuee = scanner.nextLine();
        }
    }
}
