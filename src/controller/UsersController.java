package controller;

import model.User;
import service.UserService;
import java.sql.Date;
import java.util.ArrayList;

public class UsersController {
    private UserService userServices = new UserService();

    // Create a new user
    public boolean createUser(String username, String email, String password, boolean isAdmin) {
        User user = new User(username, email, password,isAdmin);
        return userServices.createUser(user);
    }
    
    //Create a new user
     public boolean createUser(int userId, String userName, String email, String password,Date dateOfJoin, String address, String contact, String subscription, boolean isUser) {
        User user = new User(userName, email, password, dateOfJoin, address, contact, subscription, isUser);
        return userServices.createUser(user);
    }

    // Update an existing user
    public boolean updateUser(int userId, String userName, String email, String password,String address,
            String contact,
            String subscription,boolean isUser) {
            User user = new User(userId, userName, email, contact, address, contact, subscription, isUser);
        return userServices.updateUser(user);
    }

    // Delete a user
    public boolean deleteUser(int userId) {
        User user = new User();
        user.setUserId(userId);
        return userServices.deleteUser(user); 
    }

    // Show a list of users
    public ArrayList<User> showUserList() {
        ArrayList<User> users = userServices.listUsers();
        return users;  
    }
    public User getUserByID(int id){
        User user = userServices.selectUserID(id);
        return user;
    }

    public static void main(String[] args) {
        // Creating an instance of UsersController
        UsersController usersController = new UsersController();
        usersController.showUserList();
    }
}

   

