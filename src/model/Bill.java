package model;
import java.util.Date;

public class Bill {
    private int billNo;
    private Date date;
    private int carId;
    private int rentalId;
    private int customerId;
    public Bill(){
        
    }

    public Bill(int billNo, Date date, int carId, int rentalId, int customerId) {
        this.billNo = billNo;
        this.date = date;
        this.carId = carId;
        this.rentalId = rentalId;
        this.customerId = customerId;
    }
    public Bill(Date date, int carId, int rentalId, int customerId) {
        this.date = date;
        this.carId = carId;
        this.rentalId = rentalId;
        this.customerId = customerId;
    }

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
  
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }
     public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }   
}
