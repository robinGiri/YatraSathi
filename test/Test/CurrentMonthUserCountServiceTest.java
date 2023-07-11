package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import service.CurrentMonthUserCountService;

public class CurrentMonthUserCountServiceTest {



    @Test
    public void testCountCurrentMonthUser() throws SQLException {
        LocalDate currentDate = LocalDate.of(2023, 7, 6); // Set the desired current date
        YearMonth currentMonth = YearMonth.from(currentDate);
        CurrentMonthUserCountService currentMonthUserCountService = new CurrentMonthUserCountService();
        int expectedUserCount = 1; // Set the expected user count


        int actualUserCount = currentMonthUserCountService.countCurrentMonthUser();

        assertEquals(expectedUserCount, actualUserCount);
      
    }
}
