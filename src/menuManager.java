import java.util.InputMismatchException;
import java.util.Scanner;

public class menuManager {
    Scanner sc = new Scanner(System.in);
    InventoryManager manager = new InventoryManager();
    staffRequestManager requestManager = new staffRequestManager();
    UserManager manageUser = new UserManager();


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
                    menuManager managerMenu = new menuManager();

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
                        signupPageRunning = false;
                        System.exit(0);
                    }
                }
            }

        }
    }

    public void adminMenu(UserManager userManager, InventoryManager manageInventory) {
            int choice;
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
            System.out.println("[9]. View Request");
            System.out.println("[0]. EXIT");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    boolean ifValid = true;
                    while (ifValid) {
                        System.out.print("Enter Username: ");
                        String userName = sc.nextLine();

                        System.out.print("Enter password: ");
                        String userPassword = sc.nextLine();

                        System.out.print("Enter the role. ADMIN/STAFF: ");
                        String role = sc.nextLine();
                        userManager.addUserByAdmin(userName, userPassword, role);
                    }
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
                        System.exit(0);
                    }
                }
            }
        }



    public void staffMenu(InventoryManager inventoryManager, staffRequestManager staffRequestManager) {
        int staffChoice;
        System.out.println("\n=== STAFF MENU ===" +
                "\n[1]. View Items" + "\n" +
                "[2]. Edit items (to be approved by admin)");
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

                System.out.println("Enter Item name to edit");
                String itemName = sc.nextLine();

                System.out.println("Enter current price of the item");
                int currentPrice = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the new PRICE of the ITEM");
                int newPrice = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the reason of Change");
                String reason = sc.nextLine();

                Request request = new Request(itemName, currentPrice, newPrice, reason);
                staffRequestManager.submitRequest(request);
                System.out.println("Submitting request");
                for (int i = 0; i < 4; i++) {
                    try {
                        Thread.sleep(200); System.out.println(".");
                    } catch (InterruptedException e) {

                    }
                }


            }
        }


    }
}