package com.streltsov.SV_LMS_Diploma.domain;

import java.time.LocalDate;
import java.util.Objects;

public class HomeworkTask {

    private Integer hwTaskId;
    private String task;
    private final LocalDate date;
    private String materials;
    private LocalDate deadLine;
    private Lesson lesson;

    public HomeworkTask(String task, LocalDate date, String materials, LocalDate deadLine) {
        this.task = task;
        this.date = date;
        this.materials = materials;
        this.deadLine = deadLine;
    }

    public Integer getHwTaskId() {
        return hwTaskId;
    }

    public String getTask() {
        return task;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMaterials() {
        return materials;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public void setHwTaskId(Integer hwTaskId) {
        this.hwTaskId = hwTaskId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "HomeworkTask{" +
                "task='" + task + '\'' +
                ", deadLine=" + deadLine +
                ", lesson=" + lesson +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkTask that = (HomeworkTask) o;
        return hwTaskId == that.hwTaskId && task.equals(that.task) && date.equals(that.date) && materials.equals(that.materials) && deadLine.equals(that.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hwTaskId, task, date, materials, deadLine);
    }
}
