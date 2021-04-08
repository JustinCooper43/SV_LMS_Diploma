package com.streltsov.SV_LMS_Diploma.dao.jdbcImpl;

import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.GroupDao;
import com.streltsov.SV_LMS_Diploma.domain.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcGroupDaoImpl implements GroupDao {

    private final Connection connect = ConnectionSingle.getConnectionToAll();

    private final JdbcLessonDaoImpl jdbcLessonDao = new JdbcLessonDaoImpl();
    private final JdbcUserDaoImpl jdbcUserDao = new JdbcUserDaoImpl();
    private final JdbcFeedDaoImpl jdbcFeedDao = new JdbcFeedDaoImpl();
    private final JdbcPostDaoImpl jdbcPostDao = new JdbcPostDaoImpl();

    @Override
    public List<Group> getAll() throws SQLException {

        Statement statementGroups = null;
        String queryLesson = "SELECT groupId FROM groups;";

        List<Group> resultListOfGroups = new ArrayList<>();
        try {
            statementGroups = connect.createStatement();
            if (statementGroups.execute(queryLesson)) {
                ResultSet resultLesson = statementGroups.executeQuery(queryLesson);
                while (resultLesson.next()) {
                    long groupId = resultLesson.getLong(1);
                    resultListOfGroups.add(getGroupById(groupId));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementGroups != null;
            statementGroups.close();
        }
        return resultListOfGroups;
    }

    @Override
    public boolean saveGroup(Group group) throws SQLException {
        String name = group.getName();
        String direction = group.getDirection();
        LocalDate startDate = group.getStartDate();
        List<Student> studentList = group.getStudents();
        List<Teacher> teacherList = group.getTeachers();
        List<Lesson> lessonsList = group.getLessons();
        Feed feed = group.getFeed();

        PreparedStatement statement = null;
        String query = "INSERT INTO groups (name, direction, startDate) VALUES (?, ?, ?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, direction);
            statement.setDate(3, Date.valueOf(startDate));
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        for (Lesson varLesson : lessonsList) {
            jdbcLessonDao.saveLesson(varLesson);
        }
        for (Student varStudent : studentList) {
            jdbcUserDao.saveUser(varStudent);
        }
        for (Teacher varTeacher : teacherList) {
            jdbcUserDao.saveUser(varTeacher);
        }
        jdbcFeedDao.saveFeed(feed);
        return true;
    }

    @Override
    public Group getGroupById(long groupId) throws SQLException {
        PreparedStatement statementGroup = null;
        PreparedStatement statementStudent;
        PreparedStatement statementTeacher;
        PreparedStatement statementLessons;
        PreparedStatement statementListPosts;
        String queryGroup = "SELECT name,direction,startDate FROM groups WHERE groupId = ?;";
        String queryStudent = "SELECT userId FROM users WHERE groupId = ? AND role = 'STUDENT';";
        String queryTeacher = "SELECT userId FROM users WHERE groupId = ? AND role = 'TEACHER';";
        String queryLessons = "SELECT lessonId FROM lessons WHERE lessonId = ?;";
        String queryListPosts = "SELECT postId FROM posts WHERE feedId = ?";

        List<Student> studentListForNewGroup = new ArrayList<>();
        List<Lesson> lessonListForNewGroup = new ArrayList<>();
        List<Teacher> teacherListForNewGroup = new ArrayList<>();
        List<Post> listPosts = new ArrayList<>();
        Group newGroup = null;
        try {
            statementStudent = connect.prepareStatement(queryStudent);
            statementStudent.setLong(1, groupId);
            if (statementStudent.execute()) {
                ResultSet resultStud = statementStudent.executeQuery();
                while (resultStud.next()) {
                    long studentId = resultStud.getLong(1);
                    User studentForGroup = jdbcUserDao.getUserById(studentId);
                    studentListForNewGroup.add((Student) studentForGroup);
                }
            }

            statementTeacher = connect.prepareStatement(queryTeacher);
            statementTeacher.setLong(1, groupId);
            if (statementTeacher.execute()) {
                ResultSet resultTeach = statementTeacher.executeQuery();
                while (resultTeach.next()) {
                    long teachId = resultTeach.getLong(1);
                    User teacherForGroup = jdbcUserDao.getUserById(teachId);
                    teacherListForNewGroup.add((Teacher) teacherForGroup);
                }
            }
            statementLessons = connect.prepareStatement(queryLessons);
            statementLessons.setLong(1, groupId);
            if (statementLessons.execute()) {
                ResultSet resultLesson = statementLessons.executeQuery();
                while (resultLesson.next()) {
                    long lessonId = resultLesson.getLong(1);
                    Lesson lessonForGroup = jdbcLessonDao.getLessonById(lessonId);
                    lessonListForNewGroup.add(lessonForGroup);
                }
            }

            statementListPosts = connect.prepareStatement(queryListPosts);
            statementListPosts.setLong(1, groupId);
            if (statementListPosts.execute()) {
                ResultSet resultListPosts = statementListPosts.executeQuery();
                while (resultListPosts.next()) {
                    long postId = resultListPosts.getLong(1);
                    Post postForListPosts = jdbcPostDao.getPostById(postId);
                    listPosts.add(postForListPosts);
                }
            }
            statementGroup = connect.prepareStatement(queryGroup);
            statementGroup.setLong(1, groupId);
            if (statementGroup.execute()) {
                ResultSet resultGroup = statementGroup.executeQuery();
                while (resultGroup.next()) {
                    String nameForNewGroup = resultGroup.getString(1);
                    String directionForNewGroup = resultGroup.getString(2);
                    LocalDate startDateForNewGroup = resultGroup.getDate(3).toLocalDate();
                    newGroup = new Group(nameForNewGroup, directionForNewGroup, startDateForNewGroup,
                            studentListForNewGroup, lessonListForNewGroup, null);
                    newGroup.setGroupId(groupId);
                    newGroup.setTeachers(teacherListForNewGroup);
                }
            }
            newGroup.getFeed().setFeedId(groupId);
            newGroup.getFeed().setPosts(listPosts);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementGroup != null;
            statementGroup.close();
        }
        return newGroup;
    }

    @Override
    public boolean updateGroup(Group group) throws SQLException {

        Long groupId = group.getGroupId();
        String name = group.getName();
        String direction = group.getDirection();
        LocalDate startDate = group.getStartDate();
        List<Student> studentList = group.getStudents();
        List<Teacher> teacherList = group.getTeachers();
        List<Lesson> lessonsList = group.getLessons();
        Feed feed = group.getFeed();

        PreparedStatement statement = null;
        String query = "UPDATE groups SET name = ? ,direction = ?,startDate = ? WHERE groupId = ?;";
        try {
            statement = connect.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, direction);
            statement.setDate(3, Date.valueOf(startDate));
            statement.setLong(4, groupId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        for (Lesson varLesson : lessonsList) {
            jdbcLessonDao.updateLesson(varLesson);
        }
        for (Student varStudent : studentList) {
            jdbcUserDao.updateUser(varStudent);
        }
        for (Teacher varTeacher : teacherList) {
            jdbcUserDao.updateUser(varTeacher);
        }
        jdbcFeedDao.updateFeed(feed);
        return true;
    }

    @Override
    public boolean deleteGroupById(long groupId) throws SQLException {
        PreparedStatement statementGroup = null;
        PreparedStatement statementLesson;
        PreparedStatement statementUser;
        PreparedStatement statementFeed;
        String queryGroup = "DELETE FROM groups WHERE groupId = ?";
        String queryLesson = "SELECT lessonId FROM lessons WHERE groupId = ?";
        String queryUser = "SELECT userId FROM users WHERE groupId = ?";
        String queryFeed = "SELECT feedId FROM feeds WHERE groupId = ?";

        try {
            statementLesson = connect.prepareStatement(queryLesson);
            statementLesson.setLong(1, groupId);
            if (statementLesson.execute()) {
                ResultSet resultLessons = statementLesson.executeQuery();
                while (resultLessons.next()) {
                    long lessonId = resultLessons.getLong(1);
                    jdbcLessonDao.deleteLessonById(lessonId);
                }
            }
            statementUser = connect.prepareStatement(queryUser);
            statementUser.setLong(1, groupId);
            if (statementUser.execute()) {
                ResultSet resultUsers = statementUser.executeQuery();
                while (resultUsers.next()) {
                    long userId = resultUsers.getLong(1);
                    jdbcUserDao.deleteUserById(userId);
                }
            }
            statementFeed = connect.prepareStatement(queryFeed);
            statementFeed.setLong(1, groupId);
            if (statementFeed.execute()) {
                ResultSet resultFeed = statementFeed.executeQuery();
                while (resultFeed.next()) {
                    long feedId = resultFeed.getLong(1);
                    jdbcFeedDao.deleteFeedById(feedId);
                }
            }
            statementGroup = connect.prepareStatement(queryGroup);
            statementGroup.setLong(1, groupId);
            statementGroup.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementGroup != null;
            statementGroup.close();
        }
        return true;
    }
}
