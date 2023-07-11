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
            int carId, int customerId, String pickup, String dropoff) {
        Rental rental = new Rental(rentalId, new java.sql.Date(rentalDateTime.getTime()),
                new java.sql.Date(returnDateTime.getTime()), carId, customerId,
                pickup, dropoff);
        return rentalService.createRental(rental);
    }

    public boolean updateRental(int rentalId, java.util.Date rentalDateTime, java.util.Date returnDateTime,
            int carId, int customerId,
            String pickup, String dropoff) {
        Rental rental = new Rental(rentalId, new java.sql.Date(rentalDateTime.getTime()),
                new java.sql.Date(returnDateTime.getTime()),
                carId, customerId, pickup, dropoff);
        return rentalService.updateRental(rental);
    }

    public boolean deleteRental(int rentalId) {
        return rentalService.deleteRental(rentalId);
    }

    public Rental searchRental(int rentalId) {
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
