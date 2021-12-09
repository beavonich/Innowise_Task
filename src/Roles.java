import java.util.HashMap;
import java.util.Map;

public class Roles {
    private static Map<String, Integer> roles = new HashMap();

    {
        roles.put("USER", 1);
        roles.put("CUSTOMER", 1);
        roles.put("ADMIN", 2);
        roles.put("PROVIDER", 2);
        roles.put("SUPER_ADMIN", 3);
    }

    public static int getRoleValue(String role) {
        return roles.get(role);
    }
}
