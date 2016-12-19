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
import java.util.List;

/**
 * Created by artur on 16.12.2016.
 */
@WebServlet("/updatevendor")
public class UpdateVendorServlet extends HttpServlet {

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

        getServletConfig().getServletContext().getRequestDispatcher("/views/updatevendor.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));
        Vendor vendor = vendorService.getByUserId(user.getUserId());

        String phone = req.getParameter("phone");

        if (phone.equals(vendor.getPhoneNumber()))
            phone = "";

        if (userService.verifyCustomerPhoneExistence(req.getParameter("phone")) || userService.verifyVendorPhoneExistence(req.getParameter("phone"))) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/incorrectphone.jsp").forward(req, resp);
            return;
        }

        String firstname = req.getParameter("firstName");
        if (!firstname.equals(""))
            user.setFirstName(firstname);

        String lastName = req.getParameter("lastName");
        if (!lastName.equals(""))
            user.setLastName(lastName);

        if (!phone.equals(""))
            vendor.setPhoneNumber(phone);

        userService.update(user);
        vendor.setUser(user);
        vendorService.update(vendor);

        List<VendorDeal> list = vendorDealService.getByVendorId(vendor.getVendorId());
        for (VendorDeal deal: list) {
            deal.setVendor(vendor);
            deal.setPhoneNumber(phone);
            vendorDealService.update(deal);
        }

        resp.sendRedirect("/profile");
    }
}
