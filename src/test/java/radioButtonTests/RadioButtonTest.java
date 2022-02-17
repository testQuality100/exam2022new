package radioButtonTests;

import baseTest.BaseTest;
import org.junit.Test;

public class RadioButtonTest extends BaseTest {
    @Test
    public void checkRadioButtonSuccess() {
        loginPage
                .openLoginPage()
                .clickOnRadioButton()
                ;

        radioButtonPage
                .checkIsRedirectToRadioButtonPage()
                .chooseYes()
                .checkIsTextSuccesDisplayed();
    }
}
