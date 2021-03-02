package com.streltsov.SV_LMS_Diploma.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final public class Feed {

    private Integer feedId;
    private final Group group;
    private List<Post> posts;

    public Feed(Group group) {
        this.group = group;
    }

    public boolean addPost(Post post) {
        if (this.posts == null) {
            this.posts = new ArrayList<>() {
            };
        }
        post.setFeed(this);
        posts.add(post);
        return true;
    }

    public boolean removePost(Post post) {
        this.posts.remove(post);
        post.setFeed(null);
        return true;
    }

    public Integer getFeedId() {
        return feedId;
    }

    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "group=" + group +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feed feed = (Feed) o;
        return group.equals(feed.group) && Objects.equals(posts, feed.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, posts);
    }

    public void setGroup(Group group) {
    }
}
