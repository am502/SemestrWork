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
 * Created by artur on 15.12.2016.
 */
@WebServlet("/updatecustdeal/*")
public class UpdateCustomerDealServlet extends HttpServlet {

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

        getServletConfig().getServletContext().getRequestDispatcher("/views/updatecustdeal.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] pathInfo = req.getPathInfo().split("/");
        String id = pathInfo[1];

        CustomerDeal customerDeal = customerDealService.getById(Integer.valueOf(id));

        String goodName = req.getParameter("goodName");
        if (!goodName.equals(""))
            customerDeal.setGoodName(goodName);

        String lotSize = req.getParameter("lotSize");
        if (!lotSize.equals(""))
            customerDeal.setLotSize(Integer.valueOf(lotSize));

        String price = req.getParameter("price");
        if (!price.equals(""))
            customerDeal.setPrice(Integer.valueOf(price));

        String paymentMethod = req.getParameter("paymentMethod");
        if (!paymentMethod.equals(""))
            customerDeal.setPaymentMethod(paymentMethod);

        String note = req.getParameter("note");
        if (!note.equals(""))
            customerDeal.setNote(note);

        customerDealService.update(customerDeal);
        resp.sendRedirect("/getcustdeals/" + id);
    }
}
