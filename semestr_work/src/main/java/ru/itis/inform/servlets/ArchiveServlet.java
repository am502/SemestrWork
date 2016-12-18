package ru.itis.inform.servlets;

import ru.itis.inform.service.impl.ArchiveServiceImpl;
import ru.itis.inform.service.interfaces.ArchiveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artur on 17.12.2016.
 */
@WebServlet("/archive")
public class ArchiveServlet extends HttpServlet {

    ArchiveService archiveService = new ArchiveServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("archive", archiveService.getAll());
        getServletConfig().getServletContext().getRequestDispatcher("/views/archive.jsp").forward(req,resp);
    }
}
