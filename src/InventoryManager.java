import java.util.HashMap;
import java.util.Scanner;
public class InventoryManager {
    private HashMap<Integer, Items> inventory = new HashMap<>();
    private Scanner sc = new Scanner(System.in);


    public void AddItems() {
        System.out.print("Enter the Item ID: ");
        int itemId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the item name ");
        String itemName = sc.nextLine();

        System.out.print("Enter Price: ");
        int itemPrice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Item Quantity");
        int itemQuantity = sc.nextInt();

        Items items = new Items(itemId, itemName, itemPrice, itemQuantity);
        inventory.put(items.getItemId(), items);
        System.out.println("Item added Successfully" + items);
    }

    public void DisplayItems() {
        for (Items items : inventory.values()) {
            System.out.println(items);
        }
    }

    public void RemoveItems(int id) {
        Items itemToDelete = inventory.remove(id);

        if (itemToDelete != null) {
            System.out.println("Item removed Successfully...");
        } else {
            System.out.println("Item removal failed....");
        }
    }

    public void SearchElementById(int id, String keyword) {
        // SEARCH BY ELEMENT ID
        Items items = inventory.get(id);
        if (id != items.getItemId()) {
            System.out.println("ID not found");
        } else {
            System.out.println("ID Found: " + items.getItemName());
        }
    }

    public void SearchElementByKeyword(String keyword) {
        boolean found = false;
        for (Items item : inventory.values()) {
            if (item.getItemName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("FOUND!" + item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("NOT FOUND! " + keyword);
        }
    }

}
