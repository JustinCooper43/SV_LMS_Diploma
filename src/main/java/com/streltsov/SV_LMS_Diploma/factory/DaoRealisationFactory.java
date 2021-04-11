package com.streltsov.SV_LMS_Diploma.factory;

import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.*;
import com.streltsov.SV_LMS_Diploma.domain.HomeworkTask;

public class DaoRealisationFactory {

    private final GroupDao groupDao;
    private final UserDao userDao;
    private final LessonDao lessonDao;
    private final HWTaskDao hwTaskDao;
    private final HWDao hwDao;
    private final FeedDao feedDao;
    private final PostDao postDao;

    public DaoRealisationFactory (String getOptionValue) {
        DaoFactory daoFactory;
        if (getOptionValue.equalsIgnoreCase("JDBC")) {
            daoFactory = new JDBCFactory();
        } else {
            daoFactory = new InMemoryFactory();
        }
        this.groupDao = daoFactory.getGroupDao();
        this.userDao = daoFactory.getUserDao();
        this.lessonDao = daoFactory.getLessonDao();
        this.hwTaskDao = daoFactory.getHWTaskDao();
        this.hwDao = daoFactory.getHomeworkDao();
        this.feedDao = daoFactory.getFeedDao();
        this.postDao = daoFactory.getPostDao();
    }

    public GroupDao getGroupDao() {
        return groupDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public LessonDao getLessonDao() {
        return lessonDao;
    }

    public HWTaskDao getHwTaskDao() {
        return hwTaskDao;
    }

    public HWDao getHwDao() {
        return hwDao;
    }

    public FeedDao getFeedDao() {
        return feedDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }
}
