package ru.itis.inform.servlets.customer;

import ru.itis.inform.dao.impl.CustomerDealDaoImpl;
import ru.itis.inform.dao.interfaces.CustomerDealDao;
import ru.itis.inform.models.Customer;
import ru.itis.inform.models.User;
import ru.itis.inform.service.impl.CustomerDealServiceImpl;
import ru.itis.inform.service.impl.CustomerServiceImpl;
import ru.itis.inform.service.impl.UserServiceImpl;
import ru.itis.inform.service.interfaces.CustomerDealService;
import ru.itis.inform.service.interfaces.CustomerService;
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
@WebServlet("/yourcustomerdeals")
public class ShowYourCustomerDeals extends HttpServlet {

    CustomerService customerService = new CustomerServiceImpl();

    UserService userService = new UserServiceImpl();

    CustomerDealService customerDealService = new CustomerDealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        if (!userService.isCustomer(user.getUserId())) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }

        Customer customer = customerService.getByUserId(user.getUserId());

        req.setAttribute("customerDealList", customerDealService.getByCustomerId(customer.getCustomerId()));
        getServletConfig().getServletContext().getRequestDispatcher("/views/yourcustomerdeals.jsp").forward(req,resp);
    }
}
