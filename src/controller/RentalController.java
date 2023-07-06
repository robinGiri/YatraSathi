package controller;

import model.Rental;
import service.RentalService;

import java.util.ArrayList;
import model.Car;

public class RentalController {
    private RentalService rentalService;

    public RentalController() {
        rentalService = new RentalService();
    }

    public boolean createRental(int rentalId, java.util.Date rentalDateTime,
            int totalPrice, int ownerId, int carId, int categoryId, int customerId,
            String rentalStatus, String pickup, String dropoff, int driverId, int paymentId) {
        Rental rental = new Rental(rentalId, new java.sql.Date(rentalDateTime.getTime()),
                 totalPrice, ownerId, carId, categoryId, customerId,
                rentalStatus, pickup, dropoff, driverId, paymentId);
        return rentalService.createRental(rental);
    }

    public boolean updateRental(int rentalId, java.util.Date rentalDateTime, 
            int totalPrice, int ownerId, int carId, int categoryId, int customerId,
            String rentalStatus, String pickup, String dropoff, int driverId, int paymentId) {
        Rental rental = new Rental(rentalId, new java.sql.Date(rentalDateTime.getTime()),
                 totalPrice, ownerId, carId, categoryId, customerId,
                rentalStatus, pickup, dropoff, driverId, paymentId);
        return rentalService.updateRental(rental);
    }

    public boolean deleteRental(int rentalId) {
        return rentalService.deleteRental(rentalId);
    }
        public Rental searchRental(int rentalId){
        Rental DetailRental = rentalService.getRentalById(rentalId);
        return DetailRental;
    }




    public ArrayList<Rental> ListRentals() {
        ArrayList<Rental> rentalsList = rentalService.listRentals();
        if (rentalsList.isEmpty()) {
            return null;
        } else {
            return rentalsList;
        }
    }
}
