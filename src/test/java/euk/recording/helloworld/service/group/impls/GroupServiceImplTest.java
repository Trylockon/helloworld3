package euk.recording.helloworld.service.group.impls;

import euk.recording.helloworld.DAO.group.impls.GroupDAOFakeImpl;
import euk.recording.helloworld.model.Group;
import org.hibernate.validator.internal.metadata.raw.BeanConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class GroupServiceImplTest {

    @TestConfiguration
    static class GroupServiceImplTestContextConfiguration {

        @Bean
        public GroupDAOFakeImpl groupDAOFake(){
            return new GroupDAOFakeImpl();
        }

        @Bean
        public GroupServiceImpl groupService() {
            return new GroupServiceImpl();
        }
    }

    @MockBean
    private GroupDAOFakeImpl groupDAOFake;

    @Autowired
    @MockBean
    GroupServiceImpl groupService;

    @Before
    public void setUp() {
        Group newGroup = new Group(99, "qwe", "Cur1");

        Mockito.when(groupService.getByName(newGroup.getName()))
                .thenReturn(newGroup);
    }

    @Test
    public void create() {

    }

    @Test
    public void get() {
        String name = "qwe";

        Group group = this.groupService.getByName(name);

        assertEquals(group.getName(), name);

    }

    @Test
    public void update() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getByName() {
    }
}