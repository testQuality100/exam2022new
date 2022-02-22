package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;

    WebDriverWait webDriverWait10, webDriverWait15;

    protected String baseUrl = "https://demoqa.com";

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, 10);
        webDriverWait15 = new WebDriverWait(webDriver, 15);
    }

    abstract String getRelativeUrl();

    protected void checkUrl() {
        Assert.assertEquals("Invalid page"
                , baseUrl + getRelativeUrl()
                , webDriver.getCurrentUrl());
    }

    public void moveToElement() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("javascript:window.scrollBy(250,350)");
    }

    protected void enterTextIntoElement(WebElement webElement, String text) {
        webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            if (state == true) {
                logger.info("Element is displayed");
            } else {
                logger.info("Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void rightClickOnElement(WebElement webElement) {
        try {
            Actions actions = new Actions(webDriver);
            actions.contextClick(webElement).perform();
            logger.info("RightClick button was clicked on");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void doubleClickOnElement(WebElement webElement){
        try{
            Actions actions = new Actions(webDriver);
            actions.doubleClick(webElement).perform();
            logger.info("DoubleClick button was clicked on");
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }
}
