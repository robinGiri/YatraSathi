package controller;

import model.Car;
import service.CarService;
import java.sql.Date;
import java.util.ArrayList;

public class CarController {
    private CarService carService;

    public CarController() {
        this.carService = new CarService();
    }

    public void createCar(int carId, String carName, String carBrand, Date carModelYear, String carColor,
            String plateNumber, String carStatus, String carImage, int rate, int ownerId) {
        Car car = new Car(carId, carName, carBrand, carModelYear, carColor, plateNumber, carStatus,
                carImage, rate, ownerId);
        boolean success = carService.createCar(car);
        if (success) {
            System.out.println("Car created successfully.");
        } else {
            System.out.println("Failed to create car.");
        }
    }

    public void updateCar(int carId, String carName, String carBrand, Date carModelYear, String carColor,
            String plateNumber, String carStatus, String carImage, int rate, int ownerId) {
        Car car = new Car(carId, carName, carBrand, carModelYear, carColor, plateNumber, carStatus,
                carImage, rate, ownerId);
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

    public void listCars() {
        ArrayList<Car> carsList = carService.listCars();
        if (carsList.isEmpty()) {
            System.out.println("No cars found.");
        } else {
            System.out.println("List of cars:");
            for (Car car : carsList) {
                System.out.println(car.getCar_id() + " - " + car.getCar_name());
            }
        }
    }
}
