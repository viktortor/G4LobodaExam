package addressesTest;

import baseTest.BaseTest;
import org.junit.Test;
import pages.MainPage;

public class EditBillingAddressTest extends BaseTest {
    @Test
    public void successfulEditingBilAddr(){
        mainPage.openMainPage();
        mainPage.clickOnLinkDismiss();
        loginPage.loginWithValidCred()
                .clickOnLinkAddresses()
                .checkIsRedirectToAddressesPage()
                .openEditBillingAddressPage()
                .checkIsRedirectToEditBillingAddressPage()
                .enterTextInToInputFirstName()
                .enterTextInToInputLastName()
                .enterTextInToInputBillCompanyName()
                .enterTextInToInputBillAddrFirstLine()
                .enterTextInToInputBillAddrSecondLine()
                .enterTextInToInputBillPostCode()
                .enterTextInToInputBillCity()
                .enterTextInToInputBillPhoneNumber()
                .enterTextInToInputBillEmail()
                .clickOnButtonSaveAddress()
                .checkIsRedirectToAddressesPage();


    }

}
