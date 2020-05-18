package pl.jaz.jazapp.webapp.home;

import pl.jaz.jazapp.UserContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class HomeController {
    @Inject
    UserContext user;

    public UserContext getUser() {
        return user;
    }

    public String logout() {
        user.Logout();
        return "/login.xhtml?faces-redirect=true";
    }
}
