package ru.javatests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SessionHelper extends HelperBase {
   private ApplicationManager app;

    public SessionHelper(WebDriver driver) {
        super(driver);
    }


    public void login(String username, String password) {
//       type(By.name("user"),username);
//        type(By.name("pass"),password);
//        click(By.xpath("//input[@value='Login']"));String username, String password

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        click(By.className("submit-button"));
    }

public  String loggedUser() {
    return  driver.findElement(By.id("logged-in-user")).getText();
}



//    public void badLogin(String badUsername,String badPassword) {
////        type(By.name("user"),username);
////        type(By.name("pass"),password);
////        click(By.xpath("//input[@value='Login']"));
//
////        String badUsername = app.getProperty("badUsername");
////        String badPassword = app.getProperty("badPassword");
//        //login(app.getProperty("badUsername"), app.getProperty("badPassword"));
//        driver.findElement(By.id("username")).sendKeys(app.getProperty("badUsername"));
//        driver.findElement(By.id("password")).sendKeys(app.getProperty("badPassword"));
//        click(By.className("submit-button"));
//
//    }
//public void dg(){
//    driver.findElement(By.className("important-msg"));
//}
}