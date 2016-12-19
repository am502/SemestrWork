package ru.itis.inform.servlets;

import ru.itis.inform.models.User;
import ru.itis.inform.service.impl.UserServiceImpl;
import ru.itis.inform.service.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by anteg on 18.12.2016.
 */
@WebServlet("/registration")
public class RegServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher("/views/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phoneNumber");

        User user = new User.Builder()
                .login(login)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .build();

        if (userService.verifyLoginExistence(login) || userService.verifyCustomerPhoneExistence(phone) || userService.verifyVendorPhoneExistence(phone)) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/incorrectlogin.jsp").forward(req, resp);
            return;
        }

        if (status.equals("cust")) {
            userService.insertCustomer(user, phone);
        }
        else {
            userService.insertVendor(user, phone);
        }
        req.getSession().setAttribute("session_username", login);
        resp.sendRedirect("/profile");
    }
}
