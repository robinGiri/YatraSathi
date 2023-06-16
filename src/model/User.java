package model;

public class User {
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String address;
    private String contact;
    private int subscriptionId;
    private int rentalId;
    private boolean isUser;

    public User(int userId, String userName, String email, String password, String address1, String contact1, int subscriptionId, int rentalId, boolean isUser) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contact = contact;
        this.subscriptionId = subscriptionId;
        this.rentalId = rentalId;
        this.isUser = isUser;
    }
    public User(String name, String email, String password) {
        this.userName = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean isUser) {
        this.isUser = isUser;
    }
}
