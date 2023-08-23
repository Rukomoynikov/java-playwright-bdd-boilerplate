package dev.codemetrics.pages;

import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    Page page;

    public static final String URL = "https://codemetrics.dev";

    public HomePage(Page page) {
        this.page = page;
    }

    public void verifyTitle(String title) {
        assertThat(page).hasTitle(title);
    }
}