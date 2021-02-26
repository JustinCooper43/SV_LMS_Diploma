package com.streltsov.SV_LMS_Diploma.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private long idPost;
    private Class<? extends Feed> feed;
    private String text;
    private LocalDate datePosted;

    public Post(String text, LocalDate datePosted) {
        this.text = text;
        this.datePosted = datePosted;
    }

    public void setFeed(Class<? extends Feed> feed) {
        this.feed = feed;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public long getIdPost() {
        return idPost;
    }

    public Class<? extends Feed> getFeed() {
        return feed;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", feed=" + feed +
                ", text='" + text + '\'' +
                ", datePosted=" + datePosted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return idPost == post.idPost && Objects.equals(feed, post.feed) && text.equals(post.text) && datePosted.equals(post.datePosted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPost, feed, text, datePosted);
    }
}
