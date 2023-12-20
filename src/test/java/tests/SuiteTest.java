package tests;

import dto.Project;
import dto.Suite;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class SuiteTest extends BaseTest {

    @Test
    public void createSuite() {
        loginPage.openPage();
        loginPage.login("chernookaya.antonina@gmail.com", "RjirfVehrf!23456");
        projectListPage.waitUntilOpened();
        Project project = new Project("Test4", "test4", "my new project");
        projectListPage.createProject(project);
        projectPage.waitUntilOpen();
        Suite suite = new Suite("Test4", "my suite", "none");
        suitePage.createNewSuite(suite);
        assert(suitePage.getTitle().contains("Test4"));
    }
}

