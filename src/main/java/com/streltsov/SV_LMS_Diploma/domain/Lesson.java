package com.streltsov.SV_LMS_Diploma.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lesson {

    private long idLesson;
    private Class<? extends Group> group;
    private String topic;
    private LocalDate date;
    private String materials;

    private List<HomeworkTask> hwTasks;

    public Lesson(String topic, LocalDate date, String materials) {
        this.topic = topic;
        this.date = date;
        this.materials = materials;
    }

    public boolean addTask(HomeworkTask task) {
        if (this.hwTasks == null) {
            this.hwTasks = new ArrayList<>();
        }
        this.hwTasks.add(task);
        return true;
    }

    public boolean removeTask(HomeworkTask task) {
        this.hwTasks.remove(task);
        return true;
    }

    public boolean addAllTask(List<HomeworkTask> listTasks) {
        if (this.hwTasks == null) {
            this.hwTasks = new ArrayList<>();
        }
        this.hwTasks.addAll(listTasks);
        return true;
    }

    public void setGroup(Class<? extends Group> group) {
        this.group = group;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public long getIdLesson() {
        return idLesson;
    }

    public Class<? extends Group> getGroup() {
        return group;
    }

    public String getTopic() {
        return topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMaterials() {
        return materials;
    }

    public List<HomeworkTask> getHwTasks() {
        return hwTasks;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "idLesson=" + idLesson +
                ", group=" + group +
                ", topic='" + topic + '\'' +
                ", date=" + date +
                ", materials='" + materials + '\'' +
                ", hwTasks=" + hwTasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return idLesson == lesson.idLesson && group.equals(lesson.group) && topic.equals(lesson.topic) && date.equals(lesson.date) && materials.equals(lesson.materials) && Objects.equals(hwTasks, lesson.hwTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLesson, group, topic, date, materials, hwTasks);
    }
}
