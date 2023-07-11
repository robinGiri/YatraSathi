package controller;

import model.User;
import service.UserService;

public class RegisterController {
    UserService userService = new UserService();

    public Boolean register(String username, String email, String password) {
        User User = new User(username, password, email, true);
        return userService.createUser(User);
    }

}
