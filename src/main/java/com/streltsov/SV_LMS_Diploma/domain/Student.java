package com.streltsov.SV_LMS_Diploma.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends User {

    private Group group;
    private List<Homework> listHomeWork;

    public Student(){
        super();
    };

    public Student(String firstName, String lastName, LocalDate dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }

    public boolean addHomework(Homework homework) {
        if (this.listHomeWork == null) {
            this.listHomeWork = new ArrayList<>();
        }
        homework.setStudent(this);
        this.listHomeWork.add(homework);
        return true;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setListHomeWork(List<Homework> listHomeWork) {
        this.listHomeWork = listHomeWork;
    }

    public List<Homework> getListHomeWork() {
        return listHomeWork;
    }

    @Override
    public String toString() {
        return "Student{" +
                "group=" + group +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group);
    }
}
