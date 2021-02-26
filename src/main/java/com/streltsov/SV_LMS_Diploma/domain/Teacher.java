package com.streltsov.SV_LMS_Diploma.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends User {

    private String role;
    private List<Group> groups;

    public Teacher(String firstName, String lastName, LocalDate dateOfBirth, String role) {
        super(firstName, lastName, dateOfBirth);
        this.role = role;
    }

    public boolean addGroup(Group group) {
        if (this.groups == null) {
            this.groups = new ArrayList<>();
        }
        this.groups.add(group);
        return true;
    }

    private boolean removeGroup(Group group) {
        this.groups.remove(group);
        return true;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "role='" + role + '\'' +
                ", groups=" + groups +
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
        Teacher teacher = (Teacher) o;
        return role.equals(teacher.role) && Objects.equals(groups, teacher.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, groups);
    }
}
