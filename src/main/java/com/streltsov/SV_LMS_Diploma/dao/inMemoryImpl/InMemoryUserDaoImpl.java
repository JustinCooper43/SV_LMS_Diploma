package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.User;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.Persistence;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.UserDao;

import java.util.List;

public class InMemoryUserDaoImpl implements UserDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<User> getAll() {
        return persistence.getUserDB();
    }

    @Override
    public boolean saveUser(User user) {
        long newID = Persistence.getNewId(persistence.getUserDB());
        user.setUserId(newID);
        persistence.getUserDB().add(user);
        return true;
    }

    @Override
    public User getUserById(long id) {
        for (User user : persistence.getUserDB()) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        long idUser = user.getUserId();
        deleteUserById(idUser);
        saveUser(user);
        return true;
    }

    @Override
    public boolean deleteUserById(long id) {
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
