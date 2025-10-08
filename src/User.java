import java.util.Scanner;

public class User {
    private Scanner sc = new Scanner(System.in);
    private final String adminUserName = "ADMIN2025";
    private final String adminUserPassword = "HAPPYNEWYEAR";
    private final String staffUserName = "STAFF2025";
    private final String staffUserPassword = "STAFFPASS";

    public String LoginMethod() {
        System.out.print("Enter your designated Username: ");
        String userName = sc.nextLine().trim();

        System.out.println("Enter your designated Password");
        String userPassword = sc.nextLine().trim();

        if (userName.equals(adminUserName)) {
            if (userPassword.equals(adminUserPassword)) {
                System.out.println("Login Success!");
                System.out.println("==============");
                return "admin";
            } else {
                System.out.println("Oh no, somethings not right.....");
                return "none";
            }
        } else if (userName.equals(staffUserName)) {
            if (userPassword.equals(staffUserPassword)) {
                System.out.println("Login Success!");
                return "staff";
            } else {
                System.out.println("Oh no, somethings not right.....");
                return "none;";
            }
        } else {
            System.out.println("Username not found! ");
            return "none";
        }
    }
}
