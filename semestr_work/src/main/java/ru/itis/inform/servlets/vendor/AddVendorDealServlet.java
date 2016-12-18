package ru.itis.inform.servlets.vendor;

import ru.itis.inform.models.User;
import ru.itis.inform.models.Vendor;
import ru.itis.inform.models.VendorDeal;
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
@WebServlet("/addvenddeal")
public class AddVendorDealServlet extends HttpServlet {

    VendorDealService vendorDealService = new VendorDealServiceImpl();

    UserService userService = new UserServiceImpl();

    VendorService vendorService = new VendorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        if (userService.isCustomer(user.getUserId())) {
            resp.sendRedirect("/error");
            return;
        }

        getServletConfig().getServletContext().getRequestDispatcher("/views/addvenddeal.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));
        Vendor vendor = vendorService.getByUserId(user.getUserId());

        VendorDeal vendorDeal = new VendorDeal.Builder()
                .vendor(vendor)
                .goodName(req.getParameter("goodName"))
                .lotSizeWholesale(Integer.valueOf(req.getParameter("lotSizeWhole")))
                .price(Integer.valueOf(req.getParameter("price")))
                .phoneNumber(vendor.getPhoneNumber())
                .paymentMethod(req.getParameter("paymentMethod"))
                .conditionsSale(req.getParameter("conditionsSale"))
                .note(req.getParameter("note"))
                .build();

        vendorDealService.insert(vendorDeal);
        resp.sendRedirect("/yourvendordeals");
    }
}
