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
            System.out.println("Choose role: ");
            for(Map.Entry<String, Integer> m : Roles.getRoles().entrySet()){
                System.out.println(m.getKey() + ": lvl " + m.getValue());
            }
            role = scanner.nextLine();
            if(roles.size() == 1){
                if(allUserRoles.getRoleValue(role) == 3){
                    System.out.println("You can't to add this role for this user");
                    return;
                }
                if(allUserRoles.getRoleValue(role) + roles.values().iterator().next() == 3
                        && Roles.getRoleValue(role) > 0){
                    roles.put(role, allUserRoles.getRoleValue(role));
                    System.out.println("The role has been added succeed");
                }else{
                    System.out.println("It's impossible to add this role for this user");
                }
            }else if(roles.size() == 0 && Roles.getRoleValue(role) > 0){
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

    public void updateRole(){
        System.out.println("At this moment the person has role(s): ");
        for(Map.Entry<String, Integer> hm : roles.entrySet()){
            System.out.println(hm.getKey());
        }
        System.out.println("Enter role, which you want to replace");
        String role = scanner.nextLine();
        String newRole;
        if(roles.size() == 1){
            System.out.println("Choose role: ");
            for(Map.Entry<String, Integer> m : Roles.getRoles().entrySet())
                System.out.println(m.getKey() + ": lvl " + m.getValue());
            newRole = scanner.nextLine();
            if(Roles.getRoleValue(newRole) > 0){
                roles.put(newRole, roles.remove(role));
            }else{
                System.out.println("Something went wrong");
            }
        }else{
            System.out.println("You can replace this role on");
            for(Map.Entry<String, Integer> m : Roles.getRoles().entrySet()){
                if(m.getValue() == Roles.getRoleValue(role))
                    System.out.println(m.getKey() + ": lvl " + m.getValue());
            }
            newRole = scanner.nextLine();
            if(Roles.getRoleValue(newRole) == Roles.getRoleValue(role)){
                roles.put(newRole, roles.remove(role));
            }else{
                System.out.println("Something went wrong");
            }


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

    public void setEmail() {
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
