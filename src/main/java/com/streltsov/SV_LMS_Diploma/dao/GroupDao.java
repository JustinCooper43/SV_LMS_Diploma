package com.streltsov.SV_LMS_Diploma.dao;

import com.streltsov.SV_LMS_Diploma.domain.Group;

import java.util.List;

public interface GroupDao {

    List<Group> getAll();

    Group saveGroup(Group group);

    Group getGroupById(int id );

    boolean updateGroupById(Group group);

    boolean deleteGroupById(int id);
}
