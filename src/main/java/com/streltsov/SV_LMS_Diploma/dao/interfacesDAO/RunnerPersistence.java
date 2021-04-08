package com.streltsov.SV_LMS_Diploma.dao.interfacesDAO;

import com.streltsov.SV_LMS_Diploma.domain.*;
import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RunnerPersistence {

    public static void main(String[] args) throws SQLException {

        GroupDao groupDao = new InMemoryGroupDaoImpl();
        FeedDao feedDao = new InMemoryFeedDaoImpl();
        HWTaskDao hwTaskDao = new InMemoryHomeWorkTaskDaoImpl();
        LessonDao lessonDao = new InMemoryLessonDaoImpl();
        PostDao postDao = new InMemoryPostDaoImpl();
        UserDao userDao = new InMemoryUserDaoImpl();

        Group group1 = new Group("Per Group 1", "Per Direction 1", LocalDate.now());
        Group group2 = new Group("Per Group 2", "Per Direction 2", LocalDate.now());
        Group group3 = new Group("Per Group 3", "Per Direction 3", LocalDate.now());

        User student1 = new Student("Per Stud 1 ", "Per Last Stud 1", LocalDate.of(1999, 7, 7));
        User teacher1 = new Teacher("Per Teacher 1", "Per Teach 1", LocalDate.of(1889, 8, 30), "Per role 1");
        Lesson lesson1 = new Lesson("Per Lesson 1", LocalDate.now(), "Per materials 1");
        Lesson lesson2 = new Lesson("Per Lesson 2", LocalDate.now(), "Per materials 2");
        Post post1 = new Post("Per Post 1", LocalDate.now(), "Test Author");
        Post post2 = new Post("Per Post 2", LocalDate.now(), "Nobody");
        HomeworkTask homeworkTask1 = new HomeworkTask("Per Task 1", LocalDate.now(), "Per MatTask 1", LocalDate.of(2021, 4, 23));
        HomeworkTask homeworkTask2 = new HomeworkTask("Per Task 2", LocalDate.now(), "Per MatTask 2", LocalDate.of(2021, 4, 23));

//      getAll

        List<Group> listGroupDB = groupDao.getAll();
        List<Feed> listFeedDB = feedDao.getAll();
        List<HomeworkTask> listHWorkDB = hwTaskDao.getAll();
        List<Lesson> listLessonDB = lessonDao.getAll();
        List<Post> listPostDB = postDao.getAll();
        List<User> listUserDB = userDao.getAll();

//      save user

        userDao.saveUser(student1);
        userDao.saveUser(teacher1);
        groupDao.saveGroup(group1);
        groupDao.saveGroup(group2);
        hwTaskDao.saveHWTask(homeworkTask1);
        hwTaskDao.saveHWTask(homeworkTask2);
        lessonDao.saveLesson(lesson1);
        lessonDao.saveLesson(lesson2);
        postDao.savePost(post1);
        postDao.savePost(post2);

//      get object
        Group groupGet = groupDao.getGroupById(1);
        User userGet = userDao.getUserById(2);
        HomeworkTask hwGet = hwTaskDao.getHWTaskById(1);
        Lesson lessonGet = lessonDao.getLessonById(2);
        Post postGet = postDao.getPostById(1);

//      delete user
        groupDao.deleteGroupById(1);
        userDao.deleteUserById(1);
        hwTaskDao.deleteHWTaskById(1);
        lessonDao.deleteLessonById(1);
        postDao.deletePostById(1);

//      update user
        teacher1.setFirstName("Update name teach");
        userDao.updateUser(teacher1);
        lesson2.setTopic("New topic");
        post2.setAuthor("teacher1");
        homeworkTask2.setTask("New task");
        group2.setDirection("New direction");

    }
}
