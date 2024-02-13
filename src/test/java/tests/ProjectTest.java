package tests;

import dto.Project;
import dto.ProjectFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ProjectTest extends BaseTest {

    /*@Test
    public void projectShouldBeCreated() {
        loginPage.openPage();
        loginPage.login("chernookaya.antonina@gmail.com", "RjirfVehrf!23456");
        projectListPage.waitUntilOpened();
        String projectName = faker.name().firstName() + faker.name().lastName();
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
        }*/

    @Test(description = "Create project")
    public void createProject() {
        Project project = ProjectFactory.getRandom();
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectListPage.isPageOpened();
        projectListPage.clickCreateButton();
        newProjectPage.createProject(project);
        projectListPage.open();
        projectListPage.searchProject(project.getCode());
        assertEquals(projectListPage.getProjectByTitle(project.getTitle()), project.getTitle());
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Update project")
    public void updateProject() {
        Project oldProject = ProjectFactory.getRandom();
        Project newProject = ProjectFactory.getRandom();
        projectAdapter.create(oldProject);
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectListPage.isPageOpened();
        projectListPage.updateProject(oldProject.getCode(), newProject.getTitle(), newProject.getCode());
        projectListPage.open();
        projectListPage.searchProject(newProject.getCode());
        assertEquals(projectListPage.getProjectByTitle(newProject.getTitle()), newProject.getTitle());
        projectAdapter.delete(newProject.getCode());
    }
    @Test(description = "Delete project")
    public void deleteProject() {
        Project project = ProjectFactory.getRandom();
        projectAdapter.create(project);
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectListPage.isPageOpened();
        projectListPage.searchProject(project.getCode());
        projectListPage.deleteProject(project.getTitle());
        assertEquals(driver.findElement(By.xpath("//*[text()='Looks like you don’t have any projects yet.']")).getText(),
                "Looks like you don’t have any projects yet.");
    }
}
