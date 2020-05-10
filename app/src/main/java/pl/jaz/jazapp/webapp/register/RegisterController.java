package pl.jaz.jazapp.webapp.register;

import pl.jaz.jazapp.UserMap;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class RegisterController {

    @Inject
    UserMap users;

    public String register(RegisterRequest registerRequest) {

        if (!registerRequest.getPassword().equals(registerRequest.getPasswordCheck())) {
            return "/register.xhtml?faces-redirect=true";
        }

        if (users.tryRegister(registerRequest)) {
            return "/register.xhtml?faces-redirect=true";
        }

        return "/login.xhtml?faces-redirect=true";
    }
}