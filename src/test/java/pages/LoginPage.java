package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    final String EMAIL_CSS = "[name=email]";
    final String PASS_CSS = "[name=password]";
    final String SUBMIT_BTN_CSS = "[type=submit]";

    public void openPage() {
        open("/login");
    }

    public void login(String user, String pass) {
        $(EMAIL_CSS).sendKeys(user);
        $(PASS_CSS).sendKeys(pass);
        $(SUBMIT_BTN_CSS).click();
    }
}