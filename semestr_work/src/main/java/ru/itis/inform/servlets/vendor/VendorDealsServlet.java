package ru.itis.inform.servlets.vendor;

import ru.itis.inform.dao.impl.VendorDealDaoImpl;
import ru.itis.inform.dao.interfaces.VendorDealDao;
import ru.itis.inform.models.User;
import ru.itis.inform.service.impl.UserServiceImpl;
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
@WebServlet("/vendordeals")
public class VendorDealsServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    VendorDealDao vendorDealDao = new VendorDealDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByUsername((String) req.getSession().getAttribute("session_username"));

        if (!userService.isCustomer(user.getUserId())) {
            getServletConfig().getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("vendorDealList", vendorDealDao.getAll());
        getServletConfig().getServletContext().getRequestDispatcher("/views/vendordeals.jsp").forward(req,resp);
    }
}
