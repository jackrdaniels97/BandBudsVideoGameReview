package org.jacksondaniels.controller;


import org.jacksondaniels.entity.Review;
import org.jacksondaniels.persistence.GenericDao;
import org.jacksondaniels.util.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *  Contains method for displaying a page where user can edit review with id = * placeholder
 */
@WebServlet(name = "EditReview", urlPatterns = { "/editReview/*" })
public class EditReview extends HttpServlet {
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
        int id_reviews = Util.getId(req.getPathInfo());
        GenericDao<Review> reviewDao = new GenericDao<>(Review.class);

        Review reviewUpdate = reviewDao.getById(id_reviews);

        req.setAttribute("review", reviewUpdate);

        String url = "/updateReview.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
