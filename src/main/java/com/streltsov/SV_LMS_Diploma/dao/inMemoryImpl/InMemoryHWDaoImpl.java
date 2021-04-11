package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.HWDao;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.Persistence;
import com.streltsov.SV_LMS_Diploma.domain.Homework;

import java.util.List;

public class InMemoryHWDaoImpl implements HWDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<Homework> getAll() {
        return persistence.getHwDB();
    }

    @Override

    public boolean saveHW(Homework homework) {
        long newID = Persistence.getNewId(persistence.getHwTasksDB());
        homework.setHomeWorkId(newID);
        persistence.getHwDB().add(homework);
        return true;
    }

    @Override
    public Homework getHWById(long id) {
        for (Homework homework : persistence.getHwDB()) {
            if (homework.getHomeWorkId().equals(id)) {
                return homework;
            }
        }
        return null;
    }

    @Override
    public boolean updateHW(Homework homework) {
        long idHomeWork = homework.getHomeWorkId();
        deleteHWById(idHomeWork);
        saveHW(homework);
        return true;
    }

    @Override
    public boolean deleteHWById(long id) {
        for (Homework homework: persistence.getHwDB()) {
            if (homework.getHomeWorkId().equals(id)) {
                persistence.getHwDB().remove(homework);
                homework.setHomeWorkId(null);
                return true;
            }
        }
        return false;
    }
}
