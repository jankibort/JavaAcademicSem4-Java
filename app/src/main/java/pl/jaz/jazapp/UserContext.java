package pl.jaz.jazapp;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UserContext implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean isLogged;

    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String birthdate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public UserContext() {

    }

    public UserContext(String username, String firstname, String lastname, String password, String email, String birthdate) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
    }

    public UserContext(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void LogIn(){
        isLogged = true;
    }

    public void Logout() {
        this.username = "";
        this.firstname = "";
        this.lastname = "";
        this.password = "";
        this.email = "";
        this.birthdate = "";
        this.isLogged = false;
    }
}
