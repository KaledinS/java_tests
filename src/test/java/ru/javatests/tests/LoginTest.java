package ru.javatests.tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends TestBase {

    @Test(enabled = true)
    public  void testLogin(){

      //  app.goTo().issueList();
        String loggedUser = app.sessionHelper().loggedUser();
        String actualUser = app.getProperty("username");
        assertEquals(loggedUser,actualUser);
    }

}
