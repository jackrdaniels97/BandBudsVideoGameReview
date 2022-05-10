package org.jacksondaniels.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacksondaniels.entity.Review;
import org.jacksondaniels.entity.User;
import org.jacksondaniels.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/viewProfile"})

/**
 *  Page for profile
 */
public class ViewProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Review> reviewDao = new GenericDao<>(Review.class);
        User users = (User) req.getSession().getAttribute("user");


        List<Review> userReviews = reviewDao.getByUser(users);
        req.setAttribute("reviews", userReviews);
//
//        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req, resp);
    }

}