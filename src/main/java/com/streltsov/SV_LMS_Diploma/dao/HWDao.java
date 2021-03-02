package com.streltsov.SV_LMS_Diploma.dao;

import com.streltsov.SV_LMS_Diploma.domain.HomeworkTask;

import java.util.List;

public interface HWDao {

    List<HomeworkTask> getAll();

    HomeworkTask saveHW(HomeworkTask homeworkTask);

    HomeworkTask getHWById(int id );

    boolean updateHWById(HomeworkTask homeworkTask);

    boolean deleteHWById(int id);
}
