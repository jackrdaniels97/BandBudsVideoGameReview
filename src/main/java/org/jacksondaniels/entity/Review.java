package org.jacksondaniels.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

/**
 * The type Review.
 */
@Entity(name = "Review")
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "review")
    private String review;

    @ManyToOne
    @JoinColumn(name = "reviewer_id", foreignKey = @ForeignKey(name = "fk_reviews_id"))
    private User user;

    /**
     * No arg constructor
     */
    public Review() {
    }



    /**
     * Instantiates a new Review.
     *
     * @param title  the title
     * @param review the review
     * @param user   the user
     */
    public Review(String title, String review, User user) {
        this.title = title;
        this.review = review;
        this.user = user;
    }

    /**
     * Instantiates a new Review.
     *
     * @param title  the title
     * @param review the review
     */
    public Review(String title, String review) {
        this.title = title;
        this.review = review;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets review.
     *
     * @param review the review
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets review.
     *
     * @return the review
     */
    public String getReview() {
        return review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", review='" + review + '\'' +
                ", user=" + user +
                '}';
    }
}
