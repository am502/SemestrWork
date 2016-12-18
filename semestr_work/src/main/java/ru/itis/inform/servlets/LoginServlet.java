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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user;
        try {
            user = userService.getByUsername(username);
        } catch (Exception e) {
            user = null;
        }

        if(user != null && password.equals(user.getPassword())) {
            req.getSession().setAttribute("session_username", username);
            resp.sendRedirect("/profile");
        }
        else{
            getServletConfig().getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
