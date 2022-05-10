package org.jacksondaniels.util;

import org.jacksondaniels.entity.User;
import org.jacksondaniels.persistence.GenericDao;

import java.util.List;

/**
 * Contains utility functions used in app
 */
public class Util {
    /**
     * Returns the id in url
     *
     * @param pathInfo the url path info containing a user or review id
     * @return just the id part of path
     */
    public static int getId(String pathInfo) {
        // grab everything  in url
        return Integer.parseInt(pathInfo.substring(1));
    }

    /**
     * Returns a user object when passed a username string
     *
     * @param username a user's username
     * @return the User object associated with that username
     */
    public static User getUser(String username) {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        List<User> users = userDao.findByPropertyEqual("username", username);
        return users.get(0);
    }


}