import java.util.InputMismatchException;
import java.util.Scanner;

public class menuManager {
    Scanner sc = new Scanner(System.in);
    InventoryManager manager = new InventoryManager();
    staffRequestManager requestManager = new staffRequestManager();
    UserManager manageUser = new UserManager();
    int choice;
    // Will fix the bug on Accepting request
    // Still not done
    //SOUT ai wruv wryu
    //Hello gello
    // hello hello

    boolean signupPageRunning = true;

    public void menuStart() {

        while (signupPageRunning) {
            System.out.println("""
                    
                    === SIGN UP PAGE ===
                        [1]. Login
                        [0]. EXIT  \s""");
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
                    // ask for username
                    System.out.print("Enter your username: ");
                    String userName = sc.nextLine();
                    // ask for userPassword
                    System.out.print("Enter your password: ");
                    String userPassword = sc.nextLine();
                    String role = manageUser.loginMethod(userName, userPassword);

                    /* if role equals to admin it redirect into adminMenu() and isAdminMenuRunning redirect it
                    * again when logging in again after log out.
                    *
                    * Same as Staff
                    * */
                    if (role.equals("admin")) {
                        adminMenu(manageUser, manager);
                        isAdminMenuRunning = true;
                    } else if (role.equals("staff")) {
                        staffMenu(manager, requestManager);
                        isStaffMenuRunning = true;
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
    // Used in loop
    boolean isAdminMenuRunning = true;

    public void adminMenu(UserManager userManager, InventoryManager manageInventory) {
        int choice = 0;
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
            try {
                System.out.print("\nEnter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                Thread.currentThread().interrupt();
                System.out.println("Choice must be a Number");
                return;
            }

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
                case 2 -> { // display the user list
                    System.out.println("============= USER'S LIST =============");
                    userManager.displayUser();
                }
                case 3 -> {
                    // String remove method
                    System.out.println("Enter a username to remove in the user's List");
                    String user = sc.nextLine();
                    userManager.removeUser(user);
                }
                case 4 -> { // Display all the items
                    System.out.println("============= INVENTORY ITEM LIST'S =============");
                    manageInventory.DisplayItems();
                }
                case 5 -> manageInventory.AddItems();
                case 6 -> {
                    // delete item via ID
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
                    // search via keyword
                    System.out.println("Enter an KEYWORD to search for an ITEM");
                    String keyword = sc.nextLine();
                    manageInventory.SearchElementByKeyword(keyword);
                }
                case 9 -> {
                    // view request
                    requestManager.viewRequest();
                    // object declaration of admin for the decision of an admin into a one request.
                    Admin admin = new Admin();

                    // process method for the admin.
                    requestManager.processRequest(admin);


                    System.out.println("Returning to ADMIN MENU");
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(700);
                            System.out.println(".");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                }

                case 10 -> {
                    System.out.println("Logging out");
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(200);
                            System.out.println(".");
                            isAdminMenuRunning = false;
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("Interrupted");
                            isAdminMenuRunning = false;
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


            }
        }

    }

    /*====================================================================================*/
    boolean isStaffMenuRunning = true;

    public void staffMenu(InventoryManager inventoryManager, staffRequestManager staffRequestManager) {
        int staffChoice;

        while (isStaffMenuRunning) {
            System.out.println("""
                    
                    === STAFF MENU ===\
                    
                    [1]. View Items
                    [2]. Edit items (to be approved by admin)
                    [3]. LOGOUT
                    [0]. EXIT""");
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
                        // return if the inventory are empty
                        return;
                    }
                        // if not it bypasses the if statement and go direct into the userInput
                    System.out.println("Enter Item name to edit");
                    String itemName = sc.nextLine();

                    System.out.println("Enter current price of the item");
                    double currentPrice = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the new PRICE of the ITEM");
                    double proposedPrice = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the reason of Change");
                    String reason = sc.nextLine();

                    Request request = new Request(itemName, currentPrice, proposedPrice, reason);
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
                    System.out.println("Logging out");
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(200);
                            System.out.println(".");
                            isStaffMenuRunning = false;
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("Interrupted");
                            isStaffMenuRunning = false;
                        }
                    }
                }
                case 0 -> {
                    System.out.println("Exiting");
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(200); System.out.println(".");
                            isStaffMenuRunning = false;
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            isAdminMenuRunning = false;
                        }
                    }
                }

            }
        }
    }
}