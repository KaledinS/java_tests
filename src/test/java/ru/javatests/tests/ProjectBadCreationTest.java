package ru.javatests.tests;

import org.testng.annotations.Test;

public class ProjectBadCreationTest extends TestBase {
    @Test
    public void testBadProjectCreation(){
        app.goTo().projectManage();
        app.projectHelper().projectBadCreation();
    }
}
