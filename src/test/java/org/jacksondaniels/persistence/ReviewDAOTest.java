package org.jacksondaniels.persistence;

import org.jacksondaniels.testUtil.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.jacksondaniels.entity.Review;
import org.jacksondaniels.entity.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


class ReviewDAOTest {
    GenericDao<Review> reviewDao;
    GenericDao<User> userDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        logger.info("Starting new post test");
        reviewDao = new GenericDao<>(Review.class);
        userDao = new GenericDao<>(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    public void insertTest() {
        User user1 = userDao.getById(1);
        Review testReview = new Review("Test title", "post content here");
        testReview.setUser(user1);

        assertEquals(5, reviewDao.getAll().size());
    }

    @Test
    public void getAllPostsSuccess() {
        logger.info("in getAllPostsSuccess");
        List<Review> posts = reviewDao.getAll();
        assertEquals(5, posts.size());
    }

    @Test
    public void getPostByIdSuccess() {
        logger.info("in getPostByIdSuccess");
        Review testPost = reviewDao.getById(1);
        assertEquals("The Witcher 3", testPost.getTitle());
        assertEquals("One of the best games to ever get. Some of the best game play and story that has ever graced us. ", testPost.getReview());
    }

    @Test
    public void getPostsByUserIdSuccess() {
        logger.info("in getPostsByUserIdSuccess");
        User user4 = userDao.getById(4);

        List<Review> userReview = reviewDao.getByUser(user4);
        assertEquals(1, userReview.size());
    }

    @Test
    public void updatePostSuccess() {
        Review testReview = reviewDao.getById(1);
        testReview.setTitle("new title");
        reviewDao.saveOrUpdate(testReview);

        Review editedReview = reviewDao.getById(1);
        assertEquals("new title1", editedReview.getTitle());
    }

    @Test
    public void deletePostSuccess() {
        logger.info("in deletePostSuccess");
        Review testReview = reviewDao.getById(1);
        reviewDao.delete(testReview);

        assertEquals(5, reviewDao.getAll().size());
    }
}
