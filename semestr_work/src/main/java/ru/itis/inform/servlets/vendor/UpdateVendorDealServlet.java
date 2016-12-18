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
 * Created by artur on 15.12.2016.
 */
@WebServlet("/updatevenddeal/*")
public class UpdateVendorDealServlet extends HttpServlet {

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

        getServletConfig().getServletContext().getRequestDispatcher("/views/updatevenddeal.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] pathInfo = req.getPathInfo().split("/");
        String id = pathInfo[1];

        VendorDeal vendorDeal = vendorDealService.getById(Integer.valueOf(id));

        String goodName = req.getParameter("goodName");
        if (!goodName.equals(""))
            vendorDeal.setGoodName(goodName);

        String lotSize = req.getParameter("lotSizeWholesale");
        if (!lotSize.equals(""))
            vendorDeal.setLotSizeWholesale(Integer.valueOf(lotSize));

        String price = req.getParameter("price");
        if (!price.equals(""))
            vendorDeal.setPrice(Integer.valueOf(price));

        String paymentMethod = req.getParameter("paymentMethod");
        if (!paymentMethod.equals(""))
            vendorDeal.setPaymentMethod(paymentMethod);

        String conditionsSale = req.getParameter("conditionsSale");
        if (!conditionsSale.equals(""))
            vendorDeal.setConditionsSale(conditionsSale);

        String note = req.getParameter("note");
        if (!note.equals(""))
            vendorDeal.setNote(note);

        vendorDealService.update(vendorDeal);
        resp.sendRedirect("/getvenddeals/" + id);
    }
}
