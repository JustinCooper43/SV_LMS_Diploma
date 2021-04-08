package com.streltsov.SV_LMS_Diploma.service;

import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.InMemoryHWDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.InMemoryUserDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.HWDao;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.UserDao;
import com.streltsov.SV_LMS_Diploma.domain.*;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final UserDao userDao = new InMemoryUserDaoImpl();
    private  final HWDao hwDao = new InMemoryHWDaoImpl();

    public boolean saveUserInMemory(User user) throws SQLException {
        userDao.saveUser(user);
        if(user.getClass().equals(Student.class)){
            List<Homework> homeworkList = ((Student) user).getListHomeWork();
            for(Homework varHW: homeworkList){
                hwDao.saveHW(varHW);
            }
        }
        return true;
    }

    public boolean updateUserInMemory(User user) throws SQLException {
       userDao.updateUser(user);
        List<Homework> homeworkList = ((Student) user).getListHomeWork();
        for(Homework varHW: homeworkList){
            hwDao.updateHW(varHW);
        }
        return true;
    }

    public boolean deleteUserInMemory(User user) throws SQLException {
        long userId = user.getUserId();
        userDao.deleteUserById(userId);
        if(user.getClass().equals(Student.class)) {
            List<Homework> homeworkList  = ((Student) user).getListHomeWork();
            for(Homework varHW: homeworkList){
                long homeWorkId = varHW.getHomeWorkId();
                hwDao.deleteHWById(homeWorkId);
            }
        }
        return true;
    }
}
