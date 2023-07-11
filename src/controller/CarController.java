package controller;

import model.Car;
import service.CarService;
import java.sql.Date;
import java.util.ArrayList;

public class CarController {
    private CarService carService = new CarService();

    public void createCar(int carId, String carName, String carBrand, Date carModelYear, String carColor,
            String plateNumber, String carStatus, String rate, int ownerId) {
        Car car;
        car = new Car(carId, carName, carBrand, carModelYear, carColor, plateNumber, carStatus, rate, ownerId);
        boolean success = carService.createCar(car);
        if (success) {
            System.out.println("Car created successfully.");
        } else {
            System.out.println("Failed to create car.");
        }
    }

    public void updateCar(int carId, String carName, String carBrand, Date carModelYear, String carColor,
            String plateNumber, String carStatus, String rate, int ownerId) {
        Car car = new Car(carId, carName, carBrand, carModelYear, carColor, plateNumber, carStatus, rate, ownerId);
        boolean success = carService.updateCar(car);
        if (success) {
            System.out.println("Car updated successfully.");
        } else {
            System.out.println("Failed to update car.");
        }
    }

    public void deleteCar(int carId) {
        boolean success = carService.deleteCar(carId);
        if (success) {
            System.out.println("Car deleted successfully.");
        } else {
            System.out.println("Failed to delete car.");
        }
    }

    public Car searchCar(int carId) {
        Car DetailCar = carService.getCarById(carId);
        return DetailCar;
    }

    public ArrayList<Car> listCars() {
        ArrayList<Car> carsList = carService.listCars();
        if (carsList.isEmpty()) {
            return null;
        } else {
            return carsList;
        }
    }

    public ArrayList<Car> showAvailableCar() {
        ArrayList<Car> carsList = carService.showAvailableCars();
        return carsList;
    }
}
