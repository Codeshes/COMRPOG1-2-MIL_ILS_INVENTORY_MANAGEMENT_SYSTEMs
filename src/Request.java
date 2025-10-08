public class Request {
    private String staffRequest;
    private int requestId;

    Request(String staffRequest, int requestId) {
        this.staffRequest = staffRequest;
        this.requestId = requestId;

    }

    public String getStaffRequest() { return staffRequest; }
    public int getRequestId() { return requestId; }
    public void setStaffRequest(String staffRequest) { this.staffRequest = staffRequest; }
    public void setRequestId(String requestId ) { this.requestId = requestId; }

    @Override
    public String toString() {
        return "Request ID: " + requestId;
    }

}
