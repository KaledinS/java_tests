package ru.javatests.tests;

import org.testng.annotations.Test;

public class ProjectCreationTest extends TestBase {
    @Test
    public void testProjectCreation(){

       app.goTo().projectManage();
       app.projectHelper().projectCreation();
    }



}
