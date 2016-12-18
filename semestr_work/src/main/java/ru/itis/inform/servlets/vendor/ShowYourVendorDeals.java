package ru.itis.inform.servlets.vendor;

import ru.itis.inform.models.User;
import ru.itis.inform.models.Vendor;
import ru.itis.inform.service.impl.UserServiceImpl;
import ru.itis.inform.service.impl.VendorDealServiceImpl;
import ru.itis.inform.service.impl.VendorServiceImpl;
import ru.itis.inform.service.interfaces.UserService;
import ru.itis.inform.service.interfaces.VendorDealService;
import ru.itis.inform.service.interfaces.VendorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artur on 14.12.2016.
 */
@WebServlet("/yourvendordeals")
public class ShowYourVendorDeals extends HttpServlet {

    VendorService vendorService = new VendorServiceImpl();

    UserService userService = new UserServiceImpl();

    VendorDealService vendorDealService = new VendorDealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        if (userService.isCustomer(user.getUserId())) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }

        Vendor vendor = vendorService.getByUserId(user.getUserId());

        req.setAttribute("vendorDealList", vendorDealService.getByVendorId(vendor.getVendorId()));
        getServletConfig().getServletContext().getRequestDispatcher("/views/yourvendordeals.jsp").forward(req,resp);
    }
}
