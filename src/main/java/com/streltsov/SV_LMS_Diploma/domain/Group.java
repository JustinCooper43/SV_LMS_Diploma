package com.streltsov.SV_LMS_Diploma.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Group {

    private final CapacityUtils capacityUtils = new CapacityUtils();

    private Integer groupId;
    private String name;
    private String direction;
    private final LocalDate startDate;

    private final Feed feed = new Feed(this);

    private List<Student> students;
    private List<Teacher> teachers;
    private List<Lesson> lessons;

    public Group(String name, String direction, LocalDate startDate) {
        this.name = name;
        this.direction = direction;
        this.startDate = startDate;
    }

    public Group(String name, String direction, LocalDate startDate, List<Student> listStud, List<Lesson> listLessons, Teacher initialTeacher) {
        this(name, direction, startDate);

        this.students = new ArrayList<>(listStud);
        this.lessons = new ArrayList<>(listLessons);
        this.teachers = new ArrayList<>();

        this.teachers.add(initialTeacher);
    }

    public boolean addTeacher(Teacher teacher) {
        teachers.add(teacher);
        return true;
    }

    public boolean addLesson(Lesson lesson) {
        capacityUtils.checkOfBounds(this.lessons, 35, 40);
        lesson.setGroup(this);
        this.lessons.add(lesson);
        return true;
    }

    public boolean addStudent(Student student) {
        capacityUtils.checkOfBounds(this.students, 10, 15);
        student.setGroup(this);
        this.students.add(student);
        return true;
    }

    public boolean addAllStudents(List<Student> listStud) {
        capacityUtils.checkOfBoundAddAll(this.students, listStud, 10, 15);
        setGroupForStudents(listStud);
        this.students.addAll(listStud);
        return true;
    }

    public boolean addAllLessons(List<Lesson> listLessons) {
        capacityUtils.checkOfBoundAddAll(this.lessons, listLessons, 35, 40);
        setGroupForLessons(listLessons);
        this.lessons.addAll(listLessons);
        return true;
    }

    private void setGroupForStudents(List<Student> listStud) {
        for (Student stud : listStud) {
            stud.setGroup(this);
        }
    }

    private void setGroupForLessons(List<Lesson> listLessons) {
        for (Lesson les : listLessons) {
            les.setGroup(this);
        }
    }

    public boolean removeLesson(Lesson lesson) {
        capacityUtils.checkOfBounds(this.lessons, 35, 40);
        this.lessons.remove(lesson);
        lesson.setGroup(null);
        return true;
    }

    public boolean removeStudent(Student student) {
        capacityUtils.checkOfBounds(this.students, 10, 15);
        this.students.remove(student);
        student.setGroup(null);
        return true;
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Feed getFeed() {
        return feed;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupId, group.groupId) && name.equals(group.name) && direction.equals(group.direction) && startDate.equals(group.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, name, direction, startDate);
    }

    private static class CapacityUtils {

        private <T> void checkOfBoundAddAll(List<T> initialList, List<T> addedList, int fromIndex, int toIndex) {
            int newListSize = initialList.size() + addedList.size();
            if (newListSize > toIndex || newListSize < fromIndex) {
                throw new IndexOutOfBoundsException("Exceeded the limit: from " + fromIndex + " to " + toIndex + "\n" +
                        "Current size: " + initialList.size());
            }
        }

        private <T> void checkOfBounds(List<T> initialList, int fromIndex, int toIndex) {
            if (initialList.size() < fromIndex || initialList.size() > toIndex) {
                throw new IndexOutOfBoundsException("Exceeded the limit: from " + fromIndex + " to " + toIndex + "\n" +
                        "Current size: " + initialList.size());
            }
        }
    }
}
