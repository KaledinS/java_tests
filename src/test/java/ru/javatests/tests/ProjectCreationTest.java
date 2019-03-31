package ru.javatests.tests;


import org.testng.annotations.Test;
import ru.javatests.model.ProjectData;

import java.util.List;

import static org.testng.Assert.*;

public class ProjectCreationTest extends TestBase {
    @Test
    public void testProjectCreation() {
        ProjectData project = new ProjectData("NewProject25", "description");
        app.goTo().projectManage();
        List<ProjectData> before = app.project().list();
        app.project().create(project);
        List<ProjectData> after = app.project().list();
        assertEquals(before.size() + 1, after.size());
    }
}
