package service;

import java.util.ArrayList;
import model.User;

public interface IUserService {
    public boolean createUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(User user);

    public ArrayList<User> listUsers();

    public User selectUserID(int id);

}
