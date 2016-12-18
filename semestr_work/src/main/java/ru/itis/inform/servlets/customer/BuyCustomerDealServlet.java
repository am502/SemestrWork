package ru.itis.inform.servlets.customer;

import ru.itis.inform.models.*;
import ru.itis.inform.service.impl.*;
import ru.itis.inform.service.interfaces.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artur on 17.12.2016.
 */
@WebServlet("/buycustdeal/*")
public class BuyCustomerDealServlet extends HttpServlet {

    ArchiveService archiveService = new ArchiveServiceImpl();

    VendorService vendorService = new VendorServiceImpl();

    UserService userService = new UserServiceImpl();

    CustomerDealService customerDealService = new CustomerDealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        if (userService.isCustomer(user.getUserId())) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }

        getServletConfig().getServletContext().getRequestDispatcher("/views/buycustdeal.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        Vendor vendor = vendorService.getByUserId(user.getUserId());

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

        Archive archive = new Archive.Builder()
                .vendorId(vendor.getVendorId())
                .customerId(customerDeal.getCustomer().getCustomerId())
                .goodName(customerDeal.getGoodName())
                .price(customerDeal.getPrice())
                .comment(req.getParameter("comment"))
                .build();

        archiveService.insert(archive);
        customerDealService.delete(dealId);

        resp.sendRedirect("/customerdeals");
    }
}
