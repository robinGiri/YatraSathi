package Test;
import static org.junit.Assert.*;
import org.junit.Test;
import controller.LoginController;

public class LoginControllerTest {

    @Test
    public void testLogin() {
        // Create an instance of LoginController
        LoginController loginController = new LoginController();

        // Test case 1: Correct username and password
        String username1 = "john doe";
        String password1 = "password123";
        boolean result1 = loginController.login(username1, password1);
        assertTrue(result1);
    }
}

