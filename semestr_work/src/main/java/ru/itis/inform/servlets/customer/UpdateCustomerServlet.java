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
import java.util.List;

/**
 * Created by artur on 15.12.2016.
 */
@WebServlet("/updatecustomer")
public class UpdateCustomerServlet extends HttpServlet {

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

        getServletConfig().getServletContext().getRequestDispatcher("/views/updatecustomer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));
        Customer customer = customerService.getByUserId(user.getUserId());

        String firstname = req.getParameter("firstName");
        if (!firstname.equals(""))
            user.setFirstName(firstname);

        String lastName = req.getParameter("lastName");
        if (!lastName.equals(""))
            user.setLastName(lastName);

        String phone = req.getParameter("phone");
        if (!phone.equals(""))
            customer.setPhoneNumber(phone);

        userService.update(user);
        customer.setUser(user);
        customerService.update(customer);

        List<CustomerDeal> list = customerDealService.getByCustomerId(customer.getCustomerId());
        for (CustomerDeal deal: list) {
            deal.setCustomer(customer);
            deal.setPhoneNumber(phone);
            customerDealService.update(deal);
        }

        resp.sendRedirect("/profile");
    }
}
