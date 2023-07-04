/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.User;

/**
 *
 * @author ksand
 */
public interface IUserService {
    public boolean createUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
    public ArrayList<User> listUsers();
    public User selectUserID(int id);
    
}
