package euk.recording.helloworld.service.group.interfaces;

import euk.recording.helloworld.DAO.group.interfaces.IGroupDAO;
import euk.recording.helloworld.model.Group;

import java.util.List;

public interface IGroupService extends IGroupDAO {
    List<Group> getAllByName(String name);
    Group getByName(String name);
}
