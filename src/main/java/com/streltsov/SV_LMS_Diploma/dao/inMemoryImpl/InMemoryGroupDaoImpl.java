package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.Group;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.GroupDao;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.Persistence;

import java.util.List;

public class InMemoryGroupDaoImpl implements GroupDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<Group> getAll() {
        return persistence.getGroupsDB();
    }

    @Override
    public boolean saveGroup(Group group) {
        long newID = Persistence.getNewId(persistence.getGroupsDB());
        group.setGroupId(newID);
        persistence.getGroupsDB().add(group);
        return true;
    }

    @Override
    public Group getGroupById(long id) {
        for (Group group : persistence.getGroupsDB()) {
            if (group.getGroupId().equals(id)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public boolean updateGroup(Group group) {
        long idGroup = group.getGroupId();
        deleteGroupById(idGroup);
        saveGroup(group);
        return true;
    }

    @Override
    public boolean deleteGroupById(long id) {
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