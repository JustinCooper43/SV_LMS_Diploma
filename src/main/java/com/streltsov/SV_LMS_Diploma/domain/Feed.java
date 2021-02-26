package com.streltsov.SV_LMS_Diploma.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final public class Feed {

    private Class<? extends Group> group;
    private List<Post> posts;

    public Feed() {
    }

    public boolean addPost(Post post) {
        if (this.posts == null) {
            this.posts = new ArrayList<>() {
            };
        }
        post.setFeed(this.getClass());
        posts.add(post);
        return true;
    }

    public boolean removePost(Post post) {
        this.posts.remove(post);
        post.setFeed(null);
        return true;
    }

    public void setGroup(Class<? extends Group> group) {
        this.group = group;
    }

    public Class<? extends Group> getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "group=" + group +
                ", posts=" + posts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feed feed = (Feed) o;
        return group.equals(feed.group) && posts.equals(feed.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, posts);
    }
}
