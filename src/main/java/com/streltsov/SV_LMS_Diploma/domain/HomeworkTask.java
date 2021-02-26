package com.streltsov.SV_LMS_Diploma.domain;

import java.time.LocalDate;
import java.util.Objects;

public class HomeworkTask {

    private long idHWTask;
    private String task;
    private final LocalDate date;
    private String materials;
    private LocalDate deadLine;

    public HomeworkTask(String task, LocalDate date, String materials, LocalDate deadLine) {
        this.task = task;
        this.date = date;
        this.materials = materials;
        this.deadLine = deadLine;
    }

    public long getIdHWTask() {
        return idHWTask;
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

    @Override
    public String toString() {
        return "HomeworkTask{" +
                "idHWTask=" + idHWTask +
                ", task='" + task + '\'' +
                ", date=" + date +
                ", materials='" + materials + '\'' +
                ", deadLine=" + deadLine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkTask that = (HomeworkTask) o;
        return idHWTask == that.idHWTask && task.equals(that.task) && date.equals(that.date) && materials.equals(that.materials) && deadLine.equals(that.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHWTask, task, date, materials, deadLine);
    }
}
