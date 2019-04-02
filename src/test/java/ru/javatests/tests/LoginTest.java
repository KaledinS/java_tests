package ru.javatests.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends TestBase {

    @Test(enabled = true)
    public void testLogin() {
        String loggedUser = app.session().loggedUser();
        String actualUser = app.getProperty("username");
        assertEquals(loggedUser, actualUser);

    }

}
