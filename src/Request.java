public class Request {
    private static int counter = 100;
    private final int id;
    private final String itemName;
    private final double currentPrice;
    private double proposedPrice;
    private final String reason;


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

    public void setProposedPrice(double proposedPrice) { this.proposedPrice = proposedPrice; }

    @Override
    public String toString() {
        return "Price Change Request:" +
                "ID = " + id +
                ", Item name: " + itemName + '\'' +
                ", Current Price: " + currentPrice +
                ", REASON: " + reason + '\'';
    }

}
