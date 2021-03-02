package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.Lesson;
import com.streltsov.SV_LMS_Diploma.dao.Persistence;
import com.streltsov.SV_LMS_Diploma.dao.LessonDao;

import java.util.List;

public class InMemoryLessonDaoImpl implements LessonDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<Lesson> getAll() {
        return persistence.getLessonsDB();
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        int newID = Persistence.getNewId(persistence.getLessonsDB());
        lesson.setLessonId(newID);
        persistence.getLessonsDB().add(lesson);
        return lesson;
    }

    @Override
    public Lesson getLessonById(int id) {
        for (Lesson lesson : persistence.getLessonsDB()) {
            if (lesson.getLessonId().equals(id)) {
                return lesson;
            }
        }
        return null;
    }

    @Override
    public boolean updateLessonById(Lesson lesson) {
        int idLesson = lesson.getLessonId();
        deleteLessonById(idLesson);
        saveLesson(lesson);
        return true;
    }

    @Override
    public boolean deleteLessonById(int id) {
        for (Lesson lesson : persistence.getLessonsDB()) {
            if (lesson.getLessonId().equals(id)) {
                persistence.getLessonsDB().remove(lesson);
                lesson.setLessonId(null);
                return true;
            }
        }
        return false;
    }
}
