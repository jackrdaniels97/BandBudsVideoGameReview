package org.jacksondaniels.controller;

import org.jacksondaniels.entity.Review;
import org.jacksondaniels.persistence.GenericDao;
import org.jacksondaniels.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Contains method for deleting post with id = * placeholder in urlPattern
 */
@WebServlet(name = "DeleteReview", urlPatterns = { "/delete_review/*" })
public class DeleteReview extends HttpServlet {
    /**
     * Called by server to allow servlet to handle a GET request
     *
     * @param req  object containing req client has made of the servlet
     * @param resp object that containing resp servlet sends to the client
     * @throws ServletException if an input or output error is detected when handling GET req
     * @throws IOException      if the request for the GET could not be handled
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int reviewId = Util.getId(req.getPathInfo());
        GenericDao<Review> reviewDao = new GenericDao<>(Review.class);

        Review reviewToDelete = reviewDao.getById(reviewId);
        reviewDao.delete(reviewToDelete);

        String url = "/viewGames";
        req.getRequestDispatcher(url).forward(req, resp);
    }
}
