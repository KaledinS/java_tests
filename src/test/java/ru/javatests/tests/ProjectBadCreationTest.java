package ru.javatests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.javatests.model.ProjectData;

public class ProjectBadCreationTest extends TestBase {
    @BeforeMethod
    public void insurePrecondition() {
        ProjectData project = new ProjectData("project", "description");
        app.goTo().projectManage();
        if (!app.project().isThereProject()) {
            app.project().create(project);
        }
    }

    @Test
    public void testBadProjectCreation() {
        app.project().badCreate();
    }
}
