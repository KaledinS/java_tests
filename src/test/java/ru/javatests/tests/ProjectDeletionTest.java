package ru.javatests.tests;

import org.testng.annotations.Test;
import ru.javatests.model.ProjectData;

public class ProjectDeletionTest extends TestBase {
    @Test
    public void testProjectDeletion() {
        app.goTo().projectManage();
        app.projectHelper().projectDeletion();

    }
}

