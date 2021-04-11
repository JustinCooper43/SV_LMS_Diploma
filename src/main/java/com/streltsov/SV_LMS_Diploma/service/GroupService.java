package com.streltsov.SV_LMS_Diploma.service;

import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.InMemoryFeedDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.InMemoryGroupDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.FeedDao;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.GroupDao;
import com.streltsov.SV_LMS_Diploma.domain.*;

import java.sql.SQLException;
import java.util.List;

public class GroupService {

    private final GroupDao groupDao = new InMemoryGroupDaoImpl();
    LessonService lessonService = new LessonService();
    UserService userService = new UserService();
    FeedDao feedDao = new InMemoryFeedDaoImpl();

    public boolean saveGroupInMemory(Group group) throws SQLException {
        List<Student> studentList = group.getStudents();
        List<Teacher> teacherList = group.getTeachers();
        List<Lesson> lessonList = group.getLessons();
        Feed feed = group.getFeed();

        groupDao.saveGroup(group);
        for (Lesson varLesson : lessonList) {
            lessonService.saveLessonInMemory(varLesson);
        }
        for (Teacher teacher : teacherList) {
            userService.saveUserInMemory(teacher);
        }

        for (Student student : studentList) {
            userService.saveUserInMemory(student);
        }
        feedDao.saveFeed(feed);
        return true;
    }

    public boolean updateGroupInMemory(Group group) throws SQLException {
        List<Student> studentList = group.getStudents();
        List<Teacher> teacherList = group.getTeachers();
        List<Lesson> lessonList = group.getLessons();
        Feed feed = group.getFeed();

        groupDao.updateGroup(group);
        for (Lesson varLesson : lessonList) {
            lessonService.updateLessonInMemory(varLesson);
        }
        for (Teacher teacher : teacherList) {
            userService.updateUserInMemory(teacher);
        }

        for (Student student : studentList) {
            userService.updateUserInMemory(student);
        }
        feedDao.updateFeed(feed);
        return true;
    }

    public boolean deleteGroupInMemory(Group group) throws SQLException {
        long groupId = group.getGroupId();
        List<Student> studentList = group.getStudents();
        List<Teacher> teacherList = group.getTeachers();
        List<Lesson> lessonList = group.getLessons();
        long feedId = group.getFeed().getFeedId();

        groupDao.deleteGroupById(groupId);
        for (Lesson varLesson : lessonList) {
            lessonService.deleteLessonInMemory(varLesson);
        }
        for (Teacher varTeacher : teacherList) {
            userService.deleteUserInMemory(varTeacher);
        }

        for (Student varStudent : studentList) {
            userService.deleteUserInMemory(varStudent);
        }
        feedDao.deleteFeedById(feedId);
        return true;
    }
}
