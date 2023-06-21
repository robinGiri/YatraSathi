package service;
import java.util.ArrayList;
import model.Driver;

public interface IDriverService {
    public boolean createDriver(Driver driver);
    public boolean updateDriver(Driver driver);
    public boolean deleteDriver(Driver driver);
    public ArrayList<Driver> listDrivers();
    
}
