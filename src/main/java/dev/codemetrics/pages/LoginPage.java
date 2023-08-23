package dev.codemetrics.pages;

import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {
    Page page;

    public static final String URL = "https://codemetrics.dev/sign_in";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void verifyTitle(String title) {
        assertThat(page).hasTitle(title);
    }

    public void open() {
        page.navigate(URL);
    }

    public void enterEmail(String email) {
        page.fill("input[name='email']", email);
    }

    public void enterPassword(String password) {
        page.fill("input[name='password']", password);
    }

    public void clickSubmit() {
        page.click("button[type='submit']");
    }
}