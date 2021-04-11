package com.streltsov.SV_LMS_Diploma.dao.interfacesDAO;

import com.streltsov.SV_LMS_Diploma.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Persistence {

    private final List<Group> groupsDB;
    private final List<Lesson> lessonsDB;
    private final List<Post> postsDB;
    private final List<HomeworkTask> hwTasksDB;
    private final List<User> userDB;
    private final List<Feed> feedDB;
    private final List<Homework> hwDB;

    private Persistence() {
        this.groupsDB = new ArrayList<>();
        this.lessonsDB = new ArrayList<>();
        this.postsDB = new ArrayList<>();
        this.hwTasksDB = new ArrayList<>();
        this.userDB = new ArrayList<>();
        this.feedDB = new ArrayList<>();
        this.hwDB = new ArrayList<>();
    }

    public List<Group> getGroupsDB() {
        return groupsDB;
    }

    public List<Lesson> getLessonsDB() {
        return lessonsDB;
    }

    public List<Post> getPostsDB() {
        return postsDB;
    }

    public List<HomeworkTask> getHwTasksDB() {
        return hwTasksDB;
    }

    public List<User> getUserDB() {
        return userDB;
    }

    public List<Feed> getFeedDB() {
        return feedDB;
    }

    public List<Homework> getHwDB() {
        return hwDB;
    }

    public static <T> long getNewId(List<T> generalList) {
        return generalList.size() + 1;
    }

    public static Persistence getInstance() {
        return PersistenceHolder.instance;
    }

    private static class PersistenceHolder {
        private static final Persistence instance = new Persistence();
    }
}
