package com.streltsov.SV_LMS_Diploma.dao.interfacesDAO;

import com.streltsov.SV_LMS_Diploma.domain.Group;

import java.sql.SQLException;
import java.util.List;

public interface GroupDao {

    List<Group> getAll() throws SQLException;

    boolean saveGroup(Group group) throws SQLException;

    Group getGroupById(long id ) throws SQLException;

    boolean updateGroup(Group group) throws SQLException;

    boolean deleteGroupById(long id) throws SQLException;
}
