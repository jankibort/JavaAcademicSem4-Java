package pl.jaz.jazapp.webapp.register;

import pl.jaz.jazapp.users.UserCreatorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class RegisterController {

    @Inject
    private UserCreatorService userCreator;

    public String register(RegisterRequest registerRequest) {
        System.out.println("Tried to register" + registerRequest.toString());

        userCreator.createUser(registerRequest.getUsername(), registerRequest.getPassword());
        return "/login.xhtml?faces-redirect-true";
    }
}
