package com.streltsov.SV_LMS_Diploma.dao;

import com.streltsov.SV_LMS_Diploma.domain.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    User saveUser(User user);

    User getUserById(int id );

    boolean updateUserById(User user);

    boolean deleteUserById(int id);
}
