package controller;

import model.Rental;
import service.RentalService;
import java.util.ArrayList;
import model.Bill;
import service.BillService;

public class RentalController {
    private RentalService rentalService;
    private BillService billService;
    private Bill bill;
    public boolean createRental(Rental rental) {
        
        if (rentalService.createRental(rental)){
            bill.setCarId(rental.getCar_id());
            bill.setCustomerId(rental.getCustomer_id());
            bill.setRentalId(rental.getRental_id());
            return billService.createBill(bill);
        }
        return false;
    }

    public boolean updateRental(Rental rental){
        
        if (rentalService.updateRental(rental)){
            bill.setCarId(rental.getCar_id());
            bill.setCustomerId(rental.getCustomer_id());
            bill.setRentalId(rental.getRental_id());
            return  billService.updateBill(bill);
        }
        return false;
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
        return rentalsList;
    }

}
