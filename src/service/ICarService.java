package service;
import java.util.ArrayList;
import model.Car;

public interface ICarService {
    public boolean createCar(Car car);
    public boolean updateCar(Car car);
    public boolean deleteCar(int carId);
    public ArrayList<Car> listCars();
}
