import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();
        staffRequestManager requestManager = new staffRequestManager();
        UserManager manageUser = new UserManager();


        boolean signupPageRunning = true;

        while (signupPageRunning) {
            int choice = 0;
            System.out.println("\n=== SIGN UP PAGE ===\n" +
                    "    [1]. Login\n" +
                    "    [0]. EXIT   ");
            boolean isValid = false;
            while (!isValid) {
                try {
                    System.out.print("Enter your choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    isValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("The choice must be a NUMBER");
                    System.out.println("---------------------------");
                    sc.nextLine();
                }
            }
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter your username: ");
                    String userName = sc.nextLine();

                    System.out.print("Enter your password: ");
                    String userPassword = sc.nextLine();
                    String role = manageUser.loginMethod(userName, userPassword);
                    Main mainMethod = new Main();
                    User users = new User(userName, userPassword, role);

                    if (role.equals("admin")) {
                        mainMethod.adminMenu(manageUser, manager);
                    } else if (role.equals(users.getRole())){
                        mainMethod.staffMenu(manager, requestManager);
                    } else {
                        System.out.println("Credentials not matched");
                    }


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

    public void adminMenu(UserManager userManager, InventoryManager manageInventory) {
        boolean choiceRunning = true;
        while (choiceRunning) {
            System.out.println("=== ADMIN MENU ===");
            System.out.println("[1]. Add Users");
            System.out.println("[2]. Display Users");
            System.out.println("[3]. Remove Users");
            System.out.println("=== Manage Inventory Section ===");
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

                }
                case 2 -> {
                    System.out.println("============= USER'S LIST =============");
                    userManager.displayUser();
                }
                case 3 -> {
                    System.out.println("Enter a username to remove in the user's List");
                    String user = sc.nextLine();
                    userManager.removeUser(user);
                }
                case 4 -> {
                    System.out.println("============= INVENTORY ITEM LIST'S =============");
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
                case 0 -> {
                    try {
                        System.out.print("Exiting Program");
                        for (int i = 0; i < 4; i++) {
                            Thread.sleep(250);
                            System.out.print(". ");
                        }
                        System.exit(0);
                    } catch (InterruptedException e) {
                        choiceRunning = false;
                        System.exit(0);
                    }
                }
            }

        }
    }

    public void staffMenu(InventoryManager inventoryManager, staffRequestManager staffRequestManager) {
        int staffChoice;
        // Will do 9pm tonight
    }


}