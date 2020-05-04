package pl.jaz.jazapp.webapp.login;


import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@RequestScoped
@Named
public class LoginController {
    public String login(LoginRequest loginRequest) {
        System.out.println(String.format("Tried to login with username %s and password %s", loginRequest.getUsername(), loginRequest.getPassword()));
        // TODO code to log in & sessions

        if (true) {
            var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            flash.put("error-message", "Username or password is incorrect.");
            return "/login.xhtml?faces-redirect=true";
        }

        return "/index.xhtml?faces-redirect=true";
    }
}
