package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.HomeworkTask;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.HWTaskDao;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.Persistence;

import java.util.List;

public class InMemoryHomeWorkTaskDaoImpl implements HWTaskDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<HomeworkTask> getAll() {
        return persistence.getHwTasksDB();
    }

    @Override

    public boolean saveHWTask(HomeworkTask homeworkTask) {
        long newID = Persistence.getNewId(persistence.getHwTasksDB());
        homeworkTask.setHwTaskId(newID);
        persistence.getHwTasksDB().add(homeworkTask);
        return true;
    }

    @Override
    public HomeworkTask getHWTaskById(long id) {
        for (HomeworkTask homeworkTask : persistence.getHwTasksDB()) {
            if (homeworkTask.getHwTaskId().equals(id)) {
                return homeworkTask;
            }
        }
        return null;
    }

    @Override
    public boolean updateHWTask(HomeworkTask homeworkTask) {
        long idHomeWork = homeworkTask.getHwTaskId();
        deleteHWTaskById(idHomeWork);
        saveHWTask(homeworkTask);
        return true;
    }

    @Override
    public boolean deleteHWTaskById(long id) {
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
