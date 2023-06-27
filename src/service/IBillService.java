package service;
import java.util.ArrayList;
import model.Bill;

public interface IBillService {
    public boolean createBill(Bill bill);
    public boolean updateBill(Bill bill);
    public boolean deleteBill(Bill bill);
    public ArrayList<Bill> listBills();
}

