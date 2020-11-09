package ru.tsum.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.tsum.pages.LoginPage;
import ru.tsum.steps.BaseSteps;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(SerenityRunner.class)
public class Authentication {

    @Managed(driver = "chrome")
    WebDriver driver;

    LoginPage loginPage;

    @Steps
    public BaseSteps baseSteps;

    @Title("Зарегистрировать нового пользователя с логином test и паролем test123")
    @Test
    public void test01() {
        baseSteps.openSite();
        new WebDriverWait(driver,10).until(titleContains("Онлайн каталог интернет магазина ЦУМ - Вход"));
        baseSteps.click("//p[contains(text(),'Авторизация')]");
        baseSteps.logIn("test", "12345678");
        baseSteps.click("//button[contains(text(),'Войти')]");

        baseSteps.checkTextError("Указан некорректный email");
    }
    @Title("Зарегистрировать нового пользователя с логином test@test.ru и паролем 1")
    @Test
    public void test02() {
        baseSteps.openSite();
        new WebDriverWait(driver,10).until(titleContains("Онлайн каталог интернет магазина ЦУМ - Вход"));
        baseSteps.click("//p[contains(text(),'Регистрация')]");
        baseSteps.logIn("test@test.ru", "123");
        baseSteps.click("//button[contains(text(),'Зарегистрироваться')]");
        baseSteps.checkTextError("Пароль должен быть не менее 8 символов длиной");

    }

}
