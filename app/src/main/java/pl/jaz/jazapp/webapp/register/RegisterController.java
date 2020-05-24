package pl.jaz.jazapp.webapp.register;

import pl.jaz.jazapp.UserMap;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class RegisterController {

    @Inject
    UserMap users;

    public String register(RegisterRequest registerRequest) {

        if (!registerRequest.getPassword().equals(registerRequest.getPasswordCheck())) {
            var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            flash.put("error-password", "Passwords do not match.");
            return "/register.xhtml?faces-redirect=true";
        }

        if (users.tryRegister(registerRequest)) {
            var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            flash.put("user-exists", "Username is already taken.");
            return "/register.xhtml?faces-redirect=true";
        }

        return "/login.xhtml?faces-redirect=true";
    }
}