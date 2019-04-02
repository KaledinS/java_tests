package ru.javatests.tests;


import org.testng.annotations.Test;
import ru.javatests.model.ProjectData;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class ProjectCreationTest extends TestBase {
    @Test
    public void testProjectCreation() {

        app.goTo().projectManage();
        Set<ProjectData> before = app.project().all();
        ProjectData project = new ProjectData().setName("name12255557115");
        app.project().create(project);
        Set<ProjectData> after = app.project().all();
        assertEquals(before.size() + 1, after.size());
        project.setId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(project);
        assertEquals(before,after);
    }
}
