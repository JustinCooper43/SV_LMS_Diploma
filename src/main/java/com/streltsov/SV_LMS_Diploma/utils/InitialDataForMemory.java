package com.streltsov.SV_LMS_Diploma.utils;

import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.*;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.*;
import com.streltsov.SV_LMS_Diploma.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InitialDataForMemory {

    public static void createInitialData() {

        GroupDao groupDao = new InMemoryGroupDaoImpl();
        FeedDao feedDao = new InMemoryFeedDaoImpl();
        HWTaskDao hwTaskDao = new InMemoryHomeWorkTaskDaoImpl();
        LessonDao lessonDao = new InMemoryLessonDaoImpl();
        PostDao postDao = new InMemoryPostDaoImpl();
        UserDao userDao = new InMemoryUserDaoImpl();

        List<Student> studList1 = new ArrayList<>();
        List<Student> studList2 = new ArrayList<>();
        List<Student> studList3 = new ArrayList<>();
        List<Lesson> lessonsList1 = new ArrayList<>();
        List<Lesson> lessonsList2 = new ArrayList<>();
        List<Lesson> lessonsList3 = new ArrayList<>();
        List<HomeworkTask> taskList1 = new ArrayList<>();
        List<HomeworkTask> taskList2 = new ArrayList<>();
        List<HomeworkTask> taskList3 = new ArrayList<>();

        Teacher teacher1 = new Teacher("Philip", "Preobrazhenskiy", LocalDate.of(1978, 3, 10), "Headmaster");
        Teacher teacher2 = new Teacher("Doctor", "Bormental", LocalDate.of(1998, 4, 19), "Teacher");
        Teacher teacher3 = new Teacher("Poligraf", "Poligrafich", LocalDate.of(1968, 1, 4), "Teacher");

//     creating list of lessons
        for (int k = 1; k < 4; k++) {
            for (int i = 1; i < 36; i++) {
                String lessonTopic = "Lesson " + i + "for group" + k;
                String lessonMaterials = "Materials " + i;
                if (k == 1) {
                    lessonsList1.add(new Lesson(lessonTopic, LocalDate.now(), lessonMaterials));
                } else if (k == 2) {
                    lessonsList2.add(new Lesson(lessonTopic, LocalDate.now(), lessonMaterials));
                } else {
                    lessonsList3.add(new Lesson(lessonTopic, LocalDate.now(), lessonMaterials));
                }
            }
        }

//     creating list of students
        for (int k = 1; k < 4; k++) {
            for (int i = 1; i < 11; i++) {
                String firstName = "Name " + i + " in group " + k;
                String lastName = "Lastname " + i;
                if (k == 1) {
                    studList1.add(new Student(firstName, lastName, LocalDate.of(1993 + i, i, i)));
                } else if (k == 2) {
                    studList2.add(new Student(firstName, lastName, LocalDate.of(1983 + i, i, i)));
                } else {
                    studList3.add(new Student(firstName, lastName, LocalDate.of(1973 + i, i, i)));
                }
            }
        }

//      creating list of tasks
        for (int k = 1; k < 4; k++) {
            for (int i = 1; i < 4; i++) {
                String nameTask = "Task " + i;
                String materialsTask = "Materials for Task " + i;
                if (k == 1) {
                    taskList1.add(new HomeworkTask(nameTask, LocalDate.now(), materialsTask, LocalDate.of(2021, 2, 29)));
                } else if (k == 2) {
                    taskList2.add(new HomeworkTask(nameTask, LocalDate.now(), materialsTask, LocalDate.of(2020, 6, 24)));
                } else {
                    taskList3.add(new HomeworkTask(nameTask, LocalDate.now(), materialsTask, LocalDate.of(2019, 9, 21)));
                }
            }
        }

//      adding all tasks to lesson
        for (Lesson lesson : lessonsList1) {
            lesson.addAllTask(taskList1);
        }
        for (Lesson lesson : lessonsList1) {
            lesson.addAllTask(taskList2);
        }
        for (Lesson lesson : lessonsList1) {
            lesson.addAllTask(taskList3);
        }

//        creating list of homeworks
        for (Student varStud : studList1) {
            List<Homework> homeworkList = new ArrayList<>();
            for (int k = 1; k < lessonsList1.size() + 1; k++) {
                for (int i = 1; i < taskList1.size() + 1; i++) {
                    String materials = "Materials for homeTask " + i + " Lesson " + k;
                    homeworkList.add(new Homework(materials, taskList1.get(i - 1), LocalDate.now()));
                }
            }
            varStud.setListHomeWork(homeworkList);
        }

        for (Student varStud : studList2) {
            List<Homework> homeworkList = new ArrayList<>();
            for (int k = 1; k < lessonsList2.size() + 1; k++) {
                for (int i = 1; i < taskList2.size() + 1; i++) {
                    String materials = "Materials for homeTask " + i + " Lesson " + k;
                    homeworkList.add(new Homework(materials, taskList1.get(i - 1), LocalDate.now()));
                }
            }
            varStud.setListHomeWork(homeworkList);
        }

        for (Student varStud : studList3) {
            List<Homework> homeworkList = new ArrayList<>();
            for (int k = 1; k < lessonsList3.size() + 1; k++) {
                for (int i = 1; i < taskList3.size() + 1; i++) {
                    String materials = "Materials for homeTask " + i + " Lesson " + k;
                    homeworkList.add(new Homework(materials, taskList1.get(i - 1), LocalDate.now()));
                }
            }
            varStud.setListHomeWork(homeworkList);
        }

        //      creating group
        Group group1 = new Group("Group 1", "Direction 1", LocalDate.now(), studList1, lessonsList1, teacher1);
        Group group2 = new Group("Group 2", "Direction 2", LocalDate.now(), studList2, lessonsList2, teacher2);
        Group group3 = new Group("Group 3", "Direction 3", LocalDate.now(), studList3, lessonsList3, teacher3);

//     adding posts
        for (int k = 1; k < 4; k++) {
            for (int i = 1; i < 11; i++) {
                String textNews = "News " + i + " for feed " + k;
                String author = "Author " + i;
                group1.getFeed().addPost(new Post(textNews, LocalDate.now(), author));
                if (k == 1) {
                    group1.getFeed().addPost(new Post(textNews, LocalDate.now(), author));
                } else if (k == 2) {
                    group2.getFeed().addPost(new Post(textNews, LocalDate.now(), author));
                } else {
                    group3.getFeed().addPost(new Post(textNews, LocalDate.now(), author));
                }
            }
        }


    }
}
