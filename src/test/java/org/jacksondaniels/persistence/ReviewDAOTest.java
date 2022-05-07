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


public class ReviewDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao<Review> reviewDao;
    GenericDao<User> userDao;

    /**
     * Set up the two tables with fresh data
     */
    @BeforeEach
    void setUp() {

        logger.info("Starting new post test");
        reviewDao = new GenericDao<>(Review.class);
        userDao = new GenericDao<>(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies insert test is working
     */
    @Test
    public void insertTest() {
        logger.info("insertTest");
        User userTest = userDao.getById(1);
        Review reviewTest = new Review("Testing", "Testing 123");
        reviewTest.setUser(userTest);

        assertEquals(5, reviewDao.getAll().size());

    }

    /**
     * Verifies getting all reviews
     */
    @Test
    public void getAllReviewsSuccess() {
        logger.info("getAllReviews");
        List<Review> reviews = reviewDao.getAll();
        assertEquals(5, reviews.size());
    }

    /**
     * Verifies getting single post
     */
    @Test
    public void getReviewByIdSuccess() {
        logger.info("in getReviewByIdSuccess");
        Review testReview = reviewDao.getById(3);
        assertEquals("Lord of the Rings Conquest", testReview.getTitle());
        assertEquals("It was cool being able to play as myself but I should have been stronger", testReview.getReview());
    }

    /**
     * Get review by specific user
     */
    @Test
    public void getReviewsByUserIdSuccess() {
        logger.info("getReviewsbyUserIdSuccess");
        User testUser = userDao.getById(2);

        List<Review> userReviews = reviewDao.getByUser(testUser);
        assertEquals(1, userReviews.size());
    }

    /**
     * Update review in database
     */
    @Test
    public void updateReviewSuccess() {
        logger.info("updateReviewSuccess");
        Review testReview = reviewDao.getById(1);
        testReview.setTitle("The Witcher 2");
        reviewDao.saveOrUpdate(testReview);

        Review updatedReview = reviewDao.getById(1);
        assertEquals("The Witcher 2", updatedReview.getTitle());
    }

    /**
     * Verifies being able to delete review
     */
    @Test
    public void deleteReviewSuccess() {
        logger.info("deleteReviewSuccess");
        Review testReview = reviewDao.getById(1);
        reviewDao.delete(testReview);

        assertEquals(4, reviewDao.getAll().size());
    }

}