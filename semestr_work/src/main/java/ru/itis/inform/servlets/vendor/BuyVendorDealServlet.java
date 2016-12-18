package ru.itis.inform.servlets.vendor;

import ru.itis.inform.models.Archive;
import ru.itis.inform.models.Customer;
import ru.itis.inform.models.User;
import ru.itis.inform.models.VendorDeal;
import ru.itis.inform.service.impl.ArchiveServiceImpl;
import ru.itis.inform.service.impl.CustomerServiceImpl;
import ru.itis.inform.service.impl.UserServiceImpl;
import ru.itis.inform.service.impl.VendorDealServiceImpl;
import ru.itis.inform.service.interfaces.ArchiveService;
import ru.itis.inform.service.interfaces.CustomerService;
import ru.itis.inform.service.interfaces.UserService;
import ru.itis.inform.service.interfaces.VendorDealService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artur on 17.12.2016.
 */
@WebServlet("/buyvenddeal/*")
public class BuyVendorDealServlet extends HttpServlet {

    ArchiveService archiveService = new ArchiveServiceImpl();

    CustomerService customerService = new CustomerServiceImpl();

    UserService userService = new UserServiceImpl();

    VendorDealService vendorDealService = new VendorDealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        if (!userService.isCustomer(user.getUserId())) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }

        getServletConfig().getServletContext().getRequestDispatcher("/views/buyvenddeal.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        Customer customer = customerService.getByUserId(user.getUserId());

        String[] pathInfo = req.getPathInfo().split("/");
        String id = pathInfo[1];
        int dealId = -1;
        if (id.matches("[0-9]"))
            dealId = Integer.valueOf(id);

        VendorDeal vendorDeal;
        try {
            vendorDeal = vendorDealService.getById(dealId);
        } catch (Exception e) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }

        Archive archive = new Archive.Builder()
                .vendorId(vendorDeal.getVendor().getVendorId())
                .customerId(customer.getCustomerId())
                .goodName(vendorDeal.getGoodName())
                .price(vendorDeal.getPrice())
                .comment(req.getParameter("comment"))
                .build();

        archiveService.insert(archive);
        vendorDealService.delete(dealId);

        resp.sendRedirect("/vendordeals");
    }
}
