package com.streltsov.SV_LMS_Diploma;

import com.streltsov.SV_LMS_Diploma.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<Student> studList = new ArrayList<>();
        List<Lesson> lessonsList = new ArrayList<>();
        List<HomeworkTask> taskList = new ArrayList<>();

        Teacher teacher = new Teacher("Philip", "Preobrazhenskiy", LocalDate.of(1978, 3, 15), "Headmaster");

//     creating list of lessons
        for (int i = 1; i < 36; i++) {
            String lessonTopic = "Lesson " + i;
            String lessonMaterials = "Materials " + i;
            lessonsList.add(new Lesson(lessonTopic, LocalDate.now(), lessonMaterials));
        }

//     creating list of students
        for (int i = 1; i < 11; i++) {
            String firstName = "Name " + i;
            String lastName = "Lastname " + i;
            studList.add(new Student(firstName, lastName, LocalDate.of(1953 + i, i, i)));
        }

//      creating list of tasks
        for (int i = 1; i < 6; i++) {
            String nameTask = "Task " + i;
            String materialsTask = "Materials for Task " + i;
            new HomeworkTask(nameTask, LocalDate.now(), materialsTask, LocalDate.of(2021, 2, 26));
        }

//      creating group
        Group group = new Group("Group 1", "Direction 1", LocalDate.now(), studList, lessonsList, teacher);

//     adding posts
        for (int i = 1; i < 11; i++) {
            String textNews = "News " + i;
            group.getFeed().addPost(new Post(textNews, LocalDate.now()));
        }

        Post testPost = new Post("test text", LocalDate.now());

//      creating object for test
        Lesson testLesson = new Lesson("Test lesson", LocalDate.now(), "Test materials");
        HomeworkTask testTask = new HomeworkTask("Test task", LocalDate.now(), "Materials for Test task", LocalDate.of(2021, 2, 26));

//      adding task to lesson
        testLesson.addTask(testTask);

//      adding lesson to task
        group.addLesson(testLesson);

//      adding all tasks to lesson
        for (Lesson lesson : group.getLessons()) {
            lesson.addAllTask(taskList);
        }
//      adding student to group

        Student testStudent = new Student("Test stud", "Lastname test stud", LocalDate.of(1992, 9, 10));

        group.addStudent(testStudent);

//      remove task from lesson
        testLesson.removeTask(testTask);

//      remove lesson from group
        group.removeLesson(testLesson);

//      remove student from group
        group.removeStudent(testStudent);

//     remove post from feed
        group.getFeed().removePost(testPost);


    }
}
