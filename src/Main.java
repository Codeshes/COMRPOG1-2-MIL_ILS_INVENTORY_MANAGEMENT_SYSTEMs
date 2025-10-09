import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        staffRequestManager requestManager = new staffRequestManager();
        UserManager manageUser = new UserManager();

        boolean signupPageRunning = true;

        while (signupPageRunning) {
            System.out.println("\n=== SIGN UP PAGE ===\n" +
                    "    [1]. Login\n" +
                    "    [0]. EXIT   ");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter your username");
                    String userName = sc.nextLine();

                    System.out.println("Enter your password");
                    String userPassword = sc.nextLine();

                    manageUser.loginMethod(userName, userPassword);

                }
                case 0 -> {
                    try {
                        System.out.print("Exiting Program");
                        for (int i = 0; i < 4; i++) {
                            Thread.sleep(250);
                            System.out.print(". ");
                        }
                        System.exit(0);
                    } catch (InterruptedException e) {
                        signupPageRunning = false;
                        System.exit(0);
                    }
                }
            }

        }


    }

    public void adminMenu(UserManager userManager, InventoryManager manageInventory, Scanner sc) {
        System.out.println("=== ADMIN MENU");
        System.out.println("[1]. Add Users");
        System.out.println("[2]. Display Users");
        System.out.println("[3]. Remove Users");
        System.out.println("\n=== Manage Inventory Section ===");
        System.out.println("[4]. View all items");
        System.out.println("[5]. Add Item");
        System.out.println("[6]. Remove Items");
        System.out.println("[7]. Search ITEMS By ID");
        System.out.println("[8]. Search ITEMS by KEYWORD");
        System.out.println("[0]. EXIT");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Username: ");
                String userName = sc.nextLine();

                System.out.print("Enter password");
                String userPassword = sc.nextLine();

                System.out.print("Enter the role. ADMIN/STAFF");
                String role = sc.nextLine();
                userManager.addUserByAdmin(userName, userPassword, role);
                break;
            }
            case 2 -> userManager.displayUser();
            case 3 -> {
                System.out.println("Enter a username to remove in the user's List");
                String user = sc.nextLine();
                userManager.removeUser(user);
            }
            case 4 -> {
                manageInventory.DisplayItems();
            }
            case 5 -> {
                manageInventory.AddItems();
            }
            case 6 -> {
                System.out.println("Enter an item ID to be DELETED");
                int id = sc.nextInt();
                manageInventory.RemoveItems(id);
            }
            case 7 -> {
                System.out.println("Enter an ID to search for an ITEM");
                int id = sc.nextInt();
                manageInventory.SearchElementById(id);
            }
            case 8 -> {
                System.out.println("Enter an KEYWORD to search for an ITEM");
                String keyword = sc.nextLine();
                manageInventory.SearchElementByKeyword(keyword);
            }
        }


    }
}