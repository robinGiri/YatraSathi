package controller;

import model.Car;
import service.CarService;
import java.util.ArrayList;

public class CarController {
    private CarService carService = new CarService();

    public void createCar(Car car) {
        carService.createCar(car);
    }

    public void updateCar(Car car) {
       carService.updateCar(car);
    }

    public void deleteCar(int carId) {
       carService.deleteCar(carId);
    }

    public Car searchCar(int carId) {
        Car DetailCar = carService.getCarById(carId);
        return DetailCar;
    }

    public ArrayList<Car> listCars() {
        ArrayList<Car> carsList = carService.listCars();
        return carsList;
    }

    public ArrayList<Car> showAvailableCar() {
        ArrayList<Car> carsList = carService.showAvailableCars();
        return carsList;
    }
}
