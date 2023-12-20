package tests;

import dto.Project;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.junit.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        loginPage.openPage();
        loginPage.login("chernookaya.antonina@gmail.com", "RjirfVehrf!23456");
        projectListPage.waitUntilOpened();
        //String projectName = faker.name().firstName() + faker.name().lastName();
    }

    @Test
    public void createProject() {
        loginPage.openPage();
        loginPage.login("chernookaya.antonina@gmail.com", "RjirfVehrf!23456");
        projectListPage.waitUntilOpened();
        Project project = new Project("Test1", "test1", "my new project");
        projectListPage.createProject(project);
        projectPage.waitUntilOpen();
        assertTrue(projectPage.getTitle().contains("TEST1 repository"));
        }

    /*@Test(description = "Delete project from Project list page")
    public void deleteProjectFromList() {
        loginPage.openPage();
        loginPage.login("chernookaya.antonina@gmail.com", "RjirfVehrf!23456");
        projectListPage.waitUntilOpened();
        Project project = new Project("Test1", "test1", "my new project");
        projectListPage.deleteProject(project.getProjectName());
    }*/
}
