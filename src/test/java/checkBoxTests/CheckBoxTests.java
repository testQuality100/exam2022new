package checkBoxTests;

import baseTest.BaseTest;
import org.junit.Test;

public class CheckBoxTests extends BaseTest {
    @Test
    public void checkDesktopNotesIsAvailable() {
        loginPage
                .openLoginPage()
                .clickOnCheckBoxButton();
        checkBoxPage
                .checkIsRedirectToCheckBoxPage()
                .clickDropDownMenu()
                .clickDeskTopIconCheck()
                .clickNotesIcon();
    }
}
