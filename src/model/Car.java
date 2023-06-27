package model;

import java.sql.Date;

public class Car {
    private int car_id;
    private String car_name;
    private String car_brand;
    private Date car_model_year;
    private String car_color;
    private String plate_number;
    private String car_status;
    private String car_image;
    private int rate;
    private int owner_id;

    public Car(int car_id, String car_name, String car_brand, Date car_model_year, String car_color, String plate_number, String car_status, String car_image, int rate) {
        this.car_id = car_id;
        this.car_name = car_name;
        this.car_brand = car_brand;
        this.car_model_year = car_model_year;
        this.car_color = car_color;
        this.plate_number = plate_number;
        this.car_status = car_status;
        this.car_image = car_image;
        this.rate = rate;
        this.owner_id = owner_id;
    }
       public Car(int car_id, String car_name, String car_brand, Date car_model_year, String car_color, String plate_number, String car_status, int rate, int owner_id) {
        this.car_id = car_id;
        this.car_name = car_name;
        this.car_brand = car_brand;
        this.car_model_year = car_model_year;
        this.car_color = car_color;
        this.plate_number = plate_number;
        this.car_status = car_status;
        this.rate = rate;
        this.owner_id = owner_id;
    }

    public Car() {

    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_model_year(Date car_model_year) {
        this.car_model_year = car_model_year;
    }

    public Date getCar_model_year() {
        return car_model_year;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public void setCar_status(String car_status) {
        this.car_status = car_status;
    }

    public String getCar_status() {
        return car_status;
    }

    public void setCar_image(String car_image) {
        this.car_image = car_image;
    }

    public String getCar_image() {
        return car_image;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

}
