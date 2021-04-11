package com.streltsov.SV_LMS_Diploma.domain;



import java.time.LocalDate;

public class Homework {

    private Long homeWorkId;
    private String materialsHomeWork;
    private Student student;
    private final HomeworkTask homeworkTask;
    private final LocalDate date;

    public Homework(String materialsHomeWork, HomeworkTask homeworkTask, LocalDate date) {
        this.materialsHomeWork = materialsHomeWork;
        this.homeworkTask = homeworkTask;
        this.date = date;
    }

    public String getMaterialsHomeWork() {
        return materialsHomeWork;
    }

    public Student getStudent() {
        return student;
    }

    public HomeworkTask getHomeworkTask() {
        return homeworkTask;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setHomeWorkId(Long homeWorkId) {
        this.homeWorkId = homeWorkId;
    }

    public Long getHomeWorkId() {
        return homeWorkId;
    }

    public void setMaterialsHomeWork(String materialsHomeWork) {
        this.materialsHomeWork = materialsHomeWork;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "student=" + student +
                ", homeworkTask=" + homeworkTask +
                '}';
    }
}
