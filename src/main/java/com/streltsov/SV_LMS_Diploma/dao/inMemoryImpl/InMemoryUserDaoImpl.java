package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.User;
import com.streltsov.SV_LMS_Diploma.dao.Persistence;
import com.streltsov.SV_LMS_Diploma.dao.UserDao;

import java.util.List;

public class InMemoryUserDaoImpl implements UserDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<User> getAll() {
        return persistence.getUserDB();
    }

    @Override
    public User saveUser(User user) {
        int newID = Persistence.getNewId(persistence.getUserDB());
        user.setUserId(newID);
        persistence.getUserDB().add(user);
        return user;
    }

    @Override
    public User getUserById(int id) {
        for (User user : persistence.getUserDB()) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean updateUserById(User user) {
        int idUser = user.getUserId();
        deleteUserById(idUser);
        saveUser(user);
        return true;
    }

    @Override
    public boolean deleteUserById(int id) {
        for (User user : persistence.getUserDB()) {
            if (user.getUserId().equals(id)) {
                persistence.getUserDB().remove(user);
                user.setUserId(null);
                return true;
            }
        }
        return false;
    }
}
