package Test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


import service.UserCountService;

public class UserCountServiceTest {
    
    @Test
    public void testGetUserCount() throws SQLException {
        String query = "SELECT COUNT(*) AS userCount FROM user";
        int expectedUserCount = 30;
        UserCountService userCountService = new UserCountService();
        int actualUserCount = userCountService.getUserCount();
        
        assertEquals(expectedUserCount, actualUserCount);

    }
}
