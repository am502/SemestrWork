package ru.itis.inform.servlets.customer;

import ru.itis.inform.service.impl.CustomerServiceImpl;
import ru.itis.inform.service.interfaces.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artur on 13.12.2016.
 */
@WebServlet("/customers")
public class CustomersServlet extends HttpServlet {

    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customerList", customerService.getAll());
        getServletConfig().getServletContext().getRequestDispatcher("/views/customers.jsp").forward(req,resp);
    }
}
