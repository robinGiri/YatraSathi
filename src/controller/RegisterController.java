package controller;

import model.Admin;
import service.AdminService;

public class RegisterController {
    AdminService AdminService = new AdminService();

    public Boolean register(String username, String password, String email) {
        Admin admin = new Admin(username, password, email);
        return AdminService.register(admin);
    }

}
