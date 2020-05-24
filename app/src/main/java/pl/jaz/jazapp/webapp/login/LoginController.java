package pl.jaz.jazapp.webapp.login;


import pl.jaz.jazapp.UserMap;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class LoginController {
    @Inject
    UserMap users;

    public String login(LoginRequest loginRequest) {

        if (!users.tryLogin(loginRequest)) {
            var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            flash.put("error-message", "Username or password is incorrect.");
            return "/login.xhtml?faces-redirect=true";
        }

        return "/index.xhtml?faces-redirect=true";
    }
}
