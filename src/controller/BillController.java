package controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import service.BillService;
import model.Bill;

public class BillController {
    private BillService billService = new BillService();

    // Create a new bill
    public boolean createBill(int rentalId, int paymentId, Date paymentDate, double paymentAmount) {
        Bill bill = new Bill(rentalId, paymentId, paymentDate, paymentAmount);
        return billService.createBill(bill);
    }

    // Update an existing bill
    public boolean updateBill(int rentalId, int paymentId, Date paymentDate, double paymentAmount) {
        Bill bill = new Bill(rentalId, paymentId, paymentDate, paymentAmount);
        return billService.updateBill(bill);
    }

    // Delete a bill
    public boolean deleteBill(int paymentId) {
        Bill bill = new Bill();
        bill.setPaymentId(paymentId);
        return billService.deleteBill(bill);
    }
        public Bill searchBill(int PaymentId){
        Bill DetailBill = billService.getBillById(PaymentId);
        return DetailBill;
    }

    // Show a list of bills
    public void showBillList() {
        List<Bill> bills = billService.listBills();
        for (Bill bill : bills) {
            System.out.println("Rental ID: " + bill.getRentalId());
            System.out.println("Admin ID: " + bill.getAdminId());
            System.out.println("Payment ID: " + bill.getPaymentId());
            System.out.println("Payment Date: " + bill.getPaymentDate());
            System.out.println("Payment Amount: " + bill.getPaymentAmount());
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {
        // Creating an instance of BillController
        BillController billController = new BillController();

        // Example usage
        billController.createBill(1, 1, new Date(), 100.0);
        billController.createBill(2, 1, new Date(), 200.0);

        billController.showBillList();
    }
    public ArrayList<Bill> listBills() {
        ArrayList<Bill> BillsList = billService.listBills();
        if (BillsList.isEmpty()) {
            return null;
        } else {
            return BillsList;
        }
    }


}


