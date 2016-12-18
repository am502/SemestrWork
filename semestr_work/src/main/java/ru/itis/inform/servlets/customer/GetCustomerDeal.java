package ru.itis.inform.servlets.customer;

import ru.itis.inform.models.Customer;
import ru.itis.inform.models.CustomerDeal;
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
@WebServlet("/getcustdeals/*")
public class GetCustomerDeal extends HttpServlet {

    UserService userService = new UserServiceImpl();

    CustomerDealService customerDealService = new CustomerDealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        if (!userService.isCustomer(user.getUserId())) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }

        String[] pathInfo = req.getPathInfo().split("/");
        String id = pathInfo[1];
        int dealId = -1;
        if (id.matches("[0-9]"))
            dealId = Integer.valueOf(id);

        CustomerDeal customerDeal;
        try {
            customerDeal = customerDealService.getById(dealId);
        } catch (Exception e) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("customerDeal", customerDeal);

        getServletConfig().getServletContext().getRequestDispatcher("/views/getcustdeals.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] pathInfo = req.getPathInfo().split("/");
        String id = pathInfo[1];

        customerDealService.delete(Integer.valueOf(id));
        resp.sendRedirect("/yourcustomerdeals");
    }
}
