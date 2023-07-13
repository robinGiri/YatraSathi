package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import service.BillService;
import model.Bill;

public class BillController {
    public boolean createBill(Bill bill) {
        BillService billService = new BillService();
        return billService.createBill(bill);
    }

    public Bill getBillById(int billNo) {
        BillService billService = new BillService();
        return billService.getBillById(billNo);
    }
    
    public boolean updateBill(Bill bill) {
        BillService billService = new BillService();
        return billService.updateBill(bill);
    }

    public boolean deleteBill(int billNo) {
        BillService billService = new BillService();
        return billService.deleteBill(billNo);
    }

    public ArrayList<Bill> listBills() {
        BillService billService = new BillService();
        return billService.listBills();
    }
    public static void main(String[] args) {
        Bill bill = new Bill();
        BillController billController = new BillController();
        bill.setBillNo(1);
        bill.setCarId(1);
        bill.setCustomerId(1);
        bill.setDate(Date.valueOf("2023-12-07"));
        bill.setRentalId(1);
        billController.createBill(bill);
    }
    

}
