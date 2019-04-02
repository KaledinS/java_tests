package ru.javatests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.javatests.model.ProjectData;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class ProjectModificationTest extends  TestBase {
    @BeforeMethod
    public void insurePrecondition() {
        ProjectData project = new ProjectData().setName("name1");
        app.goTo().projectManage();
        if (!app.project().isThereProject()) {
            app.project().create(project);
        }
    }
    @Test
    public void tesProjectModification(){

        Set<ProjectData> before = app.project().all();
        ProjectData projectMod = before.iterator().next();
        ProjectData project = new ProjectData().setId(projectMod.getId()).setName("newName1").setDescription("newDescription");
        app.project().modify(project);
        Set<ProjectData> after = app.project().all();
        assertEquals(before.size(),after.size());
        before.remove(projectMod);
        before.add(project);
        assertEquals(before,after);
    }
}
