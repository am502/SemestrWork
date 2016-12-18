package ru.itis.inform.servlets.customer;

import ru.itis.inform.dao.impl.CustomerDealDaoImpl;
import ru.itis.inform.dao.impl.VendorDealDaoImpl;
import ru.itis.inform.dao.interfaces.CustomerDealDao;
import ru.itis.inform.dao.interfaces.VendorDealDao;
import ru.itis.inform.models.CustomerDeal;
import ru.itis.inform.models.User;
import ru.itis.inform.service.impl.CustomerDealServiceImpl;
import ru.itis.inform.service.impl.UserServiceImpl;
import ru.itis.inform.service.interfaces.CustomerDealService;
import ru.itis.inform.service.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artur on 14.12.2016.
 */
@WebServlet("/customerdeals")
public class CustomerDealsServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    CustomerDealService customerDealService = new CustomerDealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        if (userService.isCustomer(user.getUserId())) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("customerDealList", customerDealService.getAll());
        getServletConfig().getServletContext().getRequestDispatcher("/views/customerdeals.jsp").forward(req,resp);
    }
}
