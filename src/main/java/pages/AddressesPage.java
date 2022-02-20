package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends ParentPageWithHeader{
    @FindBy(xpath = ".//h3[text()='Billing address']")
    private WebElement billingAddressHeader;
    @FindBy(xpath = ".//h3[text()='Shipping address']")
    private WebElement shippingAddressHeader;
    @FindBy(xpath = ".//*[contains(@href,'billing')]")
    private WebElement linkEditBillingAddress;
    @FindBy(xpath = ".//*[contains(@href,'shipping')]")
    private WebElement linkEditShippingAddress;
//    @FindBy(xpath = ".//div[@role='alert' and contains(text(),’Address changed successfully.')]")
//    private WebElement successfulAlert;

    public AddressesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/my-account/edit-address/";
    }

    public AddressesPage checkIsRedirectToAddressesPage(){
        checkUrl();
        Assert.assertTrue("AddressesPage is not displayed"
                , isElementDisplayed(billingAddressHeader));
        Assert.assertTrue("AddressesPage is not displayed"
                , isElementDisplayed(shippingAddressHeader));
        return this;
    }

    public EditBillingAddressPage openEditBillingAddressPage() {
        clickOnElement(linkEditBillingAddress);
        return new EditBillingAddressPage(webDriver);
    }
}
