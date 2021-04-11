package com.streltsov.SV_LMS_Diploma;

import com.streltsov.SV_LMS_Diploma.dao.jdbcImpl.*;
import com.streltsov.SV_LMS_Diploma.domain.*;
import com.streltsov.SV_LMS_Diploma.utils.InitialDataJDBC;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws SQLException {

//        InitialDataJDBC initialDataJDBC = new InitialDataJDBC();
//        initialDataJDBC.createInitialData();

        JdbcUserDaoImpl jdbcUserDao = new JdbcUserDaoImpl();
        JdbcLessonDaoImpl jdbcLessonDao = new JdbcLessonDaoImpl();
        JdbcHomeWorkTaskDaoImpl jdbcHomeWorkTaskDao = new JdbcHomeWorkTaskDaoImpl();
        JdbcHWDaoImpl jdbcHWDao = new JdbcHWDaoImpl();
        JdbcFeedDaoImpl jdbcFeedDao = new JdbcFeedDaoImpl();
        JdbcPostDaoImpl jdbcPostDao = new JdbcPostDaoImpl();
        JdbcGroupDaoImpl jdbcGroupDao = new JdbcGroupDaoImpl();

        jdbcHWDao.getAll();
        Homework homeworkTest = jdbcHWDao.getHWById(3);
        homeworkTest.setMaterialsHomeWork("Test Materials");
        jdbcHWDao.deleteHWById(5);
        jdbcHWDao.updateHW(homeworkTest);

        jdbcHomeWorkTaskDao.getAll();
        HomeworkTask homeworkTaskTest = jdbcHomeWorkTaskDao.getHWTaskById(2);
        homeworkTaskTest.setTask("Test task");
        jdbcHomeWorkTaskDao.deleteHWTaskById(4);
        jdbcHomeWorkTaskDao.updateHWTask(homeworkTaskTest);

        jdbcLessonDao.getAll();
        Lesson lessonTest = jdbcLessonDao.getLessonById(7);
        lessonTest.setMaterials("Test Materials");
        jdbcLessonDao.deleteLessonById(9);
        jdbcLessonDao.updateLesson(lessonTest);

        jdbcPostDao.getAll();
        Post postTest = jdbcPostDao.getPostById(15);
        postTest.setAuthor("Test Test");
        jdbcPostDao.deletePostById(5);
        jdbcPostDao.updatePost(postTest);
        jdbcPostDao.savePost(postTest);

        jdbcFeedDao.getAll();
        Feed feedTest = jdbcFeedDao.getFeedById(2);
        feedTest.addPost(postTest);
        jdbcFeedDao.deleteFeedById(1);
        jdbcFeedDao.updateFeed(feedTest);
        jdbcFeedDao.saveFeed(feedTest);

        jdbcUserDao.getAll();
        User userTest = jdbcUserDao.getUserById(3);
        userTest.setLastName("Test");
        jdbcUserDao.deleteUserById(5);
        jdbcUserDao.updateUser(userTest);
        jdbcUserDao.saveUser(userTest);
        
        jdbcGroupDao.getAll();
        Group groupTest = jdbcGroupDao.getGroupById(2);
        groupTest.addStudent((Student) userTest);
        jdbcGroupDao.deleteGroupById(3);
        jdbcGroupDao.updateGroup(groupTest);
        jdbcGroupDao.saveGroup(groupTest);

    }

}
