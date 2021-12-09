import java.util.*;

public class Test {
    public void action(List<Person> personList) {
        Scanner scanner = new Scanner(System.in);

        String continuee = "YES";
        String action = "";
        String choice = "";
        while (continuee.equals("YES")) {
            System.out.println("What do you want to do? CREATE PERSON(1) | ADD VALUES(2) | UPDATE VALUES(3)");
            action = scanner.nextLine();
            int number;
            switch (action) {
                case "1":
                    System.out.println("Enter name and surname using enter key");
                    personList.add(new Person(scanner.nextLine(), scanner.nextLine()));
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
                            personList.get(number).updateName();
                            break;
                        case "2":
                            personList.get(number).updateSurname();
                            break;
                        case "3":
                            personList.get(number).setEmail();
                            break;
                        case "4":
                            personList.get(number).updateRole();
                            break;
                        case "5":

                            break;
                        default:
                            System.out.println("Something went wrong");
                    }

                    break;
                default:
                    System.out.println("Something went wrong");
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
