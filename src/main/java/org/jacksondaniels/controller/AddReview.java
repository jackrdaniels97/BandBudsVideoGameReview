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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

/**
 *  Contains method for creating a new review
 */
@WebServlet(name = "AddReview", urlPatterns = { "/add_review" })
public class AddReview extends HttpServlet  {
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
        // get userName and email that from cognito, stored in session
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");

        GenericDao<Review> reviewDao = new GenericDao<>(Review.class);

        Review newReview = new Review();
        newReview.setTitle(req.getParameter("title"));
        newReview.setReview(req.getParameter("review"));
        newReview.setUser(Util.getUser(userName));

        //get id of review and go to that review page

        int newReviewID = reviewDao.insert(newReview);
        req.setAttribute("reviewId", newReviewID);
        String url = "/viewReview.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
