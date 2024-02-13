package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPage extends BasePage {
    public static final By CREATE_BUTTON_CSS = By.id("createButton");
    public static final String CREATE_NEW_PROJECT_CSS = "createButton";
    public static final String PROJECT_NAME_CSS = "project-name";
    public static final String PROJECT_CODE_CSS = "project-code";
    public static final String DESCRIPTION_CSS = "description-area";
    public static final String PUBLIC_ACCESS_CSS = "[value=public]";
    public static final String PRIVATE_ACCESS_CSS = "[value=private]";
    public static final String CREATE_PROJECT_BTN_CSS = "button[type='submit']";
    private static final String NEW_SUITE_BUTTON = "create-suite-button";

    public ProjectPage isPageOpened() {
        $(NEW_SUITE_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public void waitUntilOpen() {
        $(By.id("create-suite-button")).shouldBe(Condition.visible);
    }

    public String getTitle() {
        return $(By.xpath("//h1")).getText();
    }
}
