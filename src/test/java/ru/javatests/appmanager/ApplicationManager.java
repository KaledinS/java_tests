package ru.javatests.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    WebDriver driver;
    private NavigationHelper navigationHelper;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String browser;
    private Properties properties;
    private SessionHelper sessionHelper;
    private ProjectHelper projectHelper;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
       String target = System.getProperty("target","local");
       properties = new Properties();
       properties.load(new FileReader(new File(String.format("src/test/properties/local.properties",target))));

        if ( browser.equals(BrowserType.CHROME)){
            driver = new ChromeDriver();
        }
        else if ( browser.equals(BrowserType.FIREFOX)){
            driver = new FirefoxDriver();
        }
        else if ( browser.equals(BrowserType.IE)){
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get(properties.getProperty("webBaseUrl"));
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        projectHelper = new ProjectHelper(driver);
        sessionHelper.login(properties.getProperty("username"), properties.getProperty("password"));
//       sessionHelper.badLogin(properties.getProperty("badUsername"), properties.getProperty("badPassword"));
        // driver.get("http://addressbook.local:8080/");

    }

    public void login(String username, String password) {

    }

public NavigationHelper goTo(){
        return navigationHelper;
}
    public SessionHelper sessionHelper(){
        return sessionHelper;
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    public ProjectHelper projectHelper(){
        return projectHelper;
    }


    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }



}
