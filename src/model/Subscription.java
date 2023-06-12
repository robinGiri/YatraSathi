package model;

public class Subscription {
    private int subscriptionId;
    private String type;
    private double discountRate;

    public Subscription(int subscriptionId, String type, double discountRate) {
        this.subscriptionId = subscriptionId;
        this.type = type;
        this.discountRate = discountRate;
    }

    public Subscription() {
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}

