public class User {

    private String adminUserName;
    private String adminUserPassword;
    private String staffUserName;
    private String staffUserPassword ;
    private String role;

    User(String adminUserName, String adminUserPassword, String staffUserName, String staffUserPassword, String role) {
        this.adminUserName = adminUserName;
        this.adminUserPassword = adminUserPassword;
        this.staffUserName = staffUserName;
        this.staffUserPassword = staffUserPassword;
        this.role = role;
    }

    public String getAdminUserName() { return adminUserName; }
    public String getAdminUserPassword() { return adminUserPassword; }
    public String getStaffUserName() { return staffUserName; }
    public String getStaffUserPassword() { return staffUserPassword; }

    public void setAdminUserName(String adminUserName) { this.adminUserName = adminUserName; }
    public void setAdminUserPassword(String adminUserPassword) { this.adminUserPassword = adminUserPassword; }
    public void setStaffUserName(String staffUserName) { this.staffUserName = staffUserName; }
    public void setStaffUserPassword (String staffUserPassword) { this.staffUserPassword = staffUserPassword; }
}
