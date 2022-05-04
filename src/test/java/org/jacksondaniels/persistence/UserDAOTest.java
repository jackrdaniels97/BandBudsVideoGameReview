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

public class UserDAOTest {
    GenericDao<User> userDao;
    GenericDao<Review> reviewDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        logger.info("setting up new user test");
        userDao = new GenericDao<>(User.class);
        reviewDao = new GenericDao<>(Review.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    public void getAllUsersSuccess() {
        logger.info("getAllUsersSuccess");
        List<User> users = userDao.getAll();
        assertEquals(4, users.size());
    }

    @Test
    public void getUserByIdSuccess() {
        logger.info("getUserByIdSuccess");
        User user1 = userDao.getById(1);
        assertEquals("Jackson", user1.getFirstName());
    }

    @Test
    public void getUserFromPostSuccess() {
        Review review1 = reviewDao.getById(1);
        assertEquals("Jackson", review1.getUser().getFirstName());
        assertEquals("Daniels", review1.getUser().getLastName());
    }


    @Test void createUserSuccess() {
        User newUser = new User();
        newUser.setFirstName("Geralt");
        newUser.setLastName("of Rivia");

        int id = userDao.insert(newUser);
        User insertedUser = userDao.getById(id);

        assertEquals("Geralt", insertedUser.getFirstName());
        List<User> users = userDao.getAll();
        assertEquals(5, users.size());
    }

    @Test void fetchUserByIdAndUpdateSuccess() {
        User user1 = userDao.getById(1);
        user1.setFirstName("Geralt");
        user1.setLastName("of Rivia");
        user1.setEmail("butcherOfBlavakan@novigrad.org");

        userDao.saveOrUpdate(user1);

        assertEquals("Geralt", user1.getFirstName());
        assertEquals("of Rivia", user1.getLastName());
        assertEquals("butcherOfBlavakan@novigrad.org", user1.getEmail());
    }

}
