package controller;

import model.User;
import service.UserService;

public class UsersController {
    private UserService userServices = new UserService();

    // Create a new user

    public boolean createUser(String username, String email, String password) {
        User user = new User(username, email, password);
        return userServices.createUser(user);
    }

    // Update an existing user
    public boolean updateUser(int userId, String userName, String email, String password, String address,
            String contact,
            int subscriptionId, int rentalId, boolean isUser) {
        User user = new User(userId, userName, address, contact, address, contact, subscriptionId, rentalId, isUser);
        return userServices.updateUser(user);
    }

    // Delete a user
    public boolean deleteUser(int userId) {
        User user = new User();
        user.setUserId(userId);
        return userServices.deleteUser(user);
    }

    // Show a list of users
    public void showUserList() {
        for (User user : userServices.listUsers()) {
        }
    }

    public static void main(String[] args) {
        // Creating an instance of UsersController
        UsersController usersController = new UsersController();

        usersController.showUserList();
    }
}

   

