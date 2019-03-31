package ru.javatests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.javatests.model.ProjectData;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProjectDeletionTest extends TestBase {
    @BeforeMethod
    public void insurePrecondition() {
        ProjectData project = new ProjectData("project", "description");
        app.goTo().projectManage();
        if (!app.project().isThereProject()) {
            app.project().create(project);
        }
    }

    @Test
    public void testProjectDeletion() {
        List<ProjectData> before = app.project().list();
        app.project().delete();
        List<ProjectData> after = app.project().list();
        assertEquals(before.size() - 1,after.size());

    }
}

