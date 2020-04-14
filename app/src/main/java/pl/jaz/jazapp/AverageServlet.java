package pl.jaz.jazapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.*;
import java.text.DecimalFormat;

@WebServlet("average")
public class AverageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(200);
        resp.setContentType("text/plain");

        var numbers = req.getParameter("numbers");
        var writer = resp.getWriter();

        if (numbers == null || numbers.isEmpty()) {
            writer.println("Please put parameters");
        } else {
            String[] myNumbers = numbers.split(",");

            var counter = 0;
            Float value = 0f;

            for (int i = 0; i < myNumbers.length; i++) {
                if (Character.isDigit(myNumbers[i].charAt(0))) {
                    value += Float.parseFloat(myNumbers[i]);
                    counter++;
                } else {
                    writer.println("Wrong parameter given");
                    return;
                }
            }

            var average = value / counter;

            DecimalFormat n = new DecimalFormat("0.##");
            n.setRoundingMode(RoundingMode.HALF_UP);

            writer.println(n.format(average));
        }
    }
}
