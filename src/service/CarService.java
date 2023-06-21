package service;

import java.sql.*;
import database.DbConnection;
import model.Car;
import java.util.ArrayList;

public class CarService implements ICarService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    // Check if the car table exists, create it if not
    private boolean checkTableCar() {
        connection = dbConnection.connection;
        String query = "CREATE TABLE IF NOT EXISTS car (" +
                "carId INT PRIMARY KEY, " +
                "carName VARCHAR(50), " +
                "carBrand VARCHAR(50), " +
                "carModelYear DATE, " +
                "carColor VARCHAR(50), " +
                "plateNumber VARCHAR(50), " +
                "carStatus VARCHAR(50), " +
                "carImage VARCHAR(100), " +
                "rate INT, " +
                "ownerId INT)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Create a car
    public boolean createCar(Car car) {
        checkTableCar();
        connection = dbConnection.connection;
        String query = "INSERT INTO car(carId, carName, carBrand, carModelYear, carColor, plateNumber, " +
                "carStatus, carImage, rate, ownerId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, car.getCar_id());
            preparedStatement.setString(2, car.getCar_name());
            preparedStatement.setString(3, car.getCar_brand());
            preparedStatement.setDate(4, car.getCar_model_year());
            preparedStatement.setString(5, car.getCar_color());
            preparedStatement.setString(6, car.getPlate_number());
            preparedStatement.setString(7, car.getCar_status());
            preparedStatement.setString(8, car.getCar_image());
            preparedStatement.setInt(9, car.getRate());
            preparedStatement.setInt(10, car.getOwner_id());

            int status = preparedStatement.executeUpdate();
            return (status > 0);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateCar(Car car) {
        connection = dbConnection.connection;
        String query = "UPDATE car SET carName = ?, carBrand = ?, carModelYear = ?, carColor = ?, " +
                "plateNumber = ?, carStatus = ?, carImage = ?, rate = ?, ownerId = ? WHERE carId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getCar_name());
            preparedStatement.setString(2, car.getCar_brand());
            preparedStatement.setDate(3, car.getCar_model_year());
            preparedStatement.setString(4, car.getCar_color());
            preparedStatement.setString(5, car.getPlate_number());
            preparedStatement.setString(6, car.getCar_status());
            preparedStatement.setString(7, car.getCar_image());
            preparedStatement.setInt(8, car.getRate());
            preparedStatement.setInt(9, car.getOwner_id());
            preparedStatement.setInt(10, car.getCar_id());

            int status = preparedStatement.executeUpdate();
            return (status > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteCar(int carId) {
        connection = dbConnection.connection;
        String query = "DELETE FROM car WHERE carId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, carId);

            int status = preparedStatement.executeUpdate();
            return (status > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<Car> listCars() {
        ArrayList<Car> carsList = new ArrayList<Car>();
        connection = dbConnection.connection;
        String query = "SELECT * FROM car";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int carId = resultSet.getInt("carId");
                String carName = resultSet.getString("carName");
                String carBrand = resultSet.getString("carBrand");
                Date carModelYear = resultSet.getDate("carModelYear");
                String carColor = resultSet.getString("carColor");
                String plateNumber = resultSet.getString("plateNumber");
                String carStatus = resultSet.getString("carStatus");
                String carImage = resultSet.getString("carImage");
                int rate = resultSet.getInt("rate");
                int ownerId = resultSet.getInt("ownerId");

                Car car = new Car(carId, carName, carBrand, carModelYear, carColor, plateNumber,
                        carStatus, carImage, rate, ownerId);
                carsList.add(car);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return carsList;
    }
    public static void main(String[] args) {
    CarService carService = new CarService();

    
    Car car1 = new Car(1, "Toyota Camry", "Toyota", new java.sql.Date(System.currentTimeMillis()),
            "Silver", "ABC123", "Available", "car1.jpg", 50, 1);
    Car car2 = new Car(2, "Honda Civic", "Honda", new java.sql.Date(System.currentTimeMillis()),
            "Red", "XYZ789", "Not Available", "car2.jpg", 60, 2);

    carService.createCar(car1);
    carService.createCar(car2);
}
    
}
