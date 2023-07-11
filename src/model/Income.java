package model;

public class Income {

    public Income(int rental_year, int rental_month, double total_income) {
        this.rental_year = rental_year;
        this.rental_month = rental_month;
        this.total_income = total_income;
    }

    public Income() {

    }

    public int getRental_year() {
        return rental_year;
    }

    public void setRental_year(int rental_year) {
        this.rental_year = rental_year;
    }

    public int getRental_month() {
        return rental_month;
    }

    public void setRental_month(int rental_month) {
        this.rental_month = rental_month;
    }

    public double getTotal_income() {
        return total_income;
    }

    public void setTotal_income(double total_income) {
        this.total_income = total_income;
    }

    int rental_year;
    int rental_month;
    double total_income;

}
