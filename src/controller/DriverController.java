package controller;

import model.Driver;
import service.DriverService;

public class DriverController {
    private DriverService driverService = new DriverService();

    // Create a new driver
    public boolean createDriver(String driverName, java.sql.Date joinedDate, String driverCommision, String driverContact) {
        Driver driver = new Driver(0,driverName, joinedDate, driverCommision, driverContact);
        return driverService.createDriver(driver);
    }

    // Update an existing driver
    public boolean updateDriver(int driverId, String driverName, java.sql.Date joinedDate, String driverCommision, String driverContact) {
        Driver driver = new Driver(driverId, driverName, joinedDate, driverCommision, driverContact);
        return driverService.updateDriver(driver);
    }

    // Delete a driver
    public boolean deleteDriver(int driverId) {
        Driver driver = new Driver();
        driver.setDriver_id(driverId);
        return driverService.deleteDriver(driver);
    }

    // Show a list of drivers
    public void showDriverList() {
        for (Driver driver : driverService.listDrivers()) {
            System.out.println(driver.getDriver_name());
        }
    }

    public static void main(String[] args) {
        // Creating an instance of DriversController
        DriverController driversController = new DriverController();

        // Creating and inserting a new driver
//        boolean createDriverStatus = driversController.createDriver("John Doe", new java.sql.Date(System.currentTimeMillis()), "10%", "1234567890");
//        System.out.println("Create Driver Status: " + createDriverStatus);

//        // Updating an existing driver
//        boolean updateDriverStatus = driversController.updateDriver(1, "Jane Smith", new java.sql.Date(System.currentTimeMillis()), "15%", "9876543210");
//        System.out.println("Update Driver Status: " + updateDriverStatus);

//        // Showing a list of drivers
//        System.out.println("Driver List:");
//        driversController.showDriverList();
//
//        // Deleting a driver
//        boolean deleteDriverStatus = driversController.deleteDriver(1);
//        System.out.println("Delete Driver Status: " + deleteDriverStatus);
//

    }
}

