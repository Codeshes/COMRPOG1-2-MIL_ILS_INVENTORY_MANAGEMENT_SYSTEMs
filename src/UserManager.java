import java.util.HashMap;


public class UserManager {
    private HashMap<String, User> users = new HashMap<>();

    //Add User
    public void addUser(String userName, String userPassword, String role) {
        User user = new User(userName, userPassword, role);
        users.put(userName, user);
        System.out.println("User added Successfully");
        System.out.println("User added: " + userName + " (" + role + ")");
    }

    public void displayUser() {
        for (User users : users.values()) {
            System.out.println(users);
        }
    }

    public void removeUser() {

    }

}
