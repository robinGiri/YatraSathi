package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DbConnection;
import java.time.LocalDate;
import java.time.YearMonth;

public class CurrentMonthUserCountService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    public int countCurrentMonthUser() {
        connection = dbConnection.connection;
        int userCount = 0;
        
        LocalDate currentDate = LocalDate.now();
        YearMonth currentMonth = YearMonth.from(currentDate);

        String query = "SELECT COUNT(*) AS UserCount FROM user WHERE YEAR(dateOfJoin) = ? AND MONTH(dateOfJoin) = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, currentMonth.getYear());
            preparedStatement.setInt(2, currentMonth.getMonthValue());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userCount = resultSet.getInt("UserCount");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources();
        }

        return userCount;
    }

    private void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while closing resources: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CurrentMonthUserCountService userCountService = new CurrentMonthUserCountService();
        int currentMonthUserCount = userCountService.countCurrentMonthUser();
        System.out.println("Number of users who joined this month: " + currentMonthUserCount);
    }
}

