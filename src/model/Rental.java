package model;

import java.sql.Date;

public class Rental {

   
    private int rental_id;
    private Date rental_datetime;   
    private Date return_datetime;
    private int car_id;
    private int customer_id;
    private String pickup;
    private String dropoff;

    public Rental(int rental_id, Date rental_datetime,Date return_datetime, int car_id, int customer_id, String pickup, String dropoff) {
        this.rental_id = rental_id;
        this.return_datetime= return_datetime;
        this.rental_datetime = rental_datetime;
        this.car_id = car_id;
        this.customer_id = customer_id;
        this.pickup = pickup;
        this.dropoff = dropoff;
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

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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
    
    public Date getReturn_datetime() {
        return return_datetime;
    }

    public void setReturn_datetime(Date return_datetime) {
        this.return_datetime = return_datetime;
    }

}
