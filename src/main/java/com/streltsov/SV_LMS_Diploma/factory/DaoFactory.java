package com.streltsov.SV_LMS_Diploma.factory;

import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.*;
import com.streltsov.SV_LMS_Diploma.domain.Homework;

public interface DaoFactory {

    UserDao getUserDao();

    PostDao getPostDao();

    LessonDao getLessonDao();

    HWDao getHomeworkDao();

    HWTaskDao getHWTaskDao();

    GroupDao getGroupDao();

    FeedDao getFeedDao();
}
