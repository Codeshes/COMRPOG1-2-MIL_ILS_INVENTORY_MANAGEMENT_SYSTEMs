import java.util.HashMap;

public class InventoryManager {
    private HashMap<Integer, Items> inventory = new HashMap<>();


    public void AddItems(Items item) {
        inventory.put(item.getItemId(), item);
        System.out.println("Item added Successfully" + item);
    }

    public void DisplayItems() {
        for (Items items : inventory.values()) {
            System.out.println(items);
        }
    }

    public void RemoveItems(int id) {
        inventory.remove(id);
        System.out.println("Item removed.");
    }

    public void SearchElementByIdAndKeyWord(int id, String keyword) {
        // SEARCH BY ELEMENT ID
        Items items = inventory.get(id);
        if (id != items.getItemId()) {
            System.out.println("ID not found");
        } else {
            System.out.println("ID Found: " + items.getItemName());
        }

        // SEARCH ELEMENT BY KEYWORD
        boolean found = false;
        for (Items item : inventory.values()) {
            if (item.getItemName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + item.getItemName() + " | ITEM ID: " + item.getItemId());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Item not found check your keyword or the Item does not exist");
        }

    }



}
