package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage extends ParentPage {
    @FindBy(xpath = ".//div[@class='main-header' and text()='Radio Button']")
    private WebElement inputTitle;

    @FindBy(xpath = ".//*[@class='custom-control-label' and @for='yesRadio']")
    private WebElement inputYesRadio;

    @FindBy(xpath = ".//span[@class='text-success']")
    private WebElement textSuccess;

    public RadioButtonPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/radio-button";
    }

    public RadioButtonPage checkIsRedirectToRadioButtonPage() {
        checkUrl();
        Assert.assertTrue("InputTitle is not displayed"
                , isElementDisplayed(inputTitle));
        return this;
    }

    public RadioButtonPage chooseYes() {
        clickOnElement(inputYesRadio);
        return this;
    }

    public RadioButtonPage checkIsTextSuccesDisplayed() {
        Assert.assertTrue("Text about success is not displayed", isElementDisplayed(textSuccess));
        return this;
    }
}
