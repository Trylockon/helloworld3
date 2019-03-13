package euk.recording.helloworld.DAO.group.impls;

import euk.recording.helloworld.DAO.group.interfaces.IGroupDAO;
import euk.recording.helloworld.data.FakeDataSource;
import euk.recording.helloworld.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupDAOFakeImpl implements IGroupDAO {

    @Autowired
    FakeDataSource dataSource;

    @Override
    public Group create(Group group) {
        int newId = this.getAll().stream()
                .mapToInt(Group::getId)
                .max().orElse(0);
        group.setId(newId + 1);
        this.getAll().add(group);
        return group;
    }

    @Override
    public Group get(int id) {
        return this.getAll().stream().filter(group -> group.getId() == id)
                .findFirst().orElse(new Group());
    }

    @Override
    public Group update(Group group) {
        Group old = this.getAll().stream()
                .filter(g -> g.equals(group))
                .findFirst().orElse(null);

        this.getAll().remove(old);
        this.getAll().add(group);

        return group;
    }

    @Override
    public Group delete(int id) {
        Group group = this.get(id);
        this.getAll().remove(group);
        return group;
    }

    @Override
    public List<Group> getAll() {
        return this.dataSource.getGroups();
    }
}
