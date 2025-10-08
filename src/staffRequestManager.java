import java.util.ArrayList;
import java.util.Scanner;
public class staffRequestManager {

    private ArrayList<Request> requests;

    public staffRequestManager() {
        requests = new ArrayList<>();
    }
    public void submitRequest(Request request) {
        requests.add(request);
        System.out.println("Request sent!");
    }

    public void processRequest(Admin admin){
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

    public void updatedItemPrice(Request priceChange) {
        System.out.println("Price for: " + priceChange.getItemName() +
                " Updated from" + priceChange.getCurrentPrice() +
                " to " + priceChange.getProposedPrice());
    }
}
