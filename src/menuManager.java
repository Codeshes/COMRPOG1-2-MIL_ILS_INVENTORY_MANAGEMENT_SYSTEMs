import java.util.InputMismatchException;
import java.util.Scanner;

public class menuManager {
    Scanner sc = new Scanner(System.in);
    static InventoryManager manager = new InventoryManager();
    static staffRequestManager requestManager = new staffRequestManager();
    static UserManager manageUser = new UserManager();
    // Will fix the bug on Accepting request
    // Will fix the return on the staff menu on case 2

    boolean signupPageRunning = true;

    public void menuStart() {
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

                    if (role.equals("admin")) {
                        adminMenu(manageUser, manager);
                    } else if (role.equals("staff")) {
                        staffMenu(manager, requestManager);
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
                        Thread.currentThread().interrupt();
                        signupPageRunning = false;
                        System.exit(0);
                    }
                }
            }

        }
    }

    /*====================================================================================*/

    boolean isAdminMenuRunning = true;
    public void adminMenu(UserManager userManager, InventoryManager manageInventory) {
        int choice;
        while (isAdminMenuRunning) {
            System.out.println("""
        ==================== ADMIN MENU ====================
        [1]  Add Users
        [2]  Display Users
        [3]  Remove Users
        -----------------------------------------------------
                 Manage Inventory Section
        -----------------------------------------------------
        [4]  View All Items
        [5]  Add Item
        [6]  Remove Item
        [7]  Search Item by ID
        [8]  Search Item by Keyword
        -----------------------------------------------------
        [9]  View Staff Requests
        [10] Logout
        [0]  Exit
        =====================================================
        """);
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Username: ");
                    String userName = sc.nextLine().trim();

                    System.out.print("Enter password: ");
                    String userPassword = sc.nextLine().trim();

                    System.out.print("Enter the role. ADMIN/STAFF: ");
                    String role = sc.nextLine().trim();
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
                case 9 -> {
                    requestManager.viewRequest();
                    Admin admin = new Admin();
                    requestManager.processRequest(admin);

                    System.out.println("Returning to ADMIN MENU");
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(700);
                            System.out.println(".");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            //Diko alam kung ano ilalagay ko dito
                        }
                    }

                }
                case 0 -> {
                    try {
                        System.out.print("Exiting Program");
                        for (int i = 0; i < 4; i++) {
                            Thread.sleep(250);
                            System.out.print(". ");
                        }
                        isAdminMenuRunning = false;
                        System.exit(0);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.exit(0);
                        isAdminMenuRunning = false;
                    }
                }
                case 10 -> {
                    userManager.logOutMethod();
                }
            }
        }

    }

    /*====================================================================================*/
    public void staffMenu(InventoryManager inventoryManager, staffRequestManager staffRequestManager) {
        int staffChoice;
        System.out.println("""
                
                === STAFF MENU ===\
                
                [1]. View Items
                [2]. Edit items (to be approved by admin)
                [3]. LOGOUT""");
        staffChoice = sc.nextInt();
        sc.nextLine();

        switch (staffChoice) {
            case 1 -> {
                System.out.println("============= INVENTORY ITEM LIST'S =============");
                inventoryManager.DisplayItems();
            }
            case 2 -> {
                System.out.println("============= INVENTORY ITEM LIST'S =============");
                inventoryManager.DisplayItems();

                if (inventoryManager.isEmpty()) {
                    System.out.println("Inventory is EMPTY no ITEM to EDIT");
                    break;
                }

                System.out.println("Enter Item name to edit");
                String itemName = sc.nextLine();

                System.out.println("Enter current price of the item");
                double currentPrice = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the new PRICE of the ITEM");
                double newPrice = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the reason of Change");
                String reason = sc.nextLine();

                Request request = new Request(itemName, currentPrice, newPrice, reason);
                staffRequestManager.submitRequest(request);
                System.out.println("Submitting request");
                for (int i = 0; i < 4; i++) {
                    try {
                        Thread.sleep(200);
                        System.out.println(".");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }


            }
            case 3 -> {
                manageUser.logOutMethod();
            }
        }


    }
}