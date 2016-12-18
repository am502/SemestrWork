package ru.itis.inform.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.inform.dao.impl.UserDaoImpl;
import ru.itis.inform.dao.interfaces.UserDao;
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
 * Created by artur on 06.12.2016.
 */

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        req.setAttribute("lastName", user.getLastName());
        req.setAttribute("firstName", user.getFirstName());

        boolean isCustomer = userService.isCustomer(user.getUserId());
        if (isCustomer) {
            req.setAttribute("status", "Покупатель");
        } else {
            req.setAttribute("status", "Продавец");
        }

        getServletConfig().getServletContext().getRequestDispatcher("/views/profile.jsp").forward(req,resp);
    }
}
