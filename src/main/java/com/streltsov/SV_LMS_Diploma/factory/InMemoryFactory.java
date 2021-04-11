package com.streltsov.SV_LMS_Diploma.factory;

import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.*;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.*;

public class InMemoryFactory implements DaoFactory{

    @Override
    public UserDao getUserDao() {
        return new InMemoryUserDaoImpl();
    }

    @Override
    public PostDao getPostDao() {
        return new InMemoryPostDaoImpl();
    }

    @Override
    public LessonDao getLessonDao() {
        return new InMemoryLessonDaoImpl();
    }

    @Override
    public HWDao getHomeworkDao() {
        return new InMemoryHWDaoImpl();
    }

    @Override
    public HWTaskDao getHWTaskDao() {
        return new InMemoryHomeWorkTaskDaoImpl();
    }

    @Override
    public GroupDao getGroupDao() {
        return new InMemoryGroupDaoImpl();
    }

    @Override
    public FeedDao getFeedDao() {
        return new InMemoryFeedDaoImpl();
    }
}
