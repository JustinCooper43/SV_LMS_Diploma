package com.streltsov.SV_LMS_Diploma.factory;

import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.InMemoryFeedDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.InMemoryGroupDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.InMemoryHomeWorkTaskDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.InMemoryPostDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.*;
import com.streltsov.SV_LMS_Diploma.dao.jdbcImpl.JdbcHWDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.jdbcImpl.JdbcLessonDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.jdbcImpl.JdbcUserDaoImpl;

public class JDBCFactory implements DaoFactory{
    @Override
    public UserDao getUserDao() {
        return new JdbcUserDaoImpl();
    }

    @Override
    public PostDao getPostDao() {
        return new InMemoryPostDaoImpl();
    }

    @Override
    public LessonDao getLessonDao() {
        return new JdbcLessonDaoImpl();
    }

    @Override
    public HWDao getHomeworkDao() {
        return new JdbcHWDaoImpl();
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
