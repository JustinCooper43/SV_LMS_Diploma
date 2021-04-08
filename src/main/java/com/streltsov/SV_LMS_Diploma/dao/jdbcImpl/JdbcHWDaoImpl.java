package com.streltsov.SV_LMS_Diploma.dao.jdbcImpl;

import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.HWDao;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.HWTaskDao;
import com.streltsov.SV_LMS_Diploma.domain.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcHWDaoImpl implements HWDao {

    private final Connection connect = ConnectionSingle.getConnectionToAll();

    @Override
    public List<Homework> getAll() throws SQLException {
        Statement statementHomeWork = null;
        String queryLesson = "SELECT homeWorkId FROM homeWork;";

        List<Homework> listOfHomeWork = new ArrayList<>();
        try {
            statementHomeWork = connect.createStatement();
            if (statementHomeWork.execute(queryLesson)) {
                ResultSet resultHomeWork = statementHomeWork.executeQuery(queryLesson);
                while (resultHomeWork.next()) {
                    long homeWorkId = resultHomeWork.getLong(1);
                    listOfHomeWork.add(getHWById(homeWorkId));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementHomeWork != null;
            statementHomeWork.close();
        }
        return listOfHomeWork;
    }

    @Override
    public boolean saveHW(Homework homework) throws SQLException {

        Long hwTaskId = homework.getHomeworkTask().getHwTaskId();
        Long userId = homework.getStudent().getUserId();
        String materialsHomeWork = homework.getMaterialsHomeWork();
        LocalDate dateCreate = homework.getDate();

        PreparedStatement statement = null;
        String query = "INSERT INTO homeWork (userId,hwTaskId,materialsHomeWork,dateCreate) VALUES (?, ?, ?, ?)";

        try {
            statement = connect.prepareStatement(query);

            statement.setLong(1, userId);
            statement.setLong(2, hwTaskId);
            statement.setString(3, materialsHomeWork);
            statement.setDate(4, Date.valueOf(dateCreate));
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
    public Homework getHWById(long homeWorkId) throws SQLException {

        java.sql.PreparedStatement statementHomeWork = null;
        java.sql.PreparedStatement statementStudent = null;
        String queryHomeWork = "SELECT userId,hwTaskId,materialsHomeWork,dateCreate FROM homeWork WHERE homeWorkId = ?;";
        String queryStudent = "SELECT firstName,lastName,dateOfBirth FROM users WHERE userId = ?; ";

        Homework homeWork = null;
        Student studentForHomework = new Student();
        try {
            long userId = 0;
            long hwTaskId = 0;
            String materialsHomeWork = null;
            LocalDate dateCreate = null;
            JdbcHomeWorkTaskDaoImpl homeWorkTaskDao = new JdbcHomeWorkTaskDaoImpl();
            JdbcGroupDaoImpl jdbcGroupDao = new JdbcGroupDaoImpl();

            statementHomeWork = connect.prepareStatement(queryHomeWork);
            statementHomeWork.setLong(1, homeWorkId);
            if (statementHomeWork.execute()) {
                ResultSet resultHomeWork = statementHomeWork.executeQuery();
                while (resultHomeWork.next()) {
                    userId = resultHomeWork.getLong(1);
                    hwTaskId = resultHomeWork.getLong(2);
                    materialsHomeWork = resultHomeWork.getString(3);
                    dateCreate = resultHomeWork.getDate(4).toLocalDate();
                }

            }
            statementStudent = connect.prepareStatement(queryStudent);
            statementStudent.setLong(1, userId);
            if (statementStudent.execute()) {
                ResultSet resultStudent = statementStudent.executeQuery();
                while (resultStudent.next()) {
                    studentForHomework.setFirstName(resultStudent.getString(1));
                    studentForHomework.setLastName(resultStudent.getString(2));
                    studentForHomework.setDateOfBirth(resultStudent.getDate(3).toLocalDate());
                    studentForHomework.setUserId(userId);
                }
            }
            HomeworkTask homeworkTaskForHomeWork = homeWorkTaskDao.getHWTaskById(hwTaskId);
            homeWork = new Homework(materialsHomeWork, homeworkTaskForHomeWork, dateCreate);
            homeWork.setHomeWorkId(homeWorkId);
            homeWork.setStudent(studentForHomework);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementHomeWork != null;
            statementHomeWork.close();
        }
        return homeWork;
    }

    @Override
    public boolean updateHW(Homework homework) throws SQLException {

        Long homeWorkId = homework.getHomeWorkId();
        Long userId = homework.getStudent().getUserId();
        Long hwTaskId = homework.getHomeworkTask().getHwTaskId();
        String materialsHomeWork = homework.getMaterialsHomeWork();
        LocalDate hwCreateDate = homework.getDate();

        PreparedStatement statement = null;
        String query = " UPDATE homeWork SET userId = ? ,hwTaskId = ?,materialsHomeWork = ?,dateCreate = ? WHERE homeWorkId = ?;";

        try {
            statement = connect.prepareStatement(query);
            statement.setLong(1, userId);
            statement.setLong(2, hwTaskId);
            statement.setString(3, materialsHomeWork);
            statement.setDate(4, Date.valueOf(hwCreateDate));
            statement.setLong(5, homeWorkId);
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
    public boolean deleteHWById(long homeWorkId) throws SQLException {
        java.sql.PreparedStatement statement = null;
        String query = "DELETE FROM homeWork WHERE homeWorkId = ?";
        try {
            statement = connect.prepareStatement(query);
            statement.setLong(1, homeWorkId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        return true;
    }
}
