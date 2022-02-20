package loginTests;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class loginTest extends BaseTest {
    @Test
    public void validLoginTest(){
        mainPage.openMainPage();
        mainPage.checkIsFreeShippingDisplayed();
        mainPage.checkIsSecurePaymentDisplayed();
        mainPage.checkIs2YearsWarrantyDisplayed();
        mainPage.checkIsMoneyBack30DaysDisplayed();
        mainPage.clickOnLinkDismiss();
        mainPage.clickOnButtonMyAccount();
        loginPage.checkIsRedirectToLoginPagePage()
                .enterLoginIntoInputUserName(TestData.VALID_LOGIN)
                .enterPassWordIntoInputPassWord(TestData.VALID_PASS)
                .clickOnButtonLogIn()
                .checkIsRedirectToMyAccountPage()
                .clickOnLinkAddresses()
                .checkIsRedirectToAddressesPage()
                .openEditBillingAddressPage()
                .checkIsRedirectToEditBillingAddressPage();


    }
}
