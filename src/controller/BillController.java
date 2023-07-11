package controller;

import java.util.ArrayList;
import service.BillService;
import model.Bill;

public class BillController {
    private BillService billService;

    public BillController() {
        this.billService = new BillService();
    }

    public boolean createBill(Bill bill) {
        return billService.createBill(bill);
    }

    public Bill getBillById(int billNo) {
        return billService.getBillById(billNo);
    }

    public boolean updateBill(Bill bill) {
        return billService.updateBill(bill);
    }

    public boolean deleteBill(int billNo) {
        return billService.deleteBill(billNo);
    }

    public ArrayList<Bill> listBills() {
        return billService.listBills();
    }

}
