package app;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeScreenTest {

    @Test
    void saveEmployee() {
        var messages = Mockito.mock(Messages.class);
        var welcomeScreen = new WelcomeScreen(messages);
        welcomeScreen.saveEmployee("John Doe");

        Mockito.verify(messages).showMessage("message", "Employee John Doe has created");
    }
}