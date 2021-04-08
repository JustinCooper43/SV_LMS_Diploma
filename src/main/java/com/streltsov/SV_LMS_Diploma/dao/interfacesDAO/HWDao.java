package com.streltsov.SV_LMS_Diploma.dao.interfacesDAO;

import com.streltsov.SV_LMS_Diploma.domain.Homework;
import com.streltsov.SV_LMS_Diploma.domain.HomeworkTask;

import java.sql.SQLException;
import java.util.List;

public interface HWDao {
    List<Homework> getAll() throws SQLException;

    boolean saveHW(Homework homework) throws SQLException;

    Homework getHWById(long id ) throws SQLException;

    boolean updateHW(Homework homework) throws SQLException;

    boolean deleteHWById(long id) throws SQLException;
}
