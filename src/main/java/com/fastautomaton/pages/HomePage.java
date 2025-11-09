package com.fastautomaton.pages;

import com.fastautomaton.base.BasePage;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@aria-label='FAST.com logo']")
    public WebElement fastLogo;


    @Override
    public boolean isPageLoaded() {
        return fastLogo.isDisplayed();
    }
}
