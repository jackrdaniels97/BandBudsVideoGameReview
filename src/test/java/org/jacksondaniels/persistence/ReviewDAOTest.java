package org.jacksondaniels.persistence;


import org.jacksondaniels.testUtil.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


class ReviewDAOTest {

    ReviewDao dao;

    /**
     * Set up the two tables with fresh data
     */
    @BeforeEach
    void setUp() {

        logger.info("Starting new post test");

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
     * Verifies getting all posts
     */
    @Test
    public void getAllPostsSuccess() {

    }

    /**
     * Verifies getting single post
     */
    @Test
    public void getPostByIdSuccess() {
        Review retrievedReview = dao.getById(3);
        asser
    }

    /**
     * Get post by specific user
     */
    @Test
    public void getPostsByUserIdSuccess() {

    }

    /**
     * Update post in database
     */
    @Test
    public void updatePostSuccess() {

    }

    /**
     * Verifies being able to delete post
     */
    @Test
    public void deletePostSuccess() {

    }

}