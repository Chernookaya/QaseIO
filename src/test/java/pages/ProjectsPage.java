package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {
    public static final String CREATE_NEW_PROJECT_CSS = "createButton";
    public static final String PROJECT_NAME_CSS = "#project-name";
    public static final String PROJECT_CODE_CSS = "#project-code";
    public static final String DESCRIPTION_CSS = "#description-area";
    public static final String CREATE_BUTTON_CSS = "button[type='submit']";

    public void openPage() {
        open("/projects");
    }

    public void waitTillOpened() {
        $(By.id("createButton")).shouldBe(Condition.visible);
    }

    public String getTitle() {
        return $(By.xpath("//h1")).getText();
    }

    public ProjectsPage createProjectButtonClick() {
        $(CREATE_BUTTON_CSS).click();
        return this;
    }

    public void createProject(String projectName, String projectCode, String description) {
        $(By.id(CREATE_NEW_PROJECT_CSS)).click();
        $(By.id(PROJECT_NAME_CSS)).sendKeys(projectName);
        $(By.id(PROJECT_CODE_CSS)).clear();
        $(By.id(DESCRIPTION_CSS)).sendKeys(projectCode);
        $(By.id(DESCRIPTION_CSS)).sendKeys(projectName);
        $(CREATE_BUTTON_CSS).click();
    }
}
