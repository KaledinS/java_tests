package ru.javatests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.javatests.model.ProjectData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectHelper extends HelperBase {
    public ProjectHelper(WebDriver driver) {
        super(driver);
    }

    public void initProjectCreation() {
        click(By.cssSelector("input[value='создать новый проект']"));
    }

    public void SubmitCreation() {
        click(By.cssSelector("input[value='Добавить проект']"));
    }

    public void selectProject() {
        int id = getProjectId();
        click(By.xpath("//a[@href='manage_proj_edit_page.php?project_id=" + id + "']"));
    }

    public List<Integer> getIdList() {
        List<WebElement> elements = driver.findElement(By.className("form-container"))
                .findElement(By.tagName("tbody")).findElements(By.tagName("a"));
        List<Integer> IdList = new ArrayList<>();
        for (WebElement element : elements) {
            String name = element.getAttribute("href");
            int id = Integer.parseInt(name.substring(62));
            IdList.add(id);
        }
//        Random r = new Random();
//        return IdList.get(r.nextInt(IdList.size()));
        return IdList;
    }

    public int getProjectId() {
        Random r = new Random();
        return getIdList().get(r.nextInt(getIdList().size()));
    }

    public void create(ProjectData project) {
        initProjectCreation();
        type(By.id("project-name"), project.getName());
        click(By.id("project-view-state"));
        new Select(driver.findElement(By.id("project-view-state"))).selectByVisibleText("приватная");
        type(By.id("project-description"), project.getDescription());
        SubmitCreation();
        click(By.linkText("Продолжить"));
    }

    public void delete() {
        selectProject();
        click(By.cssSelector("input[value='Удалить проект']"));
        click(By.cssSelector("input[value='Удалить проект']"));
    }


    public void modify(ProjectData project) {
        selectProject();
        type(By.id("project-name"), project.getName());
        click(By.id("project-enabled"));
        click(By.id("project-inherit-global"));
        type(By.id("project-description"), project.getDescription());
        click(By.cssSelector("input[value='Изменить проект']"));
    }

    public void badCreate() {
        String text = driver.findElement(By.className("form-container"))
                .findElement(By.tagName("tbody")).findElement(By.tagName("a")).getText();
        initProjectCreation();
        type(By.id("project-name"), text);
        SubmitCreation();
        isElementPresent(By.id("error-msg"));

    }

    public boolean isThereProject() {
        return isElementPresent(By.xpath("/html/body/div/div[4]/div[2]/table/tbody/tr/td[1]/a"));
    }

    public List<ProjectData> list() {

        List<ProjectData> projects = new ArrayList<>();
        List<WebElement> elements = driver.findElement(By.className("form-container"))
                .findElement(By.tagName("tbody")).findElements(By.tagName("a"));
        for (WebElement element : elements) {
            String name = element.getText();
            String href = element.getAttribute("href");
            int id = Integer.parseInt(href.substring(62));
            ProjectData project = new ProjectData(id, name);
            projects.add(project);
        }

        return projects;
    }


}
