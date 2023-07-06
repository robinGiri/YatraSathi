package model;

import java.sql.Date;

public class Rental {
    private int rental_id;
    private Date rental_datetime;
    private int total_price;
    private int owner_id;
    private int car_id;
    private int category_id;
    private int customer_id;
    private String rental_status;
    private String pickup;
    private String dropoff;
    private int driver_id;
    private int payment_id;

    public Rental(int rental_id, Date rental_datetime, int total_price, int owner_id, int car_id, int category_id, int customer_id, String rental_status, String pickup, String dropoff, int driver_id, int payment_id) {
        this.rental_id = rental_id;
        this.rental_datetime = rental_datetime;
        this.total_price = total_price;
        this.owner_id = owner_id;
        this.car_id = car_id;
        this.category_id = category_id;
        this.customer_id = customer_id;
        this.rental_status = rental_status;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.driver_id = driver_id;
        this.payment_id = payment_id;
    }

    public Rental() {

    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public Date getRental_datetime() {
        return rental_datetime;
    }

    public void setRental_datetime(Date rental_datetime) {
        this.rental_datetime = rental_datetime;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getRental_status() {
        return rental_status;
    }

    public void setRental_status(String rental_status) {
        this.rental_status = rental_status;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDropoff() {
        return dropoff;
    }

    public void setDropoff(String dropoff) {
        this.dropoff = dropoff;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

}
