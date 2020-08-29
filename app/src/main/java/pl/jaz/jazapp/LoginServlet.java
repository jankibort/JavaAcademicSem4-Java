package pl.jaz.jazapp;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@WebServlet("login")
public class LoginServlet extends HttpServlet {

    @Inject
    UserContext userContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var writer = resp.getWriter();
        resp.setStatus(200);
        resp.setContentType("text/plain");
        writer.println(String.format("I am logged: %s", userContext.isLogged()));
//        userContext.();
    }
}


      /*  var numbers = req.getParameter("numbers");


        var mySessionId = Arrays.stream(req.getCookies() != null ? req.getCookies() : new Cookie[]{})
                .filter(it -> "MYSESSIONID".equals(it.getName())).map(Cookie::getValue).findFirst();

        var actualSessionId = mySessionId.orElse(UUID.randomUUID().toString());


        resp.setStatus(200);
        resp.setContentType("text/plain");

        //Cookie userId = new Cookie("userId", req.getParameter("userId"));
        resp.setHeader("Set-Cookie", String.format("MYSESSIONID=%s", actualSessionId));

        //resp.addCookie((userId));

        var writer = resp.getWriter();
        writer.println("I got " + numbers + "Cookie: " + actualSessionId);*/