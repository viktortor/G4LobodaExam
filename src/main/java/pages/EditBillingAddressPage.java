package pages;

import libs.TestData;
import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditBillingAddressPage extends ParentPageWithHeader{
    @FindBy(xpath = ".//*[@name='save_address']")
    private WebElement buttonSaveAddress;
    @FindBy(id="billing_first_name")
    private WebElement inputBillFirsName;
    @FindBy(id="billing_last_name")
    private WebElement inputBillLastName;
    @FindBy(id="billing_company")
    private WebElement inputBillCompanyName;
    @FindBy(xpath = ".//*[@aria-label='Country / Region']")
    private WebElement ddBillCountry;
    @FindBy(id="billing_address_1")
    private WebElement inputBillAddrFirstLine;
    @FindBy(id="billing_address_2")
    private WebElement inputBillAddrSecondLine;
    @FindBy(id="billing_postcode")
    private WebElement inputBillPostCode;
    @FindBy(id="billing_city")
    private WebElement inputBillCity;
    @FindBy(id="billing_phone")
    private WebElement inputBillPhoneNumber;
    @FindBy(id="billing_email")
    private WebElement inputBillEmail;



    public EditBillingAddressPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/my-account/edit-address/billing/";
    }

    public EditBillingAddressPage checkIsRedirectToEditBillingAddressPage(){
        checkUrl();
        Assert.assertTrue("AddressesPage is not displayed"
                , isElementDisplayed(buttonSaveAddress));
        return this;
    }

    public EditBillingAddressPage enterTextInToInputFirstName(){
        enterTextInToElement(inputBillFirsName, "FirstName " + TestData.TEST_RUN_TIMESTAMP);
        return this;
    }

    public EditBillingAddressPage enterTextInToInputLastName(){
        enterTextInToElement(inputBillLastName, "LastName " + TestData.TEST_RUN_TIMESTAMP);
        return this;
    }

    public EditBillingAddressPage enterTextInToInputBillCompanyName(){
        enterTextInToElement(inputBillCompanyName, "CompanyName " + TestData.TEST_RUN_TIMESTAMP);
        return this;
    }

    public EditBillingAddressPage enterTextInToInputBillAddrFirstLine(){
        enterTextInToElement(inputBillAddrFirstLine, "BillAddrFirstLine " + TestData.TEST_RUN_TIMESTAMP);
        return this;
    }

    public EditBillingAddressPage enterTextInToInputBillAddrSecondLine(){
        enterTextInToElement(inputBillAddrSecondLine, "BillAddrSecondLine " + TestData.TEST_RUN_TIMESTAMP);
        return this;
    }

    public EditBillingAddressPage enterTextInToInputBillPostCode(){
        enterTextInToElement(inputBillPostCode, "BillPostCode " + TestData.TEST_RUN_TIMESTAMP);
        return this;
    }

    public EditBillingAddressPage enterTextInToInputBillCity(){
        enterTextInToElement(inputBillCity, "BillCity " + TestData.TEST_RUN_TIMESTAMP);
        return this;
    }

    public EditBillingAddressPage enterTextInToInputBillPhoneNumber(){
        enterTextInToElement(inputBillPhoneNumber, TestData.TEST_RUN_TIMESTAMP);
        return this;
    }

    public EditBillingAddressPage enterTextInToInputBillEmail(){
        enterTextInToElement(inputBillEmail, "BillEmail@test.test" + TestData.TEST_RUN_TIMESTAMP);
        return this;
    }

    public AddressesPage clickOnButtonSaveAddress(){
        clickOnElement(buttonSaveAddress);
        return new AddressesPage(webDriver);
    }


}
