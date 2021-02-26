package com.streltsov.SV_LMS_Diploma.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Student extends User {

    private Class<? extends Group> group;

    public Student(String firstName, String lastName, LocalDate dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }

    public void setGroup(Class<? extends com.streltsov.SV_LMS_Diploma.domain.Group> group) {
        this.group = group;
    }

    public Class<? extends Group> getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "group=" + group +
                ", idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
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
