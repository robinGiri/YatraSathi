package service;

import java.sql.*;
import database.DbConnection;
import model.Subscription;
import java.util.*;

public class SubscriptionServices implements ISubscriptionService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    // It checks the table and create new tables if not exists
    public boolean CheckTableSubscription() {
        connection = dbConnection.connection;
        String query = "CREATE TABLE IF NOT EXISTS subscription (" +
                "subscriptionId INT PRIMARY KEY, " +
                "type VARCHAR(25), " +
                "discountRate double)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return (true);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (false);

    }

    // Create subscription
    public boolean createSubscription(Subscription subscription) {
        CheckTableSubscription();
        connection = dbConnection.connection;
        String query = "INSERT INTO subscription(subscriptionId,type,discountRate) values (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(subscription.getSubscriptionId()));
            preparedStatement.setString(2, subscription.getType());
            preparedStatement.setString(3, Double.toString(subscription.getDiscountRate()));
            int status = preparedStatement.executeUpdate();
            System.out.println(status);
            return (true);

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return (false);

    }

    public boolean updateSubscription(Subscription subscription) {
        connection = dbConnection.connection;
        String query = "UPDATE subscription SET (subscriptionId = ?,type = ?,discountRate = ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(subscription.getSubscriptionId()));
            preparedStatement.setString(2, query);
            preparedStatement.setString(3, Double.toString(subscription.getDiscountRate()));
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteSubscription(Subscription subscription) {
        connection = dbConnection.connection;
        String query = "DELETE FROM subscription where subscriptionId=?;";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(subscription.getSubscriptionId()));
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<Subscription> listSubscription() {
        ArrayList<Subscription> subscriptionslist = new ArrayList<Subscription>();
        connection = dbConnection.connection;
        String query = "SELECT * FROM subscription";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int SubId = Integer.parseInt(resultSet.getString("subscriptionId"));
                String type = resultSet.getString("type");
                double discount = Double.parseDouble(resultSet.getString("discountRate"));
                Subscription subscription = new Subscription(SubId, type, discount);
                subscriptionslist.add(subscription);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return subscriptionslist;
    }
    public static void main(String[] args) {
    SubscriptionServices subscriptionService = new SubscriptionServices();

    Subscription subscription1 = new Subscription(1, "Gold", 1.2);
    Subscription subscription2 = new Subscription(2, "Silver", 2.1);

    subscriptionService.createSubscription(subscription1);
    subscriptionService.createSubscription(subscription2);
}
    
}
