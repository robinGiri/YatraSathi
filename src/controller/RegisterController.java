package controller;

import model.User;
import service.UserService;

public class RegisterController {
    UserService UserService = new UserService();

    public Boolean register( String username, String email, String password) {
        User User = new User(username, password, email,true);
        return UserService.createUser(User);
    }

}
