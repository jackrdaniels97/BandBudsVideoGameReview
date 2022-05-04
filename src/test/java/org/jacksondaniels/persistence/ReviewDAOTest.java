package org.jacksondaniels.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacksondaniels.entity.Review;
import org.jacksondaniels.entity.User;
import org.jacksondaniels.testUtil.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ReviewDAOTest {

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


    }

    /**
     * Verifies getting all reviews
     */
    @Test
    public void getAllReviewsSuccess() {

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
        assertEquals(3, testReview.getUser());
    }

    /**
     * Get review by specific user
     */
    @Test
    public void getReviewsByUserIdSuccess() {

    }

    /**
     * Update review in database
     */
    @Test
    public void updateReviewSuccess() {

    }

    /**
     * Verifies being able to delete review
     */
    @Test
    public void deleteReviewSuccess() {

    }

}