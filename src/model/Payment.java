package model;

import java.util.Date;

public class Payment {
    private int paymentId;
    private int rentalId;
    private double paymentAmount;
    private Date paymentDate;
    private int adminId;

    public Payment(int paymentId, int rentalId, double paymentAmount, Date paymentDate, int adminId) {
        this.paymentId = paymentId;
        this.rentalId = rentalId;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.adminId = adminId;
    }

    public Payment() {
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}

