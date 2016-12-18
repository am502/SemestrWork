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
@WebServlet("/addcustdeal")
public class AddCustomerDealServlet extends HttpServlet {

    CustomerDealService customerDealService = new CustomerDealServiceImpl();

    UserService userService = new UserServiceImpl();

    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        if (!userService.isCustomer(user.getUserId())) {
            resp.sendRedirect("/error");
            return;
        }

        getServletConfig().getServletContext().getRequestDispatcher("/views/addcustdeal.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));
        Customer customer = customerService.getByUserId(user.getUserId());

        CustomerDeal customerDeal = new CustomerDeal.Builder()
                .customer(customer)
                .goodName(req.getParameter("goodName"))
                .lotSize(Integer.valueOf(req.getParameter("lotSize")))
                .price(Integer.valueOf(req.getParameter("price")))
                .phoneNumber(customer.getPhoneNumber())
                .paymentMethod(req.getParameter("paymentMethod"))
                .note(req.getParameter("note"))
                .build();

        customerDealService.insert(customerDeal);
        resp.sendRedirect("/yourcustomerdeals");
    }
}
