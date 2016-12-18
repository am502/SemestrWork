package ru.itis.inform.servlets.vendor;

import ru.itis.inform.dao.impl.VendorDaoImpl;
import ru.itis.inform.dao.interfaces.VendorDao;
import ru.itis.inform.service.impl.VendorServiceImpl;
import ru.itis.inform.service.interfaces.VendorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artur on 13.12.2016.
 */
@WebServlet("/vendors")
public class VendorsServlet extends HttpServlet {

    VendorService vendorService = new VendorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("vendorList", vendorService.getAll());
        getServletConfig().getServletContext().getRequestDispatcher("/views/vendors.jsp").forward(req,resp);
    }
}
