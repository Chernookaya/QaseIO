import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectsPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    LoginPage loginPage;
    ProjectsPage projectsPage;
    Faker faker;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://app.qase.io";
        open();
        getWebDriver().manage().window().maximize();

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        faker = new Faker();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}