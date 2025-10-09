import java.util.HashMap;
import java.util.Scanner;

public class UserManager {
    private HashMap<String, User> users;
    private Scanner sc = new Scanner(System.in);

    UserManager() {
        users = new HashMap<>();
        addUserByAdmin("HeadAdmin2025", "HeadAdminPass2026", "HeadAdmin");
    }

    //Add User
    public void addUserByAdmin(String userName, String userPassword, String role) {
        User user = new User(userName, userPassword, role);
        users.put(userName, user);
        System.out.println("User added Successfully");
        System.out.println("USER ID: " + user.getID() + "User added: " + userName + " (" + role + ")");
    }

    public void displayUser() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
    public void removeUser(String user) {
        displayUser();
        if (users.containsKey(user)) {
            users.remove(user);
            System.out.println("Removed Successfully!");
        } else {
            System.out.println("User not found.");
        }
    }

    public String loginMethod(String userName, String passWord) {
        User user = users.get(userName);

        if (user != null && user.getUserPassword().equals(passWord)) {
            System.out.println("Login Successfully. Welcome");
            return user.getRole();
        } else {
            System.out.println("Login failed.");
            return "none";
        }
    }

}
