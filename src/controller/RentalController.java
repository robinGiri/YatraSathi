package controller;

import model.*;
import service.*;
import service.RentalService;
import java.util.ArrayList;

public class RentalController {
   
    public boolean createRental(Rental rental) {
        RentalService rentalService = new RentalService();        
        return rentalService.createRental(rental);
    }

    public boolean updateRental(Rental rental){
        RentalService rentalService = new RentalService();
        return rentalService.updateRental(rental);
    }

    public boolean deleteRental(int rentalId) {
        RentalService rentalService = new RentalService();
        return rentalService.deleteRental(rentalId);
    }
    
    public Rental searchRental(int rentalId){
        RentalService rentalService = new RentalService();
        Rental DetailRental = rentalService.getRentalById(rentalId);
        return DetailRental;
    }

    public ArrayList<Rental> ListRentals() {
        RentalService rentalService = new RentalService();
        ArrayList<Rental> rentalList = rentalService.listRentals();
        return rentalList;
    }
    
}
