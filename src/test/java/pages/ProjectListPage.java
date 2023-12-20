package pages;

import com.codeborne.selenide.Condition;
import dto.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectListPage extends BasePage {
    public static final By CREATE_BUTTON_CSS = By.id("createButton");
    public static final String CREATE_NEW_PROJECT_CSS = "createButton";
    public static final String PROJECT_NAME_CSS = "#project-name";
    public static final String PROJECT_CODE_CSS = "#project-code";
    public static final String DESCRIPTION_CSS = "#description-area";
    public static final String PUBLIC_ACCESS_CSS = "[value=public]";
    public static final String CREATE_PROJECT_CSS = "button[type='submit']";


    public void waitUntilOpened() {
        $(By.id("createButton")).shouldBe(Condition.visible);
    }

    public ProjectListPage isPageOpened() {
        $(CREATE_NEW_PROJECT_CSS).shouldBe(Condition.visible);
        return this;
    }

    public ProjectListPage createNewProjectButtonClick() {
        $(CREATE_BUTTON_CSS).click();
        return this;
    }

    public ProjectListPage createProject(Project project) {
        $(CREATE_BUTTON_CSS).click();
        $(PROJECT_NAME_CSS).setValue(project.getProjectName());
        $(PROJECT_CODE_CSS).clear();
        $(PROJECT_CODE_CSS).setValue(project.getProjectCode());
        $(DESCRIPTION_CSS).clear();
        $(DESCRIPTION_CSS).setValue(project.getDescription());
        $(PUBLIC_ACCESS_CSS).click();
        $(CREATE_PROJECT_CSS).click();
        return this;
    }
}