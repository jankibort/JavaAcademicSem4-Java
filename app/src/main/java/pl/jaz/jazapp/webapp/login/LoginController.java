package pl.jaz.jazapp.webapp.login;


import pl.jaz.jazapp.UserMap;
import pl.jaz.jazapp.pojo.Auction;
import pl.jaz.jazapp.pojo.UserEntity;
import pl.jaz.jazapp.services.AuctionService;
import pl.jaz.jazapp.users.UserSearchService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@RequestScoped
@Named
public class LoginController {
    @Inject
    UserMap users;
    @Inject
    AuctionService auctionService;
    @Inject
    UserSearchService userSearchService;

    public String login(LoginRequest loginRequest) {
        Optional<UserEntity> user = userSearchService.findUser(loginRequest.getUsername(), loginRequest.getPassword());
        if(loginRequest.getUsername().equals(user.get().getUsername()) && loginRequest.getPassword().equals(user.get().getPassword())) {
            var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            flash.put("error-message", "Username or password is incorrect");
            return "/login.xhtml?faces-redirect=true";
        }
//        if (!users.tryLogin(loginRequest)) {
//            var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
//            flash.put("error-message", "Username or password is incorrect.");
//            return "/login.xhtml?faces-redirect=true";
//        }

        return "/index.xhtml?faces-redirect=true";
    }

    public List<Auction> findAuctions(){
        return auctionService.findAllAuctions();
    }

}
