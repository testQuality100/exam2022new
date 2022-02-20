package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='pattern-backgound playgound-header']")
    private WebElement checkBoxTitle;

    @FindBy(xpath = ".//button[@title='Toggle']")
    private WebElement dropDownMenu;

    @FindBy(xpath = ".//li[@class='rct-node rct-node-parent rct-node-collapsed'][1]//button")
    private WebElement deskTopIconCheck;

    @FindBy(xpath = ".//li[@class='rct-node rct-node-leaf'][1]//*[@class='rct-checkbox']")
    private WebElement notesIcon;

    @FindBy(xpath = ".//*[@class='text-success' and text()='notes']")
    private WebElement notesResultMessage;

    public CheckBoxPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/checkbox";
    }

    public CheckBoxPage checkIsRedirectToCheckBoxPage() {
        checkUrl();
        Assert.assertTrue("InputTitle is not displayed"
                , isElementDisplayed(checkBoxTitle));
        return this;
    }

    public CheckBoxPage clickDropDownMenu() {
        clickOnElement(dropDownMenu);
        return this;
    }

    public CheckBoxPage clickDeskTopIconCheck() {
        clickOnElement(deskTopIconCheck);
        return this;
    }

    public CheckBoxPage clickNotesIcon() {
        clickOnElement(notesIcon);
        Assert.assertTrue("Notes is not displayed"
                , isElementDisplayed(notesResultMessage));
        logger.info("Notes was selected in Desktop list");
        return this;
    }
}
