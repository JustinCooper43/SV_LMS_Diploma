package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.Group;
import com.streltsov.SV_LMS_Diploma.dao.GroupDao;
import com.streltsov.SV_LMS_Diploma.dao.Persistence;

import java.util.List;

public class InMemoryGroupDaoImpl implements GroupDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<Group> getAll() {
        return persistence.getGroupsDB();
    }

    @Override
    public Group saveGroup(Group group) {
        int newID = Persistence.getNewId(persistence.getGroupsDB());
        group.setGroupId(newID);
        persistence.getGroupsDB().add(group);
        return group;
    }

    @Override
    public Group getGroupById(int id) {
        for (Group group : persistence.getGroupsDB()) {
            if (group.getGroupId().equals(id)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public boolean updateGroupById(Group group) {
        int idGroup = group.getGroupId();
        deleteGroupById(idGroup);
        saveGroup(group);
        return true;
    }

    @Override
    public boolean deleteGroupById(int id) {
        for (Group group : persistence.getGroupsDB()) {
            if (group.getGroupId().equals(id)) {
                persistence.getGroupsDB().remove(group);
                group.setGroupId(null);
                return true;
            }
        }
        return false;
    }

}