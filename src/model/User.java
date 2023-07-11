package model;

import java.sql.Date;

public class User {
    private int userId;
    private String userName;
    private String email;
    private String password;
    private Date dateOfJoin;
    private String address;
    private String contact;
    private String img;
    private String subscription;
    private boolean isUser;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isIsUser() {
        return isUser;
    }

    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    public User() {
    }

    public User(int userId, String userName, String email, String password, Date dateOfJoin, String address,
            String contact, String subscription, boolean isUser) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.dateOfJoin = dateOfJoin;
        this.address = address;
        this.contact = contact;
        this.subscription = subscription;
        this.isUser = isUser;
    }

    public User(int userId, String userName, String email, String password, String address, String contact,
            String subscription, boolean isUser) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contact = contact;
        this.subscription = subscription;
        this.isUser = isUser;
    }

    public User(String userName, String email, String password, Date dateOfJoin, String address, String contact,
            String subscription, boolean isUser) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.dateOfJoin = dateOfJoin;
        this.address = address;
        this.contact = contact;
        this.subscription = subscription;
        this.isUser = isUser;
    }


    public User(String name, String email, String password, boolean isAdmin) {
        this.userName = name;
        this.email = email;
        this.password = password;
        this.isUser = isAdmin;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
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

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public boolean getisUser() {
        return isUser;
    }

    public void setisUser(boolean isUser) {
        this.isUser = isUser;
    }

    public boolean getdateOfJoin() {
        return isUser;
    }

    public void setdateOfJoin(boolean isUser) {
        this.isUser = isUser;
    }
}
