import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Person {
    private String name;
    private String surname;
    private String email;
    private HashMap<String, Integer> roles = new LinkedHashMap<>();
    private String[] phoneNumbers = new String[3];
    private int phoneCount = 0;
    private Roles allUserRoles = new Roles();
    Scanner scanner = new Scanner(System.in);


    public String getName() {
        return name;
    }

    public void updateName(){
        this.name = scanner.nextLine();
    }

    public String getSurname() {
        return surname;
    }
    public void updateSurname(){
        this.surname = scanner.nextLine();
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

    public HashMap<String, Integer> getRoles() {
        return roles;
    }

    public void addRole(){
        String accept = "1";
        String role = "";

        while(accept.equals("1") || accept.equals("YES")) {
            System.out.println("Choose role: ");
            for(Map.Entry<String, Integer> roles : Roles.getRoles().entrySet()){
                System.out.println(roles.getKey() + ": lvl " + roles.getValue());
            }
            role = scanner.nextLine();
            try {
                if(roles.size() == 1){
                    if (allUserRoles.getRoleValue(role) == 3) {
                        System.out.println("You can't add this role for this user");
                        return;
                    }
                    if (allUserRoles.getRoleValue(role) + roles.values().iterator().next() == 3
                            && Roles.getRoleValue(role) > 0) {
                        roles.put(role, allUserRoles.getRoleValue(role));
                        System.out.println("The role has been added successfully");

                    } else {
                        System.out.println("It's impossible to add this role for this user");
                    }
                }else if(roles.size() == 0 && Roles.getRoleValue(role) > 0){

                    roles.put(role, allUserRoles.getRoleValue(role));
                    System.out.println("The first role has been added successfully");

                }
                else{
                    System.out.println("This user already has max count of roles");
                }
                if(Roles.getRoleValue(role) == 3)
                    break;
            }catch(Exception e) {
                System.out.println("There is no such role");
            }finally {
                System.out.println("Do you want to add a new role? Enter YES(1) or NO(2)");
                accept = scanner.nextLine();
                continue;
            }
        }

    }

    public void updateRole(){
        String accept = "1";
        String role = "";

        while(accept.equals("1") || accept.equals("YES")) {
            System.out.println("At this moment the person has role(s): ");
            for (Map.Entry<String, Integer> personRole : roles.entrySet()) {
                System.out.println(personRole.getKey());
            }
            System.out.println("Enter role, which you want to replace");
            role = scanner.nextLine();

            String newRole;
            try {
                if(roles.get(role) == null){
                    throw new Exception();  // Чтобы в случае ненахождения этой роли, код продолжал выполняться в catch
                };
                if (roles.size() == 1) {
                    System.out.println("Choose role: ");
                    for (Map.Entry<String, Integer> personRole : Roles.getRoles().entrySet())
                        System.out.println(personRole.getKey() + ": lvl " + personRole.getValue());
                    newRole = scanner.nextLine();
                    if (Roles.getRoleValue(newRole) > 0) {
                        roles.put(newRole, roles.remove(role));
                        System.out.println("The role has been updated successfully");
                    } else {
                        System.out.println("Something went wrong");
                    }
                } else {
                    System.out.println("You can replace this role on");
                    for (Map.Entry<String, Integer> replacedRole : Roles.getRoles().entrySet()) {
                        if (replacedRole.getValue() == Roles.getRoleValue(role))
                            System.out.println(replacedRole.getKey() + ": lvl " + replacedRole.getValue());
                    }
                    newRole = scanner.nextLine();
                    if (Roles.getRoleValue(newRole) == Roles.getRoleValue(role)) {
                        try {
                            roles.put(newRole, roles.remove(role));
                            System.out.println("The role has been updated successfully");
                        } catch (Exception e) {
                            System.out.println("No such role");
                        }
                    } else {
                        System.out.println("Something went wrong");
                    }


                }
            }catch(Exception e) {
                System.out.println("There is no such role");
            }finally {
                System.out.println("Do you want to update role? Enter YES(1) or NO(2)");
                accept = scanner.nextLine();
                continue;
            }
        }
    }

    public String getPhoneNumbers() {
        return Arrays.toString(phoneNumbers);
    }

    public void addPhoneNumber() {
        String phoneNumber = "";
        String accept = "1";
        while((accept.equals("1") || accept.equals("YES")) && phoneCount <= 3){
            System.out.println("Enter phone number: ");
            phoneNumber = scanner.nextLine();
            if(phoneNumber.matches("375\\d{9}")){
                try{
                    this.phoneNumbers[phoneCount] = phoneNumber;
                    System.out.println("Number has been added successfully");
                    phoneCount++;
                }catch (Exception e){
                    System.out.println("This user already has max count of phone numbers");
                }finally {
                    System.out.println("Do you want to add a new phone number? Enter YES(1) or NO(2)");
                    accept = scanner.nextLine();
                    continue;
                }

            }else{
                System.out.println("Incorrect format of phone number");
            }
            System.out.println("Do you want to add a new phone number? Enter YES(1) or NO(2)");
            accept = scanner.nextLine();
        }

    }

    public void updatePhoneNumber(){
        System.out.println("At this moment the person has phone number(s): ");
        for(int i = 0; i < phoneNumbers.length; i++){
            if(phoneNumbers[i] == null){
                break;
            }else{
                System.out.println((i + 1) + ") " + phoneNumbers[i]);
            }
        }
        System.out.println("Enter number of phone number, which you want to replace");
        int numberOfPhoneNumber = scanner.nextInt();
        try{
            System.out.println("Enter new phone-number");
            String newPhoneNumber = scanner.nextLine();
            newPhoneNumber = scanner.nextLine();
            phoneNumbers[numberOfPhoneNumber - 1] = newPhoneNumber;
            System.out.println("The phone number has been updated successfully");
        }catch (Exception e){
            System.out.println("Something went wrong");
        }

    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getNameAndSurname(){
        return this.getName() + " "  + this.getSurname();
    }

    public static void getListOfPeople(List<Person> personList){
        for(int i = 0; i < personList.size(); i++){
            System.out.println((i + 1) + ") " + personList.get(i).getNameAndSurname());
        }
    }

    @Override
    public String toString() {
        String roles = "";
        String phoneNumberss = "";
        for(Map.Entry<String, Integer> personRole : this.roles.entrySet()){
            roles += "\n" + personRole.getKey();
        }
        for(String phone : phoneNumbers){
            if(phone == null){
                break;
            }else{
                phoneNumberss += "\n" + phone;

            }
        }
        return "Person " + "\n" +
                "name is " + name + "\n" +
                "surname is " + surname + "\n" +
                "email: " + email + "\n" +
                "role(s): " + roles + "\n" +
                "phone number(s): " + phoneNumberss + "\n\n";
    }

    public static void deletePerson(List<Person> personList, int index){
        personList.remove(index);
    }


}
