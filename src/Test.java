import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        try {
            Action.action(personList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}