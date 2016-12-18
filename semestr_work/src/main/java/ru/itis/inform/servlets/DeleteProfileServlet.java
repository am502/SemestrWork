package ru.itis.inform.servlets;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by artur on 13.12.2016.
 */
@WebServlet("/delete")
public class DeleteProfileServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));
        userService.deleteUser(user.getUserId());
        session.invalidate();
        resp.sendRedirect("/login");
    }
}
