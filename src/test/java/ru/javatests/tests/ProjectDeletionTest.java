package ru.javatests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.javatests.model.ProjectData;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class ProjectDeletionTest extends TestBase {
    @BeforeMethod
    public void insurePrecondition() {
        ProjectData project = new ProjectData().setName("name1");
        app.goTo().projectManage();
        if (!app.project().isThereProject()) {
            app.project().create(project);
        }
    }

    @Test
    public void testProjectDeletion() {

        Set<ProjectData> before = app.project().all();
        ProjectData projectDel = before.iterator().next();;
        app.project().delete(projectDel);
        Set<ProjectData> after = app.project().all();
        assertEquals(before.size() - 1,after.size());
        before.remove(projectDel);
        assertEquals(before,after);

    }
}

