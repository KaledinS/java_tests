package ru.javatests.model;


import java.util.Objects;

public class ProjectData {

    public int id = Integer.MAX_VALUE;
    public String name;
    public String description;

    public ProjectData(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public ProjectData(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProjectData(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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
