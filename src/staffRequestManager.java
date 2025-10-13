import java.util.LinkedList;
import java.util.Scanner;

public class staffRequestManager {

    private LinkedList<Request> requests = new LinkedList<>();

    public void submitRequest(Request request) {
        // Price change
        requests.add(request);
        System.out.println("Request sent!");
    }

    public void viewRequest() {

        if (requests.isEmpty()) {
            System.out.println("There are no request today");
        }
        System.out.println("========================================");
        System.out.printf("%-5s %-15s %-15s %-15s %-20s%n",
                "ID", "Item", "Current Price", "Proposed", "Reason");
        System.out.println("========================================");

        for (Request request : requests) {
            System.out.printf("%-5d %-15s %-15.2f %-15.2f %-20s%n",
                    request.getId(),
                    request.getItemName(),
                    request.getCurrentPrice(),
                    request.getProposedPrice(),
                    request.getReason());
        }

    }

    public void processRequest(Admin admin) {
        Scanner sc = new Scanner(System.in);
        for (Request priceChange : requests) {
            System.out.println("Processing request ID" + priceChange.getId());
            System.out.println(priceChange);


            //For admin
            System.out.println("Approve or decline this request? (Accepted or Rejected)");
            String decision = sc.nextLine().trim();

            boolean ifApproved = admin.reviewRequest(decision);
            if (ifApproved) {
                System.out.println("Ticket Approved! " + priceChange.getId() + decision);
            } else {
                System.out.println("Ticket not Approved! " + priceChange.getId() + decision);
            }
        }
    }

    public void updatedItemPrice(Request priceChange1) {
        System.out.println("Price for: " + priceChange1.getItemName() +
                " Updated from" + priceChange1.getCurrentPrice() +
                " to " + priceChange1.getProposedPrice());
    }
}
