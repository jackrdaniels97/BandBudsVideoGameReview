package org.jacksondaniels.persistence;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacksondaniels.entity.Review;
import org.jacksondaniels.entity.User;
import org.jacksondaniels.testUtil.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type User test.
 */
public class UserTest {

    /**
     * The User dao.
     */
    GenericDao userDao;
    /**
     * The Review dao.
     */
    GenericDao reviewDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        logger.info("setting up new user test");
        userDao = new GenericDao<User>(User.class);
        reviewDao = new GenericDao<Review>(Review.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Gets all users success.
     */
    @Test
    public void getAllUsersSuccess() {
        logger.info("in getAllUsersSuccess");
        List<User> users = userDao.getAll();
        assertEquals(4, users.size());
    }

    /**
     * Gets user by id success.
     */
    @Test
    public void getUserByIdSuccess() {
        logger.info("in getUserByIdSuccess");
        User user1 = (User) userDao.getById(1);
        assertEquals("Jackson", user1.getFirstName());
    }

    /**
     * Gets user from post success.
     */
    @Test
    public void getUserFromPostSuccess() {
        Review review1 = (Review) reviewDao.getById(1);
        assertEquals("Jackson", review1.getUser().getFirstName());
    }
}
