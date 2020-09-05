package pl.jaz.jazapp;

import pl.jaz.jazapp.pojo.UserEntity;

import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
@Named
public class ExampleFilter extends HttpFilter {

    @Inject
    UserContext userContext;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (isUserAuthenticated() || isSiteAllowed(req) || isResourceReq(req)) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }
    }

    private boolean isUserAuthenticated() {
        return userContext.isLogged();
    }

    private boolean isResourceReq(HttpServletRequest req) {
        return req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
    }

    private boolean isSiteAllowed(HttpServletRequest req) {
        return "/login.xhtml".equals(req.getServletPath()) ||
                "/register.xhtml".equals((req.getServletPath()));
    }

    private boolean isUserLogged() {
        return false;
    }


    public boolean getIsUserAnAdmin() {
        return userContext.getRole().equals("ADMIN");
    }
}
