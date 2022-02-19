package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends ParentPageWithHeader{
    @FindBy(xpath = ".//*[text()='Logout']")
    private WebElement linkLogOut;


    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/my-account/";
    }

    public MyAccountPage checkIsRedirectToMyAccountPage(){
        checkUrl();
        Assert.assertTrue("MyAccount is not displayed"
                , isElementDisplayed(linkLogOut));
        return this;
    }
}
