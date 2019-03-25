package ru.javatests.tests;

import org.testng.annotations.Test;

public class ProjectModificationTest extends  TestBase {
    @Test
    public void tesProjectModification(){
        app.goTo().projectManage();
        app.projectHelper().projectModify();
    }
}
