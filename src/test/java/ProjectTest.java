import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        loginPage.openPage();
        loginPage.login("chernookaya.antonina@gmail.com", "RjirfVehrf!23456");
        projectsPage.waitTillOpened();
        //String projectName = faker.name().firstName() + faker.name().lastName();
    }

    @Test
        public void createProject() {
        loginPage.openPage();
        loginPage.login("chernookaya.antonina@gmail.com", "RjirfVehrf!23456");
        projectsPage.waitTillOpened();
        projectsPage.createProject("TestProject", "test", "My project");
        projectsPage.waitTillOpened();
        assertTrue(projectsPage.getTitle().contains("PR2 repository"));
    }
}
