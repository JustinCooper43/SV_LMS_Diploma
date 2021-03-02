package com.streltsov.SV_LMS_Diploma.dao;

import com.streltsov.SV_LMS_Diploma.domain.Lesson;
import java.util.List;

public interface LessonDao {

    List<Lesson> getAll();

    Lesson saveLesson(Lesson lesson);

    Lesson getLessonById(int id );

    boolean updateLessonById(Lesson lesson);

    boolean deleteLessonById(int id);
}
