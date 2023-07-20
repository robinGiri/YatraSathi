package controller;

import model.BillDetails;
import service.BillDetailsService;
import java.util.ArrayList;

public class BillDetailsController {
    private BillDetailsService billDetailsService = new BillDetailsService();

    public BillDetails getBillDetailsByBillNumber(int billNumber) {
        return billDetailsService.getBillDetailsByBillNumber(billNumber);
    }

    public ArrayList<BillDetails> getBillDetails() {
        return billDetailsService.getBillDetails();
    }
}
