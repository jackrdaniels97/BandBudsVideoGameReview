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
import java.util.Set;

/**
 *  Contains method for updating post with id = * placeholder
 */
@WebServlet(name = "UpdateReview", urlPatterns = { "/update_review/*" })
public class UpdateReview extends HttpServlet {
    /**
     * Called by server to allow servlet to handle a POST request
     *
     * @param req               object containing req client has made of the servlet
     * @param resp              object that containing resp servlet sends to the client
     * @throws ServletException if an input or output error is detected when handling GET req
     * @throws IOException      if the request for the GET could not be handled
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int reviewId = Util.getId(req.getPathInfo());
        GenericDao<Review> reviewDao = new GenericDao<>(Review.class);

        Review reviewToUpdate = reviewDao.getById(reviewId); // fetch post with id

        // get updated form fields from
        reviewToUpdate.setTitle(req.getParameter("title"));
        reviewToUpdate.setReview(req.getParameter("review"));


        reviewDao.saveOrUpdate(reviewToUpdate);

        req.setAttribute("review", reviewToUpdate);
        String url = "/reviewUpdated.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}