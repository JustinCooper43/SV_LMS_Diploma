package com.streltsov.SV_LMS_Diploma.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private Integer postId;
    private Feed feed;
    private String text;
    private LocalDate datePosted;
    private String author;

    public Post(String text, LocalDate datePosted,String author) {
        this.text = text;
        this.datePosted = datePosted;
        this.author = author;
    }

    public void setFeed( Feed feed) {
        this.feed = feed;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public Integer getPostId() {
        return postId;
    }

    public Feed getFeed() {
        return feed;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post {" +
                ", feed=" + feed +
                ", datePosted=" + datePosted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId && Objects.equals(feed, post.feed) && text.equals(post.text) && datePosted.equals(post.datePosted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, feed, text, datePosted);
    }
}
