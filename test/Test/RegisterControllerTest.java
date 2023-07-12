package Test;
import static org.junit.Assert.*;
import org.junit.Test;
import controller.RegisterController;

public class RegisterControllerTest {

    @Test
    public void testRegister() {
        // Create an instance of RegisterController
        RegisterController registerController = new RegisterController();

        // Test case 1: Successful registration
        String username1 = "john_doe";
        String email1 = "john@example.com";
        String password1 = "password123";
        boolean result1 = registerController.register(username1, email1, password1);
        assertTrue(result1);
    }
}

