package pages;

import libs.TestData;
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

    @FindBy(xpath = ".//*[text()='Radio Button']//..//..//li[@id='item-2']")
    private WebElement radioButton;

    @FindBy(xpath = ".//*[text()='Buttons']//..//..//li[@id='item-4']")
    private WebElement buttons;

    @FindBy(xpath = ".//*[@class='text' and text()='Check Box']")
    private WebElement checkBoxButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/text-box";
    }

    public LoginPage openLoginPage() {
        try {
            webDriver.get(baseUrl + "/text-box");
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

    public void clickOnRadioButton() {
        clickOnElement(radioButton);
    }

    public void clickOnButtons() {
        clickOnElement(buttons);
    }

    public void clickOnCheckBoxButton() {
        clickOnElement(checkBoxButton);
    }

    public LoginPage checkOutPutFullName() {
        Assert.assertTrue("FullName is incorrect", outputName.getText().contains(TestData.VALID_FULL_NAME));
        return this;
    }

    public LoginPage checkOutPutEmail() {
        Assert.assertTrue("Email is incorrect", outputEmail.getText().contains(TestData.VALID_EMAIL));
        return this;
    }

    public LoginPage checkOutPutCurrentAddress() {
        Assert.assertTrue("Current address is incorrect", outputCurrentAddress.getText().contains(TestData.VALID_CURRENT_ADDRESS));
        return this;
    }

    public LoginPage checkOutPutPermanentAddress() {
        Assert.assertTrue("Permanent address is incorrect", outputPermanentAddress.getText().contains(TestData.VALID_PERMANENT_ADDRESS));
        return this;
    }

    public LoginPage checkOutputDisplayedIsCorrect() {
        checkOutPutFullName();
        checkOutPutEmail();
        checkOutPutCurrentAddress();
        checkOutPutPermanentAddress();
        return this;
    }

}
