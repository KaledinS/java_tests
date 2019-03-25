package ru.javatests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProjectHelper extends HelperBase {
    public ProjectHelper(WebDriver driver) {
        super(driver);
    }

    public void projectCreation() {
        driver.findElement(By.cssSelector("input[value='создать новый проект']")).click();
        driver.findElement(By.id("project-name")).sendKeys("project name 7");
        click(By.id("project-view-state"));
        new Select(driver.findElement(By.id("project-view-state"))).selectByVisibleText("приватная");
        driver.findElement(By.id("project-description")).sendKeys("Описание");
        click(By.cssSelector("input[value='Добавить проект']"));
    }

    public void projectDeletion() {
        int id = getProjectId();
        driver.findElement(By.xpath("//a[@href='manage_proj_edit_page.php?project_id=" + id + "']")).click();
        click(By.cssSelector("input[value='Удалить проект']"));
        click(By.cssSelector("input[value='Удалить проект']"));
    }

    public int getProjectId() {
        List<WebElement> elements = driver.findElement(By.className("form-container"))
                .findElement(By.tagName("tbody")).findElements(By.tagName("a"));
        List<Integer> IdList = new ArrayList<>();
        for (WebElement element : elements) {
            String name = element.getAttribute("href");
            int id = Character.getNumericValue(name.charAt(name.length() - 1));
            name.charAt(name.length() - 1);
            IdList.add(id);
        }

        return IdList.get(0);
    }

    public void projectModify() {
        int id = getProjectId();
        driver.findElement(By.xpath("//a[@href='manage_proj_edit_page.php?project_id=" + id + "']")).click();
        new Select(driver.findElement(By.id("project-status"))).selectByVisibleText("выпущен");
        driver.findElement(By.id("project-enabled")).click();
        driver.findElement(By.id("project-inherit-global")).click();
        driver.findElement(By.id("project-description")).clear();
        driver.findElement(By.id("project-description")).sendKeys("Descriptiontext");
        driver.findElement(By.cssSelector("input[value='Изменить проект']")).click();

    }
    public void projectBadCreation() {
       String text = driver.findElement(By.className("form-container"))
                .findElement(By.tagName("tbody")).findElement(By.tagName("a")).getText();
        driver.findElement(By.cssSelector("input[value='создать новый проект']")).click();
        driver.findElement(By.id("project-name")).sendKeys(text);
        click(By.cssSelector("input[value='Добавить проект']"));
        isElementPresent(By.id("error-msg"));

    }
}
