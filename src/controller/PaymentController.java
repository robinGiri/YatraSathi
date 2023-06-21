package controller;

import model.Payment;
import service.PaymentService;
import java.util.ArrayList;
import java.util.Date;

public class PaymentController {
    private PaymentService paymentService;

    public PaymentController() {
        this.paymentService = new PaymentService();
    }

    public void createPayment(int paymentId, int rentalId, double paymentAmount, Date paymentDate, int adminId) {
        Payment payment = new Payment(paymentId, rentalId, paymentAmount, paymentDate, adminId);
        boolean success = paymentService.createPayment(payment);
        if (success) {
            System.out.println("Payment created successfully.");
        } else {
            System.out.println("Failed to create payment.");
        }
    }

    public void updatePayment(int paymentId, int rentalId, double paymentAmount, Date paymentDate, int adminId) {
        Payment payment = new Payment(paymentId, rentalId, paymentAmount, paymentDate, adminId);
        boolean success = paymentService.updatePayment(payment);
        if (success) {
            System.out.println("Payment updated successfully.");
        } else {
            System.out.println("Failed to update payment.");
        }
    }

    public void deletePayment(int paymentId) {
        boolean success = paymentService.deletePayment(paymentId);
        if (success) {
            System.out.println("Payment deleted successfully.");
        } else {
            System.out.println("Failed to delete payment.");
        }
    }

    public ArrayList<Payment> listPayments() {
        ArrayList<Payment> paymentList = paymentService.listPayments();
        if (paymentList.isEmpty()) {
            return null;
        } else {
            return paymentList;
        }
    }
}
