package ru.javatests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.javatests.model.ProjectData;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProjectModificationTest extends  TestBase {
    @BeforeMethod
    public void insurePrecondition() {
        ProjectData project = new ProjectData("project", "description");
        app.goTo().projectManage();
        if (!app.project().isThereProject()) {
            app.project().create(project);
        }
    }
    @Test
    public void tesProjectModification(){
        ProjectData project = new ProjectData("NewName 5", "descriptionTest");
        List<ProjectData> before = app.project().list();
        app.project().modify(project);
        List<ProjectData> after = app.project().list();
        assertEquals(before.size() ,after.size());
    }
}
