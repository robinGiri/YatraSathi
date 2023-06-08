package model;

public class Admin {
    private int id;
    private String name;
    private String address;
    private String contact;
    private String username;
    private String password;

    public Admin(int id, String name, String address, String contact, String username, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.username = username;
        this.password = password;
    }

    public Admin(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
}
