package org.stepdefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import dev.codemetrics.pages.ProjectsPage;
import dev.codemetrics.pages.LoginPage;
import utils.ConfigLoader;

public class LoginCucumberTest {
    Playwright playwright = Playwright.create();
    BrowserType chromium = playwright.chromium();
    Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(true));
    Page page = browser.newPage();

    LoginPage loginPage = new LoginPage(page);
    ProjectsPage projectsPage = new ProjectsPage(page);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.open();
        loginPage.verifyTitle("CodeMetrics");
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickSubmit();
    }

    @Then("I should see the list of projects")
    public void iShouldSeeTheListOfProjects() {
        projectsPage.containsCorrectHeaderTitle();
    }

    @When("I fill the form with valid credentials")
    public void iFillTheFormWithValidCredentials() {
        String username = ConfigLoader.getUsername();
        String password = ConfigLoader.getPassword();

        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }
}
