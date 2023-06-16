package controller;

import model.Rental;
import service.RentalService;

import java.util.ArrayList;

public class RentalController {
    private RentalService rentalService;

    public RentalController() {
        rentalService = new RentalService();
    }

    public boolean createRental(int rentalId, java.util.Date rentalDateTime, java.util.Date returnDateTime,
                                int totalPrice, int ownerId, int carId, int categoryId, int customerId,
                                String rentalStatus, String pickup, String dropoff, int driverId, int paymentId) {
        Rental rental = new Rental(rentalId, new java.sql.Date(rentalDateTime.getTime()),
                new java.sql.Date(returnDateTime.getTime()), totalPrice, ownerId, carId, categoryId, customerId,
                rentalStatus, pickup, dropoff, driverId, paymentId);
        return rentalService.createRental(rental);
    }

    public boolean updateRental(int rentalId, java.util.Date rentalDateTime, java.util.Date returnDateTime,
                                int totalPrice, int ownerId, int carId, int categoryId, int customerId,
                                String rentalStatus, String pickup, String dropoff, int driverId, int paymentId) {
        Rental rental = new Rental(rentalId, new java.sql.Date(rentalDateTime.getTime()),
                new java.sql.Date(returnDateTime.getTime()), totalPrice, ownerId, carId, categoryId, customerId,
                rentalStatus, pickup, dropoff, driverId, paymentId);
        return rentalService.updateRental(rental);
    }

    public boolean deleteRental(int rentalId) {
        return rentalService.deleteRental(rentalId);
    }

    public void showRentalList() {
        ArrayList<Rental> rentalsList = rentalService.listRentals();
        for (Rental rental : rentalsList) {
            System.out.println(rental.getRental_id() + " | " + rental.getRental_datetime() + " | "
                    + rental.getReturn_datetime() + " | " + rental.getTotal_price() + " | " + rental.getOwner_id()
                    + " | " + rental.getCar_id() + " | " + rental.getCategory_id() + " | " + rental.getCustomer_id() + " | " + rental.getRental_status() + " | " + rental.getPickup() + " | " + rental.getDropoff()
                    + " | " + rental.getDriver_id() + " | " + rental.getPayment_id());
        }
    }
}
