public class Request {
    private static int counter = 100;  // Static counter to generate unique IDs
    private int id;
    private String itemName;
    private double currentPrice;
    private double proposedPrice;
    private String reason;


    Request(String itemName, double currentPrice, double proposedPrice, String reason) {
        this.id = counter++;
        this.itemName = itemName;
        this.currentPrice = currentPrice;
        this.proposedPrice = proposedPrice;
        this.reason = reason;


    }

    public int getId() { return  id; }
    public String getItemName() { return itemName; }
    public double getCurrentPrice() { return currentPrice; }
    public double getProposedPrice() { return proposedPrice; }
    public String getReason() { return reason;}

    @Override
    public String toString() {
        return "Price Change Request:" +
                "ID = " + id +
                ", Item name: " + itemName + '\'' +
                ", Current Price: " + currentPrice +
                ", REASON: " + reason + '\'';
    }

}
