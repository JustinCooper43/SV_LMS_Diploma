package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.HomeworkTask;
import com.streltsov.SV_LMS_Diploma.dao.HWDao;
import com.streltsov.SV_LMS_Diploma.dao.Persistence;

import java.util.List;

public class InMemoryHomeWorkDaoImpl implements HWDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<HomeworkTask> getAll() {
        return persistence.getHwTasksDB();
    }

    @Override

    public HomeworkTask saveHW(HomeworkTask homeworkTask) {
        int newID = Persistence.getNewId(persistence.getHwTasksDB());
        homeworkTask.setHwTaskId(newID);
        persistence.getHwTasksDB().add(homeworkTask);
        return homeworkTask;
    }

    @Override
    public HomeworkTask getHWById(int id) {
        for (HomeworkTask homeworkTask : persistence.getHwTasksDB()) {
            if (homeworkTask.getHwTaskId().equals(id)) {
                return homeworkTask;
            }
        }
        return null;
    }

    @Override
    public boolean updateHWById(HomeworkTask homeworkTask) {
        int idHomeWork = homeworkTask.getHwTaskId();
        deleteHWById(idHomeWork);
        saveHW(homeworkTask);
        return true;
    }

    @Override
    public boolean deleteHWById(int id) {
        for (HomeworkTask homeworkTask: persistence.getHwTasksDB()) {
            if (homeworkTask.getHwTaskId().equals(id)) {
                persistence.getHwTasksDB().remove(homeworkTask);
                homeworkTask.setHwTaskId(null);
                return true;
            }
        }
        return false;
    }
}
