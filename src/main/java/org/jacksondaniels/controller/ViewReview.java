package org.jacksondaniels.controller;


import org.jacksondaniels.entity.Review;
import org.jacksondaniels.entity.User;
import org.jacksondaniels.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Displays the review with id_reviews = * placeholder in URL
 */
@WebServlet(name = "ViewReview", urlPatterns = { "/reviews/*" })
public class ViewReview extends HttpServlet {

    /**
     * Called by server to allow servlet to handle a GET request
     *
     * @param req               object containing req client has made of the servlet
     * @param resp              object that containing resp servlet sends to the client
     * @throws ServletException if an input or output error is detected when handling GET req
     * @throws IOException      if the request for the GET could not be handled
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Review> reviewDao = new GenericDao<>(Review.class);

        String pathInfo = req.getPathInfo();
        int id_reviews = Integer.parseInt(pathInfo.substring(1));
        Review reviews = reviewDao.getById(id_reviews);

        req.setAttribute("review", reviews);
        String url = "/viewReview.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
