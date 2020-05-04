package pl.jaz.jazapp.webapp.register;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class RegisterRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
