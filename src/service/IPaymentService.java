package service;
import java.util.ArrayList;
import model.Payment;

public interface IPaymentService {
    public boolean createPayment(Payment payment);
    public boolean updatePayment(Payment payment);
    public boolean deletePayment(int paymentId);
    public ArrayList<Payment> listPayments();
}
