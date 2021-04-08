package com.streltsov.SV_LMS_Diploma.dao.interfacesDAO;

import com.streltsov.SV_LMS_Diploma.domain.HomeworkTask;

import java.sql.SQLException;
import java.util.List;

public interface HWTaskDao {

    List<HomeworkTask> getAll() throws SQLException;

    boolean saveHWTask(HomeworkTask homeworkTask) throws SQLException;

    HomeworkTask getHWTaskById(long id ) throws SQLException;

    boolean updateHWTask(HomeworkTask homeworkTask) throws SQLException;

    boolean deleteHWTaskById(long id) throws SQLException;
}
