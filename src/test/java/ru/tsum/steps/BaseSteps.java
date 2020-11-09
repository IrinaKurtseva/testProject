package ru.tsum.steps;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.tsum.pages.BasePage;
import ru.tsum.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class BaseSteps extends ScenarioSteps {

    public LoginPage loginPage;

    @Step("Open site")
    public void openSite() {
        loginPage.open();
    }

    @Step("Login with email and password")
    public void logIn(String email, String password) {
        loginPage.login(email, password);
    }

    @Step("Click")
    public void click(String xpathName) {
        getDriver().findElement(By.xpath(xpathName)).click();

    }

    @Step("Check error")
    public void checkTextError(String textError) {
        assertThat("No visible notice", loginPage.containsText(textError));
    }
}
