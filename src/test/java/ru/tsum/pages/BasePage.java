package ru.tsum.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends PageObject {

    @FindBy(tagName = "title")
    private WebElement title;


    public String getTitle() {
        return title.getText();
    }
}
