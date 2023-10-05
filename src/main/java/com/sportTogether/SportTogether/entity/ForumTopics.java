package com.sportTogether.SportTogether.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "forum_topics")
public class ForumTopics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column
    private String name ;
    @Column
    private int views ;
    @Column
    private String comment;
    @Column
    private Date last_post ;

    public ForumTopics() {
    }

    public ForumTopics(int id, String name, int views, String comment, Date last_post) {
        this.id = id;
        this.name = name;
        this.views = views;
        this.comment = comment;
        this.last_post = last_post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getLastPost() {
        return last_post;
    }

    public void setLastPost(Date lastPost) {
        this.last_post = lastPost;
    }
}
