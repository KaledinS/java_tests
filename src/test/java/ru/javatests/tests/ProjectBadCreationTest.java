package ru.javatests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.javatests.model.ProjectData;

import java.util.Set;

import static org.testng.Assert.*;

public class ProjectBadCreationTest extends TestBase {
    @BeforeMethod
    public void insurePrecondition() {
        ProjectData project = new ProjectData().setName("name1");
        app.goTo().projectManage();
        if (!app.project().isThereProject()) {
            app.project().create(project);
        }
    }

    @Test
    public void testBadProjectCreation() {
        Set<ProjectData> before = app.project().all();
        app.project().badCreate();
        assertTrue(app.project().isThereMessage());
        app.goTo().projectManage();
        Set<ProjectData> after = app.project().all();
        assertEquals(before,after);
    }

}
