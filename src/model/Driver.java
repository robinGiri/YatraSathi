package model;

import java.sql.Date;

public class Driver {
    private int driver_id;
    private String driver_name;
    private Date joined_date;
    private String driver_commision;
    private String driver_contact;

    public Driver(int driver_id, String driver_name, Date joined_date, String driver_commision, String driver_contact) {
        this.driver_id = driver_id;
        this.driver_name = driver_name;
        this.joined_date = joined_date;
        this.driver_commision = driver_commision;
        this.driver_contact = driver_contact;
    }

    public Driver() {

    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public Date getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(Date joined_date) {
        this.joined_date = joined_date;
    }

    public String getDriver_commision() {
        return driver_commision;
    }

    public void setDriver_commision(String driver_commision) {
        this.driver_commision = driver_commision;
    }

    public String getDriver_contact() {
        return driver_contact;
    }


    public void setDriver_contact(String driver_contact) {
        this.driver_contact = driver_contact;
    }

}
