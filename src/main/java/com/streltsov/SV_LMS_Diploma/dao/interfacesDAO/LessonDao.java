package com.streltsov.SV_LMS_Diploma.dao.interfacesDAO;

import com.streltsov.SV_LMS_Diploma.domain.Lesson;

import java.sql.SQLException;
import java.util.List;

public interface LessonDao {

    List<Lesson> getAll() throws SQLException;

    boolean saveLesson(Lesson lesson) throws SQLException;

    Lesson getLessonById(long id ) throws SQLException;

    boolean updateLesson(Lesson lesson) throws SQLException;

    boolean deleteLessonById(long id) throws SQLException;
}
