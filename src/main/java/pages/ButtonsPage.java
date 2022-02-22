package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends ParentPage {
    @FindBy(xpath = ".//*[@class='main-header']")
    private WebElement buttonsTitle;

    @FindBy(xpath = ".//button[@id='doubleClickBtn' and text()='Double Click Me']")
    private WebElement doubleClickButton;

    @FindBy(xpath = ".//p[@id='doubleClickMessage']")
    private WebElement doubleClickMessage;

    @FindBy(xpath = ".//button[@id='rightClickBtn' and text()='Right Click Me']")
    private WebElement rightClickButton;

    @FindBy(xpath = ".//p[@id='rightClickMessage']")
    private WebElement rightClickMessage;

    @FindBy(xpath = ".//button[text()='Click Me']")
    private WebElement dynamicClickButton;

    @FindBy(xpath = ".//p[@id='dynamicClickMessage']")
    private WebElement dynamicClickMessage;

    public ButtonsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/buttons";
    }

    public ButtonsPage checkIsRedirectToButtonsPage() {
        checkUrl();
        Assert.assertTrue("InputTitle is not displayed"
                , isElementDisplayed(buttonsTitle));
        return this;
    }

    public ButtonsPage doubleClickElement() {
        doubleClickOnElement(doubleClickButton);
        return this;
    }

    public ButtonsPage checkDoubleClickMessageIsDisplayed() {
        Assert.assertTrue("Double click message is not displayed"
                , isElementDisplayed(doubleClickMessage));

        return this;
    }

    public ButtonsPage rightClickButton() {
        rightClickOnElement(rightClickButton);
        return this;
    }

    public ButtonsPage checkRightClickMessageIsDisplayed() {
        Assert.assertTrue("Right click message is not displayed"
                , isElementDisplayed(rightClickMessage));

        return this;
    }

    public ButtonsPage dynamicClickElement() {
        clickOnElement(dynamicClickButton);
        return this;
    }

    public ButtonsPage checkDynamicClickMessageIsDisplayed() {
        Assert.assertTrue("Dynamic click message is not displayed"
                , isElementDisplayed(dynamicClickMessage));
        return this;
    }
}
