package controller;

import model.User;
import service.UserService;

public class RegisterController {
    UserService userService = new UserService();
    
    public Boolean register(User user) {
        return userService.createUser(user);
    }

}
