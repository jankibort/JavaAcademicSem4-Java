package pl.jaz.jazapp;

import pl.jaz.jazapp.webapp.login.LoginRequest;
import pl.jaz.jazapp.webapp.register.RegisterRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class UserMap {

    @Inject
    UserContext user;

    HashMap<String, List<String>> allUsers = new HashMap<>();

    public boolean tryRegister(RegisterRequest registerRequest) {
        for (Map.Entry<String, List<String>> entry : allUsers.entrySet()) {
            if (registerRequest.getUsername().equals(entry.getKey())) {
                return true;
            }
        }
        allUsers.put(registerRequest.getUsername(), createNewUser(registerRequest));

        return false;
    }

    public List<String> createNewUser(RegisterRequest registerRequest) {
        List<String> newUser = new ArrayList<>();
        newUser.add(registerRequest.getEmail());
        newUser.add(registerRequest.getFirstName());
        newUser.add(registerRequest.getLastName());
        newUser.add(registerRequest.getBirthdate());
        newUser.add(registerRequest.getPassword());

        return newUser;
    }

    public boolean tryLogin(LoginRequest loginRequest) {
        for (Map.Entry<String, List<String>> entry : allUsers.entrySet()) {
            if (loginRequest.getUsername().equals(entry.getKey())) {
                List<String> usernameValues = entry.getValue();
                if (loginRequest.getPassword().equals(usernameValues.get(4))) {
                    user.LogIn();
                    return true;
                }
            }
        }
        return false;
    }
}