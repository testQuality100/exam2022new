package loginTests;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class LoginTest extends BaseTest {
    @Test
    public void validLoginTest() {
        loginPage
                .openLoginPage()
                .enterFullNameInoInputFullName(TestData.VALID_FULL_NAME)
                .enterEmailInoInputEmail(TestData.VALID_EMAIL)
                .enterCurrentAddressIntoCurrentAddress(TestData.VALID_CURRENT_ADDRESS)
                .enterPermanentAddressIntoPermanentAddress(TestData.VALID_PERMANENT_ADDRESS)
                .clickOnButtonSubmit();

        loginPage.checkIsOutputDisplayed();

    }
}
