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
    public boolean updateUser(int userId, String userName,String email, String password, String address, String contact,
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
            System.out.println(user.getUserName());
        }
    }


    public static void main(String[] args) {
        // Creating an instance of UsersController
        UsersController usersController = new UsersController();

//        // Creating and inserting a new user
//        boolean createUserStatus = usersController.createUser("robin", "robin@example.com", "passwood@123");
//        System.out.println("Create User Status: " + createUserStatus);

        // Updating an existing user
//        boolean updateUserStatus = usersController.updateUser(0, "John", "john@example.com", "newpassword", "456 Elm St", "1234567890", 1, 2, true);
//        System.out.println("Update User Status: " + updateUserStatus);

//        // Deleting a user
//        boolean deleteUserStatus = usersController.deleteUser(0);
//        System.out.println("Delete User Status: " + deleteUserStatus);

//        // Showing a list of users
        System.out.println("User List:");
        usersController.showUserList();
    }
}

   

