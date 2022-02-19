package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class ParentPageWithHeader extends ParentPage{
    @FindBy(xpath = ".//a[text()='My Account']")
    private WebElement buttonMyAccount;
    @FindBy(xpath = ".//a[text()='Dismiss']")
    private WebElement linkDismiss;

    public ParentPageWithHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonMyAccount(){
        clickOnElement(buttonMyAccount);
    }

    public void clickOnLinkDismiss(){
        clickOnElement(linkDismiss);
    }


}
