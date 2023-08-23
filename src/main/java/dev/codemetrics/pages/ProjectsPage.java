package dev.codemetrics.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProjectsPage {
    Page page;

    public static final String URL = "https://codemetrics.dev/projects";

    public ProjectsPage(Page page) {
        this.page = page;
    }

    public void verifyTitle(String title) {
        assertThat(page).hasTitle(title);
    }

    public void containsCorrectHeaderTitle() {
        Locator getStarted = page.locator("h1");
        assertThat(getStarted).containsText("Projects");
    }
}