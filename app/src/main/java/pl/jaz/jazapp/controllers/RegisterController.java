package pl.jaz.jazapp.controllers;

import pl.jaz.jazapp.requests.RegisterRequest;
import pl.jaz.jazapp.services.user.UserCreatorService;
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
