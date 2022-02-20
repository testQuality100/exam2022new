package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ButtonsPage;
import pages.CheckBoxPage;
import pages.LoginPage;
import pages.RadioButtonPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;
    protected RadioButtonPage radioButtonPage;
    protected ButtonsPage buttonsPage;
    protected CheckBoxPage checkBoxPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        logger.info("Browser was open");
        loginPage = new LoginPage(webDriver);
        radioButtonPage = new RadioButtonPage(webDriver);
        buttonsPage = new ButtonsPage(webDriver);
        checkBoxPage = new CheckBoxPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }
}
