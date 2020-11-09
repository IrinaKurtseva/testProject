package ru.tsum.pages;

import gherkin.deps.com.google.gson.annotations.SerializedName;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("https://www.tsum.ru/")
public class LoginPage extends BasePage{

    @FindBy(css = "input[formcontrolname='email']")
    WebElement txtEmail;

    @FindBy(css = "input[formcontrolname='password']")
    WebElement txtPassword;

    public void login(String email, String password) {
        waitFor(txtEmail).sendKeys(email);
        waitFor(txtPassword).sendKeys(password);
    }
}
