package com.streltsov.SV_LMS_Diploma.dao.jdbcImpl;

import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.UserDao;
import com.streltsov.SV_LMS_Diploma.domain.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDaoImpl implements UserDao {

    private final Connection connect = ConnectionSingle.getConnectionToAll();
    private final JdbcHWDaoImpl jdbcHWDao = new JdbcHWDaoImpl();

    @Override
    public List<User> getAll() throws SQLException {

        java.sql.Statement statementUser = null;
        String queryStud = "SELECT userId FROM users;";

        List<User> resultListOfUsers = new ArrayList<>();
        try {
            statementUser = connect.createStatement();
            if (statementUser.execute(queryStud)) {
                ResultSet result = statementUser.executeQuery(queryStud);
                while (result.next()) {
                    long userId = result.getLong(1);
                    resultListOfUsers.add(getUserById(userId));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementUser != null;
            statementUser.close();
        }
        return resultListOfUsers;
    }

    @Override
    public boolean saveUser(User user) throws SQLException {
        long groupId = 0;
        String role;
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        LocalDate dateOfBirth = user.getDateOfBirth();
        List<Homework> homeworkList = new ArrayList<>();

        if (user.getClass().equals(Student.class)) {
            role = "STUDENT";
            groupId = ((Student) user).getGroup().getGroupId();
            homeworkList = ((Student) user).getListHomeWork();
        } else {
            role = "TEACHER";
            groupId = ((Teacher) user).getGroups().get(0).getGroupId();
        }
        java.sql.PreparedStatement statement = null;
        String query = "INSERT INTO USERS (role, firstName, lastName, dateOfBirth,groupId) VALUES (?, ?, ?, ?, ?);";
        try {
            statement = connect.prepareStatement(query);
            statement.setString(1, role);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setDate(4, Date.valueOf(dateOfBirth));
            statement.setLong(5, groupId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        if (user.getClass().equals(Student.class)) {
            for (Homework varHW : homeworkList) {
                jdbcHWDao.saveHW(varHW);
            }
        }
        return true;
    }

    @Override
    public User getUserById(long userId) throws SQLException {

        java.sql.PreparedStatement statementUser = null;
        java.sql.PreparedStatement statementGroup;
        java.sql.PreparedStatement statementHomework;
        String queryUser = "SELECT userId,firstName,lastName,dateOfBirth,role, groupId FROM users WHERE userId = ?; ";
        String queryGroup = "SELECT name,direction,startDate FROM groups WHERE groupId = ?; ";
        String queryHomework = "SELECT homeworkId FROM homework WHERE userId = ?; ";

        User userResult = null;
        try {
            long groupId = 0;

            statementUser = connect.prepareStatement(queryUser);
            statementUser.setLong(1, userId);
            if (statementUser.execute()) {
                ResultSet resultUser = statementUser.executeQuery();
                while (resultUser.next()) {
                    groupId = resultUser.getLong(6);

                    if (resultUser.getString(5).equals("STUDENT")) {
                        userResult = new Student();
                    } else {
                        userResult = new Teacher();
                    }
                    userResult.setUserId(resultUser.getLong(1));
                    userResult.setFirstName(resultUser.getString(2));
                    userResult.setLastName(resultUser.getString(3));
                    userResult.setDateOfBirth(resultUser.getDate(4).toLocalDate());
                }
                List<Homework> homeworkList = new ArrayList<>();
                statementHomework = connect.prepareStatement(queryHomework);
                statementHomework.setLong(1, userId);
                if (statementHomework.execute()) {
                    ResultSet resultHomework = statementHomework.executeQuery();
                    while (resultHomework.next()) {
                        long homeworkId = resultHomework.getLong(1);
                        homeworkList.add(jdbcHWDao.getHWById(homeworkId));
                    }
                }
                Group groupResult = null;

                statementGroup = connect.prepareStatement(queryGroup);
                statementGroup.setLong(1, groupId);
                if (statementUser.execute()) {
                    ResultSet resultGroup = statementGroup.executeQuery();
                    while (resultGroup.next()) {
                        String nameForNewGroup = resultGroup.getString(1);
                        String directionForNewGroup = resultGroup.getString(2);
                        LocalDate startDateForNewGroup = resultGroup.getDate(3).toLocalDate();
                        groupResult = new Group(nameForNewGroup, directionForNewGroup, startDateForNewGroup);
                        groupResult.setGroupId(groupId);
                        userResult.setUserId(userId);
                        }
                    if (userResult.getClass() == Student.class) {
                        ((Student) userResult).setGroup(groupResult);
                        ((Student) userResult).setListHomeWork(homeworkList);
                    } else {
                        ((Teacher) userResult).addGroup(groupResult);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementUser != null;
            statementUser.close();
        }
        return userResult;


    }

    @Override
    public boolean updateUser(User user) throws SQLException {

        long userId = user.getUserId();
        long groupId;
        String role;
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String dateOfBirth = user.getDateOfBirth().toString();
        List<Homework> homeworkList = new ArrayList<>();

        if (user.getClass().equals(Student.class)) {
            role = "STUDENT";
            groupId = ((Student) user).getGroup().getGroupId();
            homeworkList = ((Student) user).getListHomeWork();
        } else {
            role = "TEACHER";
            groupId = ((Teacher) user).getGroups().get(0).getGroupId();
        }
        java.sql.PreparedStatement statement = null;
        String query = "UPDATE USERS SET role = ?,firstName = ?,lastName = ?, dateOfBirth = ?, groupId = ? WHERE userID = ?;";

        try {
            statement = connect.prepareStatement(query);
            statement.setString(1, role);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, dateOfBirth);
            statement.setLong(6, userId);
            statement.setLong(5, groupId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        if (user.getClass().equals(Student.class)) {
            for (Homework varHW : homeworkList) {
                jdbcHWDao.updateHW(varHW);
            }
        }
        return true;
    }

    @Override
    public boolean deleteUserById(long userId) throws SQLException {

        PreparedStatement statementUser = null;
        PreparedStatement statementHomeWork = null;
        String queryUser = "DELETE FROM users WHERE USERID = ?";
        String queryHomeWork = "DELETE FROM homeWork WHERE USERID = ?";
        try {
            statementHomeWork = connect.prepareStatement(queryHomeWork);
            statementHomeWork.setLong(1, userId);
            statementHomeWork.executeUpdate();

            statementUser = connect.prepareStatement(queryUser);
            statementUser.setLong(1, userId);
            statementUser.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementUser != null;
            statementUser.close();
        }
        return true;
    }
}
