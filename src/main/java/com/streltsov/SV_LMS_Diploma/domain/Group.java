package com.streltsov.SV_LMS_Diploma.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Group {

    private String name;
    private String direction;
    private final LocalDate startDate;

    private final Feed feed = new Feed();

    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Lesson> lessons = new ArrayList<>();

    public Group(String name, String direction, LocalDate startDate, List<Student> listStud, List<Lesson> listLessons, Teacher initialTeacher) {
        this.name = name;
        this.direction = direction;
        this.startDate = startDate;
        addAllStudents(listStud);
        addAllLessons(listLessons);
        addTeacher(initialTeacher);
        feed.setGroup(this.getClass());

    }

    public boolean addTeacher(Teacher teacher) {
        teachers.add(teacher);
        return true;
    }

    public boolean addLesson(Lesson lesson) {
        checkOfBounds(this.lessons, 35, 40);
        lesson.setGroup(this.getClass());
        this.lessons.add(lesson);
        return true;
    }

    public boolean addStudent(Student student) {
        checkOfBounds(this.students, 10, 15);
        student.setGroup(this.getClass());
        this.students.add(student);
        return true;
    }

    public boolean addAllStudents(List<Student> listStud) {
        checkOfBoundAddAll(this.students, listStud, 10, 15);
        setGroupForStudents(listStud);
        this.students.addAll(listStud);
        return true;
    }

    public boolean addAllLessons(List<Lesson> listLessons) {
        checkOfBoundAddAll(this.lessons, listLessons, 35, 40);
        setGroupForLessons(listLessons);
        this.lessons.addAll(listLessons);
        return true;
    }

    private void setGroupForStudents(List<Student> listStud) {
        for (Student stud : listStud) {
            stud.setGroup(this.getClass());
        }
    }

    private void setGroupForLessons(List<Lesson> listLessons) {
        for (Lesson les : listLessons) {
            les.setGroup(this.getClass());
        }
    }

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

    public boolean removeLesson(Lesson lesson) {
        checkOfBounds(this.lessons, 35, 40);
        this.lessons.remove(lesson);
        lesson.setGroup(null);
        return true;
    }

    public boolean removeStudent(Student student) {
        checkOfBounds(this.students, 10, 15);
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

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", startDate=" + startDate +
                ", feed=" + feed +
                ", students=" + students +
                ", teachers=" + teachers +
                ", lessons=" + lessons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return name.equals(group.name) && direction.equals(group.direction) && startDate.equals(group.startDate) && feed.equals(group.feed) && students.equals(group.students) && teachers.equals(group.teachers) && lessons.equals(group.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, direction, startDate, feed, students, teachers, lessons);
    }
}
