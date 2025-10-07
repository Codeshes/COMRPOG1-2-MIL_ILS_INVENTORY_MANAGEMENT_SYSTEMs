import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Items> inventoryItems = new ArrayList<>();


    public void AddItems(Items item) {
        inventoryItems.add(item);
        System.out.println("Item added Successfully" + item);
    }

    public void DisplayItems() {
        inventoryItems.size();
    }

    public void RemoveItems(int id) {
        for (Items items : inventoryItems) {
            if (items.getItemId() == id) {
                inventoryItems.remove(items);
            }
        }
    }

    public void SearchById(int id) {
        for (Items items : inventoryItems) {
            if (items.getItemId() == id) {
                System.out.println("Item Found!" + inventoryItems);
            }
        }
    }

    public void SearchByText(String keyword) {
        for (Items items : inventoryItems) {
            if (items.getItemName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("ITEM FOUND! \n" + items);
            }
        }
    }

}
