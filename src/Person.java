import java.util.*;

public class Person {
    private String name;
    private String surname;
    private String email;
    private HashMap<String, Integer> roles = new LinkedHashMap<>();
    private String[] phoneNumbers = new String[3];
    private static int phoneCount = 0;
    Roles allUserRoles = new Roles();
    Scanner scanner = new Scanner(System.in);

    public void deletePerson() throws Throwable {

    }

    public HashMap<String, Integer> getRoles() {
        return roles;
    }

    public void addRole(){
        String accept = "YES";
        String role = "";


        while(accept.equals("YES")) {
            System.out.println("Enter role: ");
            role = scanner.nextLine();
            if(roles.size() == 1){
                if(allUserRoles.getRoleValue(role) == 3){
                    return;
                }
                if(allUserRoles.getRoleValue(role) + roles.values().iterator().next() == 3){
                    roles.put(role, allUserRoles.getRoleValue(role));
                    System.out.println("The role has been added succeed");
                }else{
                    System.out.println("It's impossible to add this role for this user");
                }
            }else if(roles.size() == 0){
                roles.put(role, allUserRoles.getRoleValue(role));
                System.out.println("The first role has been added succeed");
            }
            else{
                System.out.println("This user already has max count of roles");
            }
            if(Roles.getRoleValue(role) == 3)
                break;
            System.out.println("Do you want to add another role? Enter YES or NO");
            accept = scanner.nextLine();
        }

    }

    public String getPhoneNumbers() {
        return Arrays.toString(phoneNumbers);
    }

    public void addPhoneNumber() {
        String phoneNumber = "";
        String accept = "YES";
        while(accept.equals("YES") && phoneCount < 3){
            System.out.println("Enter phone number: ");
            phoneNumber = scanner.nextLine();
            if(phoneNumber.matches("375\\d{9}")){
                this.phoneNumbers[phoneCount] = phoneNumber;
                System.out.println("Number has been added successfully");
                phoneCount++;
            }else{
                System.out.println("Incorrect format of phone number");
            }
            System.out.println("Do you want to add a new phone number? Enter YES or NO");
            accept = scanner.nextLine();
        }

    }

    public String getEmail() {
        return email;
    }

    public void addEmail() {
        String email = "";
        System.out.println("Enter email: ");
        email = scanner.nextLine();
        if(email.matches("[\\w\\W]+@\\w+\\.\\w+")){
            this.email = email;
            System.out.println("Email has been added successfully ");
        }else{
            System.out.println("The email has not be added");
        }
    }

    public void updateName(){
        this.name = scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public void updateSurname(){
        this.surname = scanner.nextLine();
    }

    public String getSurname() {
        return surname;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
