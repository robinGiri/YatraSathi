package model;

import java.util.Date;

public class BillDetails {

    public BillDetails() {
    }

    public BillDetails(int billNo, Date billDate, String customerName, int carNo, String carName, double carRate, Date rentalDate, Date returnDate, double totalAmount, double discountAmount, double total, double totalAfterDiscount) {
        this.billNo = billNo;
        this.billDate = billDate;
        this.customerName = customerName;
        this.carNo = carNo;
        this.carName = carName;
        this.carRate = carRate;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalAmount = totalAmount;
        this.discountAmount = discountAmount;
        this.total = total;
        this.totalAfterDiscount = totalAfterDiscount;
    }

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCarNo() {
        return carNo;
    }

    public void setCarNo(int carNo) {
        this.carNo = carNo;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getCarRate() {
        return carRate;
    }

    public void setCarRate(double carRate) {
        this.carRate = carRate;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalAfterDiscount() {
        return totalAfterDiscount;
    }

    public void setTotalAfterDiscount(double totalAfterDiscount) {
        this.totalAfterDiscount = totalAfterDiscount;
    }
    private int billNo;
    private Date billDate;
    private String customerName;
    private int carNo;
    private String carName;
    private double carRate;
    private Date rentalDate;
    private Date returnDate;
    private double totalAmount;
    private double discountAmount;
    private double total;
    private double totalAfterDiscount;
}
