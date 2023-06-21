package service;
import java.util.ArrayList;
import model.Rental;

public interface IRentalService {
    public boolean createRental(Rental rental);
    public boolean updateRental(Rental rental);
    public boolean deleteRental(int rentalId);
    public ArrayList<Rental> listRentals();
    
}
