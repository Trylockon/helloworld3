package euk.recording.helloworld.model;

import java.util.Objects;

public class Group {
    private int id;
    private String name;
    private String curatorName;

    public Group() {
    }

    public Group(String name, String curatorName) {
        this.name = name;
        this.curatorName = curatorName;
    }

    public Group(int id, String name, String curatorName) {
        this.id = id;
        this.name = name;
        this.curatorName = curatorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", curatorName='" + curatorName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id;
    }

    @Override
    public int hashCode() {
        return this.getId();
    }
}
