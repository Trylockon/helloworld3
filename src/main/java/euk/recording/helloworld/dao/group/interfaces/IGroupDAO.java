package euk.recording.helloworld.DAO.group.interfaces;

import euk.recording.helloworld.model.Group;

import java.util.List;

public interface IGroupDAO {
    Group create(Group group);
    Group get(int id);
    Group update(Group group);
    Group delete(int id);
    List<Group> getAll();
}
