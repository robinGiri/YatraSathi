package model;

public class MonthlyIncome {

    
    private int year;
    private int month;
    private double totalAmount;
    private double totalDiscount;
    private double totalAfterDiscount;
    private int numberOfBills;
    
    public MonthlyIncome(int aInt, double aDouble, double aDouble1, double aDouble2, int aInt1) {
    }
    
    public MonthlyIncome(int year, int month, double totalAmount, double totalDiscount, double totalAfterDiscount, int numberOfBills) {
        this.year = year;
        this.month = month;
        this.totalAmount = totalAmount;
        this.totalDiscount = totalDiscount;
        this.totalAfterDiscount = totalAfterDiscount;
        this.numberOfBills = numberOfBills;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalAfterDiscount() {
        return totalAfterDiscount;
    }

    public void setTotalAfterDiscount(double totalAfterDiscount) {
        this.totalAfterDiscount = totalAfterDiscount;
    }

    public int getNumberOfBills() {
        return numberOfBills;
    }

    public void setNumberOfBills(int numberOfBills) {
        this.numberOfBills = numberOfBills;
    }
}
