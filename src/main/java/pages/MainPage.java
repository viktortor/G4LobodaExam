package pages;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Assert;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPageWithHeader{
    @FindBy(xpath = ".//*[text()='FREE SHIPPING']")
    private WebElement textFreeShipping;
    @FindBy(xpath = ".//*[text()='Secure payment']")
    private WebElement textSecurePayment;
    @FindBy(xpath = ".//*[text()='2 Years Warranty']")
    private WebElement text2YearsWarranty;
    @FindBy(xpath = ".//*[text()='Money back 30 days']")
    private WebElement textMoneyBack30Days;

    public MainPage(WebDriver webDriver){
        super(webDriver);
    }

    @Rule
    public JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public void openMainPage(){
        try {
            webDriver.get(baseUrl + "/");
            logger.info("Main Page was opened");

        }catch (Exception e){
            logger.error("Can not open Main Page" + e);
            Assert.fail("Can not open Main Page" + e);
        }
    }


    public void checkIsFreeShippingDisplayed() {
        Assert.assertTrue("FreeShipping service is not displayed", isElementDisplayed(textFreeShipping));
    }

    public void checkIsSecurePaymentDisplayed() {
        Assert.assertTrue("SecurePayment service is not displayed", isElementDisplayed(textSecurePayment));
    }

    public void checkIs2YearsWarrantyDisplayed() {
        Assert.assertTrue("2YearsWarranty service is not displayed", isElementDisplayed(text2YearsWarranty));
    }

    public void checkIsMoneyBack30DaysDisplayed() {
        Assert.assertTrue("MoneyBack30Days service is not displayed", isElementDisplayed(textMoneyBack30Days));
    }



}
