package com.streltsov.SV_LMS_Diploma.dao.jdbcImpl;

import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.HWTaskDao;
import com.streltsov.SV_LMS_Diploma.domain.Group;
import com.streltsov.SV_LMS_Diploma.domain.HomeworkTask;
import com.streltsov.SV_LMS_Diploma.domain.Lesson;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcHomeWorkTaskDaoImpl implements HWTaskDao {


    private final Connection connect = ConnectionSingle.getConnectionToAll();

    @Override
    public List<HomeworkTask> getAll() throws SQLException {
        Statement statementHWTask = null;
        String queryHWTask = "SELECT hwTaskId FROM homeTask;";

        List<HomeworkTask> homeworkTaskList = new ArrayList<>();
        try {
            statementHWTask = connect.createStatement();
            if (statementHWTask.execute(queryHWTask)) {
                ResultSet resultHWTask = statementHWTask.executeQuery(queryHWTask);
                while (resultHWTask.next()) {
                    long hwTaskId = resultHWTask.getLong(1);
                    homeworkTaskList.add(getHWTaskById(hwTaskId));
                }
            }
            return homeworkTaskList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementHWTask != null;
            statementHWTask.close();
        }
        return homeworkTaskList;
    }

    @Override
    public boolean saveHWTask(HomeworkTask homeworkTask) throws SQLException {

        String task = homeworkTask.getTask();
        LocalDate hwTaskDate = homeworkTask.getDate();
        String materials = homeworkTask.getMaterials();
        LocalDate deadLine = homeworkTask.getDeadLine();
        Long lessonId = homeworkTask.getLesson().getLessonId();

        PreparedStatement statement = null;
        String query = "INSERT INTO homeTask (lessonId, task, materials, hwTaskDate, deadLine) VALUES (?, ?, ?, ?, ?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setLong(1, lessonId);
            statement.setString(2, task);
            statement.setString(3, materials);
            statement.setDate(4, Date.valueOf(hwTaskDate));
            statement.setDate(5, Date.valueOf(deadLine));
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        return true;
    }

    @Override
    public HomeworkTask getHWTaskById(long hwTaskId) throws SQLException {
        PreparedStatement statementHWTask = null;
        PreparedStatement statementLesson = null;
        PreparedStatement statementGroup= null;
        String queryHWTask = "SELECT hwTaskId,lessonId,task, materials, hwTaskDate, deadLine FROM homeTask WHERE hwTaskId = ?;";
        String queryLesson = "SELECT lessonId, topic,materials,lessonDate, groupId FROM lessons WHERE lessonId = ?;";
        String queryGroup = "SELECT name,direction,startDate FROM groups WHERE groupId = ?;";
        HomeworkTask homeworkTaskResult = new HomeworkTask();
        Lesson lessonResult = new Lesson();
        Group newGroup = null;
        try {
            long lessonId = 0;
            statementHWTask = connect.prepareStatement(queryHWTask);
            statementHWTask.setLong(1, hwTaskId);
            if (statementHWTask.execute()) {
                ResultSet resultHWTask = statementHWTask.executeQuery();
                while (resultHWTask.next()) {
                    lessonId = resultHWTask.getLong(2);
                    homeworkTaskResult.setHwTaskId(resultHWTask.getLong(1));
                    homeworkTaskResult.setTask(resultHWTask.getString(3));
                    homeworkTaskResult.setMaterials(resultHWTask.getString(4));
                    homeworkTaskResult.setDate(resultHWTask.getDate(5).toLocalDate());
                    homeworkTaskResult.setDeadLine(resultHWTask.getDate(6).toLocalDate());
                }
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

                    }
                }
            }
            lessonResult.setGroup(newGroup);
            homeworkTaskResult.setHwTaskId(hwTaskId);
            homeworkTaskResult.setLesson(lessonResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementHWTask != null;
            statementHWTask.close();
        }
        return homeworkTaskResult;
    }

    @Override
    public boolean updateHWTask(HomeworkTask homeworkTask) throws SQLException {
        Long hwTaskId = homeworkTask.getHwTaskId();
        Long lessonId = homeworkTask.getLesson().getLessonId();
        String task = homeworkTask.getTask();
        LocalDate hwTaskDate = homeworkTask.getDate();
        String materials = homeworkTask.getMaterials();
        LocalDate deadLine = homeworkTask.getDeadLine();

        java.sql.PreparedStatement statement = null;
        String query = "UPDATE homeTask SET lessonId = ?,task = ?, materials = ?, hwTaskDate = ?, deadLine = ? WHERE hwTaskId = ? ;";
        try {
            statement = connect.prepareStatement(query);
            statement.setLong(1, lessonId);
            statement.setString(2, task);
            statement.setString(3, materials);
            statement.setDate(4, Date.valueOf(hwTaskDate));
            statement.setDate(5, Date.valueOf(deadLine));
            statement.setLong(6, hwTaskId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        return true;


    }

    @Override
    public boolean deleteHWTaskById(long hwTaskId) throws SQLException {
        PreparedStatement statementHWTask = null;
        PreparedStatement statementHomeWork;
        String queryHWTask = "DELETE FROM homeTask WHERE hwTaskId = ?";
        String queryHomeWork = "DELETE FROM homeWork WHERE hwTaskId = ?";

        try {
            statementHomeWork = connect.prepareStatement(queryHomeWork);
            statementHomeWork.setLong(1, hwTaskId);
            statementHomeWork.executeUpdate();
            statementHWTask = connect.prepareStatement(queryHWTask);
            statementHWTask.setLong(1, hwTaskId);
            statementHWTask.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementHWTask != null;
            statementHWTask.close();
        }
        return true;
    }
}
