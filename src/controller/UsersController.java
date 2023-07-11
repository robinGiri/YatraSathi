package controller;

import model.User;
import service.UserService;
import java.sql.Date;
import java.util.ArrayList;

public class UsersController {
    private UserService userServices = new UserService();

    // Create a new user
    public boolean createUser(User user) {
        return userServices.createUser(user);
    }
    
    // Update an existing user
    public boolean updateUser(User user) {
        return userServices.updateUser(user);
    }

    // Delete a user
    public boolean deleteUser(int userId) {
        return userServices.deleteUser(userId); 
    }

    // Show a list of users
    public ArrayList<User> showUserList() {
        ArrayList<User> users = userServices.listUsers();
        return users;  
    }
    public User getUserByID(int id){
        return userServices.selectUserID(id);
    }
}

   

