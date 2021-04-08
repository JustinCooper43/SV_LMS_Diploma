package com.streltsov.SV_LMS_Diploma.service;

import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.*;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.*;
import com.streltsov.SV_LMS_Diploma.domain.HomeworkTask;
import com.streltsov.SV_LMS_Diploma.domain.Lesson;

import java.sql.SQLException;
import java.util.List;

public class LessonService {

    private final HWTaskDao hwTaskDao = new InMemoryHomeWorkTaskDaoImpl();
    private final LessonDao lessonDao = new InMemoryLessonDaoImpl();

    public boolean saveLessonInMemory(Lesson lesson) throws SQLException {
        List<HomeworkTask> homeworkTaskList = lesson.getHwTasks();
        lessonDao.saveLesson(lesson);
        for(HomeworkTask varHWTask: homeworkTaskList){
            hwTaskDao.saveHWTask(varHWTask);
        }
        return true;
    }

    public boolean updateLessonInMemory(Lesson lesson) throws SQLException {
        lessonDao.updateLesson(lesson);
        List<HomeworkTask> homeworkTaskList = lesson.getHwTasks();
        for(HomeworkTask varHWTask: homeworkTaskList){
            hwTaskDao.updateHWTask(varHWTask);
        }
        return true;
    }

    public boolean deleteLessonInMemory(Lesson lesson) throws SQLException {
        long lessonId = lesson.getLessonId();
        lessonDao.deleteLessonById(lessonId);
        List<HomeworkTask> homeworkTaskList = lesson.getHwTasks();
        for(HomeworkTask varHWTask: homeworkTaskList){
            long hwTaskId = varHWTask.getHwTaskId();
            hwTaskDao.deleteHWTaskById(hwTaskId);
        }
        return true;
    }

}
