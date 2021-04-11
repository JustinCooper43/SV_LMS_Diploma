package com.streltsov.SV_LMS_Diploma.dao.jdbcImpl;

import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.LessonDao;
import com.streltsov.SV_LMS_Diploma.domain.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcLessonDaoImpl implements LessonDao {

    private final Connection connect = ConnectionSingle.getConnectionToAll();
    private final JdbcHomeWorkTaskDaoImpl jdbcHomeWorkTaskDao = new JdbcHomeWorkTaskDaoImpl();

    @Override
    public List<Lesson> getAll() throws SQLException {

        java.sql.Statement statementLesson = null;
        String queryLesson = "SELECT lessonId FROM lessons;";

        List<Lesson> resultListOfLessons = new ArrayList<>();

        try {
            statementLesson = connect.createStatement();
            if (statementLesson.execute(queryLesson)) {
                ResultSet resultLesson = statementLesson.executeQuery(queryLesson);
                while (resultLesson.next()) {
                    long lessonId = resultLesson.getLong(1);
                    resultListOfLessons.add(getLessonById(lessonId));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementLesson != null;
            statementLesson.close();
        }
        return resultListOfLessons;
    }

    @Override
    public boolean saveLesson(Lesson lesson) throws SQLException {

        Long groupId = lesson.getGroup().getGroupId();
        String topic = lesson.getTopic();
        LocalDate lessonDate = lesson.getDate();
        String materials = lesson.getMaterials();
        List<HomeworkTask> homeworkTaskList = lesson.getHwTasks();

        PreparedStatement statement = null;
        String query = "INSERT INTO lessons (groupId, topic, materials, lessonDate) VALUES (?, ?, ?, ?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setLong(1, groupId);
            statement.setString(2, topic);
            statement.setString(3, materials);
            statement.setDate(4, Date.valueOf(lessonDate));
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        for(HomeworkTask varHWTask: homeworkTaskList){
            jdbcHomeWorkTaskDao.saveHWTask(varHWTask);
        }
        return true;
    }

    @Override
    public Lesson getLessonById(long lessonId) throws SQLException{

        java.sql.PreparedStatement statementLesson = null;
        java.sql.PreparedStatement statementHomeTask;
        PreparedStatement statementGroup;
        String queryLesson = "SELECT lessonId, topic,materials,lessonDate, groupId FROM lessons WHERE lessonId = ?;";
        String queryGroup = "SELECT name,direction,startDate FROM groups WHERE groupId = ?;";
        String queryHomeTask = "SELECT hwTaskId FROM homeTask WHERE lessonId = ?;";
        Lesson lessonResult = new Lesson();

        List<HomeworkTask> homeworkTaskList = new ArrayList<>();
        Group newGroup = null;
        try {
            long groupId = 0;

            statementLesson = connect.prepareStatement(queryLesson);
            statementLesson.setLong(1, lessonId);
            if (statementLesson.execute()) {
                ResultSet resultLesson = statementLesson.executeQuery();
                while (resultLesson.next()) {
                    groupId = resultLesson.getLong(5);
                    lessonResult.setLessonId(resultLesson.getLong(1));
                    lessonResult.setTopic(resultLesson.getString(2));
                    lessonResult.setMaterials(resultLesson.getString(3));
                    lessonResult.setDate(resultLesson.getDate(4).toLocalDate());
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
                    newGroup = new Group(nameForNewGroup, directionForNewGroup, startDateForNewGroup);
                    newGroup.setGroupId(groupId);
                }
            }
            statementHomeTask = connect.prepareStatement(queryHomeTask);
            statementHomeTask.setLong(1, lessonId);
            if (statementHomeTask.execute()) {
                ResultSet resultHomeTasks = statementHomeTask.executeQuery();
                while (resultHomeTasks.next()) {
                    long hwTaskId = resultHomeTasks.getLong(1);
                    homeworkTaskList.add(jdbcHomeWorkTaskDao.getHWTaskById(hwTaskId));
                }
            }
            lessonResult.setHwTasks(homeworkTaskList);
            lessonResult.setGroup(newGroup);
            lessonResult.setLessonId(lessonId);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementLesson != null;
            statementLesson.close();
        }
        return lessonResult;
    }

    @Override
    public boolean updateLesson(Lesson lesson) throws SQLException {

        Long lessonId = lesson.getLessonId();
        Long groupId = lesson.getGroup().getGroupId();
        String topic = lesson.getTopic();
        LocalDate lessonDate = lesson.getDate();
        String materials = lesson.getMaterials();
        List<HomeworkTask> homeworkTaskList = lesson.getHwTasks();

        java.sql.PreparedStatement statement = null;
        String query = "UPDATE LESSONS SET lessonId = ? ,groupId = ?,topic = ?, materials = ?,lessonDate = ? WHERE lessonID = ?;";
        try {
            statement = connect.prepareStatement(query);
            statement.setLong(1, lessonId);
            statement.setLong(2, groupId);
            statement.setString(3, topic);
            statement.setString(4, materials);
            statement.setDate(5, Date.valueOf(lessonDate));
            statement.setLong(6, lessonId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        for(HomeworkTask varHWTask: homeworkTaskList){
            jdbcHomeWorkTaskDao.updateHWTask(varHWTask);
        }
        return true;
    }

    @Override
    public boolean deleteLessonById(long lessonId) throws SQLException {

        PreparedStatement statementLesson = null;
        PreparedStatement statementHomeTask;
        String queryLesson = "DELETE FROM lessons WHERE lessonID = ?";
        String queryHomeTask = "SELECT hwTaskId FROM homeTask WHERE lessonID = ?";

        try {
            statementHomeTask = connect.prepareStatement(queryHomeTask);
            statementHomeTask.setLong(1, lessonId);
            if (statementHomeTask.execute()) {
                ResultSet resultHomeTask = statementHomeTask.executeQuery();
                while (resultHomeTask.next()) {
                    long hwTaskId = resultHomeTask.getLong(1);
                    jdbcHomeWorkTaskDao.deleteHWTaskById(hwTaskId);
                }
            }
            statementLesson = connect.prepareStatement(queryLesson);
            statementLesson.setLong(1, lessonId);
            statementLesson.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementLesson != null;
            statementLesson.close();
        }
        return true;
    }
}
