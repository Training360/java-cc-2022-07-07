package app;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WelcomeScreen {

    public Messages messages;

    public void saveEmployee(String name) {
        // Adatbázisba mentjük
        messages.showMessage("message", String.format("Employee %s has created", name));
    }
}
