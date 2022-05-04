package org.jacksondaniels.controller;

import org.jacksondaniels.entity.Review;
import org.jacksondaniels.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *  Contains method for displaying all blog posts
 */
@WebServlet(name = "AllReviews", urlPatterns = { "/viewsGames" })
public class AllReviews extends HttpServlet {
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
        String url = "/viewsGames.jsp";
        GenericDao<Review> reviewDao = new GenericDao<>(Review.class);

        // get all posts, reverse the list so newest are displayed first
        List<Review> reviews = reviewDao.getAll();

        req.setAttribute("reviews", reviews);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}