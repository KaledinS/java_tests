package ru.javatests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {

        type(By.id("username"), username);
        type(By.id("password"), password);
        click(By.className("submit-button"));
    }

    public String loggedUser() {
        return driver.findElement(By.id("logged-in-user")).getText();
    }
}