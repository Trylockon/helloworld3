package euk.recording.helloworld.controller;

import euk.recording.helloworld.DAO.group.impls.GroupDAOFakeImpl;
import euk.recording.helloworld.model.Group;
import euk.recording.helloworld.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/group")
public class GroupController {

    @Autowired
    GroupServiceImpl groupService;

    @RequestMapping("/list")
    List<Group> showAll(){
        return groupService.getAll();
    }

    @RequestMapping("/{id}")
    Group getById(@PathVariable("id") int id){
        return groupService.get(id);
    }

    @RequestMapping("/create/{name}/{curator}")
    Group createGroup(@PathVariable("name") String name,
                      @PathVariable("curator") String curator){
        return groupService.create(new Group(name, curator));
    }

    @PostMapping("create")
    Group createGroupPost(@RequestBody Group group){
        this.groupService.create(group);
        return group;
    }

    @RequestMapping("/findAll/{name}")
    List<Group> getAllByName(@PathVariable ("name") String name){
        return groupService.getAllByName(name);
    }

    @RequestMapping("/update/{id}/{name}/{curator}")
    Group updateGroup(@PathVariable("id") int id,
                      @PathVariable("name") String name,
                      @PathVariable("curator") String curator){
        return groupService.update(new Group(id, name, curator));
    }

    @RequestMapping("/delete/{id}")
    Group deleteById(@PathVariable("id") int id){
        return groupService.delete(id);
    }
}
