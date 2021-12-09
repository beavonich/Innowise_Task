import java.util.*;

public class Test {
    public void action(List<Person> personList) {
        Scanner scanner = new Scanner(System.in);

        String continuee = "YES";
        String action = "";
        while (continuee.equals("YES")) {
            System.out.println("What do you want to do? CREATE PERSON(1) | ADD VALUES(2) | UPDATE VALUES(3)");
            action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.println("Enter name and surname using enter key");
                    personList.add(new Person(scanner.nextLine(), scanner.nextLine()));
                    break;
                case "2":
                    System.out.println("Enter number of person: ");
                    int number = scanner.nextInt();
                    personList.get(number).addEmail();
                    personList.get(number).addRole();
                    personList.get(number).addPhoneNumber();
                    break;
                case "3":
                    System.out.println("What value do you want to update? Name(1) | Surname(2) | " +
                            "email(3) | roles(4) | phone numbers(5)");
                    break;
            }

            System.out.println("Do you want to continue? Enter YES or NO");
            continuee = scanner.nextLine();
        }
    }




    public static void main(String[] args) throws Throwable {
        List<Person> personList = new ArrayList<>();
        Test test = new Test();

        test.action(personList);
        System.out.println(personList.get(0).getName());
        System.out.println(personList.get(0).getSurname());

    }
}
