package pl.jaz.jazapp.controllers;


import pl.jaz.jazapp.UserContext;
import pl.jaz.jazapp.requests.LoginRequest;
import pl.jaz.jazapp.pojo.UserEntity;
import pl.jaz.jazapp.services.user.UserSearchService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@RequestScoped
@Named
public class LoginController {
    @Inject
    UserContext userContext;
    @Inject
    UserSearchService userSearchService;

    public String login(LoginRequest loginRequest) {
        Optional<UserEntity> user = userSearchService.findUser(loginRequest.getUsername(), loginRequest.getPassword());

        if(user.isEmpty()) {
            var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            flash.put("error-message", "Username or password is incorrect");
            return "/login.xhtml?faces-redirect=true";
        } else {
            userContext.setId(user.get().getId());
            userContext.setUsername(user.get().getUsername());
            userContext.setPassword(user.get().getPassword());
            userContext.setRole(user.get().getRole());
            userContext.setLogged(true);
            return "/index.xhtml?faces-redirect=true";
        }
    }
}
