package buttonsTest;

import baseTest.BaseTest;
import org.junit.Test;

public class ButtonsTest extends BaseTest {
    @Test
    public void checkButtonsDoubleClick() {
        loginPage
                .openLoginPage()
                .moveToElement();
        loginPage.clickOnButtons();
        buttonsPage
                .checkIsRedirectToButtonsPage()
                .doubleClickElement()
                .checkDoubleClickMessageIsDisplayed();
    }

    @Test
    public void checkButtonsRightClick() {
        loginPage
                .openLoginPage()
                .moveToElement();
        loginPage.clickOnButtons();
        buttonsPage
                .checkIsRedirectToButtonsPage()
                .rightClickButton()
                .checkRightClickMessageIsDisplayed();
    }

    @Test
    public void checkDynamicClickButton() {
        loginPage
                .openLoginPage()
                .moveToElement();
        loginPage.clickOnButtons();
        buttonsPage
                .checkIsRedirectToButtonsPage()
                .dynamicClickElement()
                .checkDynamicClickMessageIsDisplayed();
    }
}
