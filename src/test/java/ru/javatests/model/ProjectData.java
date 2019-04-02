package ru.javatests.model;


import java.util.Objects;

public class ProjectData {

    private int id;
    private String name;
    private String description;

    public ProjectData setId(int id) {
        this.id = id;
        return this;
    }

    public ProjectData setName(String name) {
        this.name = name;
        return this;
    }


    public ProjectData setDescription(String description) {
        this.description = description;
        return this;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "ProjectData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectData that = (ProjectData) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
