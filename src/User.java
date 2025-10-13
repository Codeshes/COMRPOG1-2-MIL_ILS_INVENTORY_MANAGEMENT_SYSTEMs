public class User {
    private static int counterUserId = 200;
    private final int userId;
    private String userName;
    private String userPassword;
    private String role;

    User(String userName, String userPassword, String role) {
        this.userId = counterUserId++;
        this.userName = userName;
        this.userPassword = userPassword;
        this.role = role;
    }

    public int getID() { return userId; }
    public String getUserName() { return userName; }
    public String getUserPassword() { return userPassword; }
    public String getRole() { return  role; }

    public void setUserName(String userName) { this.userName = userName; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "ID: " + getID() + " | Username: " + userName + " | Role: " + role ;
    }
}
