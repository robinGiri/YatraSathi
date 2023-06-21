package model;

public class Owner {
    private int ownerId;
    private String ownerName;
    private String address;
    private String contact;
    private String username;
    private String password;
    private int adminId;
    private String accountStatus;

    public Owner(int ownerId, String ownerName, String address, String contact, String username, String password, int adminId, String accountStatus) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.address = address;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.adminId = adminId;
        this.accountStatus = accountStatus;
    }

    public Owner() {
        
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}

