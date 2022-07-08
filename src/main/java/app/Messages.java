package app;

import javax.faces.context.FacesContext;

public class Messages {

    public void showMessage(String key, String message) {
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getFlash()
                .put(key, message);
    }
}
