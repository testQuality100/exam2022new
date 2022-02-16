package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@id='userName']")
    private WebElement inputFullName;

    @FindBy(xpath = ".//input[@id='userEmail']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//textarea[@id='currentAddress']")
    private WebElement textAreaCurrentAddress;

    @FindBy(xpath = ".//textarea[@id='permanentAddress']")
    private WebElement textAreaPermanentAddress;

    @FindBy(xpath = ".//button[@id='submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = ".//*[@id='name']")
    private WebElement outputName;

    @FindBy(xpath = ".//*[@id='email']")
    private WebElement outputEmail;

    @FindBy(xpath = ".//*[@id='currentAddress' and @class='mb-1']")
    private WebElement outputCurrentAddress;

    @FindBy(xpath = ".//*[@id='permanentAddress' and @class='mb-1']")
    private WebElement outputPermanentAddress;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }

    public LoginPage openLoginPage() {
        try {
            webDriver.get(baseUrl + "/");
            logger.info("LoginPage was open");
        } catch (Exception e) {
            logger.error("Cannot open LoginPage " + e);
            Assert.fail("Cannot open LoginPage " + e);
        }
        return this;
    }

    public LoginPage enterFullNameInoInputFullName(String fullName) {
        enterTextIntoElement(inputFullName, fullName);
        return this;
    }

    public LoginPage enterEmailInoInputEmail(String email) {
        enterTextIntoElement(inputEmail, email);
        return this;
    }

    public LoginPage enterCurrentAddressIntoCurrentAddress(String currentAddress) {
        enterTextIntoElement(textAreaCurrentAddress, currentAddress);
        return this;
    }

    public LoginPage enterPermanentAddressIntoPermanentAddress(String permanentAddress) {
        enterTextIntoElement(textAreaPermanentAddress, permanentAddress);
        return this;
    }

    public void clickOnButtonSubmit() {
        clickOnElement(buttonSubmit);
    }

    public LoginPage clickOnEnter() {
        clickEnter(buttonSubmit);
        return this;
    }

    public LoginPage checkIsOutputDisplayed() {

        Assert.assertTrue("Output is not displayed", isElementDisplayed(outputName));
        Assert.assertTrue("Output is not displayed", isElementDisplayed(outputEmail));
        Assert.assertTrue("Output is not displayed", isElementDisplayed(outputCurrentAddress));
        Assert.assertTrue("Output is not displayed", isElementDisplayed(outputPermanentAddress));
        return this;
    }

}
