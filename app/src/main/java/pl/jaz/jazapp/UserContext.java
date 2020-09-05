package pl.jaz.jazapp;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UserContext implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean isLogged;

    private String username;
    private String password;
    private int id;
    private String role;


    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }

    public boolean isLogged() { return isLogged; }

    public void setLogged(boolean logged) { isLogged = logged; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
