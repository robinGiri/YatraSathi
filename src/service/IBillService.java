package service;
import java.util.ArrayList;
import model.Bill;

public interface IBillService {
    public boolean createBill(Bill bill);
    public Bill getBillById(int billno);
    public boolean updateBill(Bill bill);
    public boolean deleteBill(int billNo);
    public ArrayList<Bill> listBills();
}

