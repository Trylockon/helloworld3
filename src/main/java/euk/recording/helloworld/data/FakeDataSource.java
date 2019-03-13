package euk.recording.helloworld.data;

import euk.recording.helloworld.model.Group;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class FakeDataSource {
    private List<Group> groups = new ArrayList<>(
            Arrays.asList(
                    new Group(1, "bbv1", "Vova"),
                    new Group(2, "zxc2", "Ivan"),
                    new Group(3, "asd3", "Nata"),
                    new Group(4, "ghj4", "Olya")
            )
    );

    public List<Group> getGroups() {
        return groups;
    }
}
