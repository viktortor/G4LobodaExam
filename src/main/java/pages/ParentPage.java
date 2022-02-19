package pages;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.hamcrest.CoreMatchers.containsString;

public abstract class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    WebDriverWait webDriverWait10, webDriverWait15;
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected String baseUrl = configProperties.base_url();

    public ParentPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        webDriverWait10 = new WebDriverWait(webDriver, configProperties.TIME_FOR_DEFAULT_WAIT());
        webDriverWait15 = new WebDriverWait(webDriver, configProperties.TIME_FOR_EXPLICIT_WAIT_LOW());

    }

    abstract String getRelativeUrl();

    protected void checkUrl(){
        Assert.assertEquals("Invalid page"
                , baseUrl + getRelativeUrl()
                , webDriver.getCurrentUrl());
    }

    protected void checkUrlWithPattern(){
        Assert.assertThat("Invalid page"
                , webDriver.getCurrentUrl()
                , containsString(baseUrl + getRelativeUrl()));
    }

    protected void enterTextInToElement(WebElement webElement, String text){
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted ");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement){
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info(" Element was clicked");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(String xpathLocator){
        WebElement webElement = null;
        try {
            webElement = webDriver.findElement(By.xpath(xpathLocator));
            logger.info("Element was found");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
        clickOnElement(webElement);
    }

    protected boolean isElementDisplayed(WebElement webElement){
        try {
            boolean state = webElement.isDisplayed();
            if (state){
                logger.info("Element is displayed");
            }else {
                logger.info("Element is not displayed");
            }
            return state;
        }catch (Exception e){
            logger.info("Element is not displayed");
            return false;
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }
    protected String getTextFromElement(WebElement webElement){
        try {
            String text = webElement.getText();
            logger.info("Text from Element: " + text);
            return text;
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
        return null;
    }

}
