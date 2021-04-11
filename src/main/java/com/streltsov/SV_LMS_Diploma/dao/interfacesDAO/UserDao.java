package com.streltsov.SV_LMS_Diploma.dao.interfacesDAO;

import com.streltsov.SV_LMS_Diploma.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getAll() throws SQLException;

    boolean saveUser(User user) throws SQLException;

    User getUserById(long id ) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    boolean deleteUserById(long id) throws SQLException;
}
