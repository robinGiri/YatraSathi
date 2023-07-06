package test;
import org.junit.Assert; 

import service.CurrentMonthPaymentCountService;

public class PaymentCountServiceTest {

    public void countTotalPaymentAmount() {
        double totalPaymentAmount = 0.0;
        CurrentMonthPaymentCountService paymentCountService = new CurrentMonthPaymentCountService();
        totalPaymentAmount = paymentCountService.countCurrentMonthPaymentAmount();

        assertTrue(totalPaymentAmount > 0);

    }

    public static void main(String[] args) {
        PaymentCountServiceTest paymentCountServiceTest = new PaymentCountServiceTest();
        paymentCountServiceTest.countTotalPaymentAmount();
    }

}
