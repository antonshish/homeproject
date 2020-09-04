package ru.homeproject.city.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.homeproject.city.dao.DirectConnectionBuilder;
import ru.homeproject.city.dao.PersonCheckDao;
import ru.homeproject.city.dao.PoolConnectionBuilder;
import ru.homeproject.city.domain.PersonRequest;
import ru.homeproject.city.domain.PersonResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(CheckPersonServlet.class);

    private PersonCheckDao dao;

    @Override
    public void init() throws ServletException {
        logger.info("SERVLET is created");
        dao = new PersonCheckDao();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        PersonRequest pr = new PersonRequest();
        pr.setSurName(req.getParameter("surname"));
        pr.setGivenName(req.getParameter("givenname"));
        pr.setPatronymic(req.getParameter("patronymic"));
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        pr.setDateOfBirth(dateOfBirth);
        pr.setStreetCode(Integer.parseInt((req.getParameter("streetCode"))));
        pr.setBuilding(req.getParameter("building"));
        pr.setExtension(req.getParameter("extension"));
        pr.setApartment(req.getParameter("apartment"));

        dao = new PersonCheckDao();

        try {
            PersonResponse ps = dao.checkPerson(pr);
            if(ps.isRegistered())
                resp.getWriter().write("Registered");
            else
                resp.getWriter().write("Not registered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
