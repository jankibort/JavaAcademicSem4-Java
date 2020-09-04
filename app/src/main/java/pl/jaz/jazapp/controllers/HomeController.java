package pl.jaz.jazapp.controllers;

import pl.jaz.jazapp.UserContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class HomeController {
    @Inject
    UserContext userContext;

    public UserContext getUser() {
        return userContext;
    }

    public String logout() {
        userContext.setLogged(false);
        userContext.setUsername(null);
        userContext.setPassword(null);
        return "/login.xhtml?faces-redirect=true";
    }
}
