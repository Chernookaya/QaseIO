package pages;

import com.codeborne.selenide.Condition;
import dto.Project;
import dto.Suite;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SuitePage extends BasePage {
    public static final String SUITE_TITLE_CSS = "#title";
    public static final String CREATE_BUTTON_CSS = "button[type='submit']";
    public static final String MODAL_SUCCESS_XPATH = "//div[@class='nlvny_']";
    public static final String CREATE_NEW_SUITE_BUTTON = "#create-suite-button";


    public SuitePage isPageOpened() {
        $(CREATE_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    /*public SuitePage openPage(String code) {

        open(String.format(SUITE_URI, code));
        return this;
    }*/

    public SuitePage createNewSuiteButtonClick() {
        $(byText(CREATE_NEW_SUITE_BUTTON)).click();
        return this;
    }

    public String getTitle() {
        return $(By.xpath("//a[text()='Test4']")).getText();
    }

    public SuitePage createNewSuite (Suite suite) {
        $(CREATE_NEW_SUITE_BUTTON).click();
        $(SUITE_TITLE_CSS).setValue(suite.getSuiteName());
        $(CREATE_BUTTON_CSS).click();
         return this;
    }
}