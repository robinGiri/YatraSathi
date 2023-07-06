package model;
import java.util.Date;

public class Bill {
    private int rentalId;
    private int adminId;
    private int paymentId;
    private Date paymentDate;
    private double paymentAmount;

    public Bill(int rentalId, int adminId, int paymentId, Date paymentDate, double paymentAmount) {
        this.rentalId = rentalId;
        this.adminId = adminId;
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    } 
        public Bill(int rentalId,int paymentId, Date paymentDate, double paymentAmount) {
            this.rentalId = rentalId;
            this.paymentId = paymentId;
            this.paymentDate = paymentDate;
            this.paymentAmount = paymentAmount;
    }
    
    public Bill() {
    
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
