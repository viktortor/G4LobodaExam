package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPageWithHeader{
    @FindBy(xpath = ".//*[@name='login']")
    private WebElement buttonLogIn;
    @FindBy(id="username")
    private WebElement inputUserName;
    @FindBy(id="password")
    private WebElement inputPassWord;



    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/my-account/";
    }

    public LoginPage checkIsRedirectToLoginPagePage(){
        checkUrl();
        Assert.assertTrue("LoginPage is not displayed"
                , isElementDisplayed(buttonLogIn));
        return this;
    }

    public LoginPage enterLoginIntoInputUserName(String login) {
        enterTextInToElement(inputUserName, login);
        return this;
    }

    public LoginPage enterPassWordIntoInputPassWord(String passWord) {
        enterTextInToElement(inputPassWord, passWord);
        return this;
    }

    public MyAccountPage clickOnButtonLogIn(){
        clickOnElement(buttonLogIn);
        return new MyAccountPage(webDriver);
    }

    public MyAccountPage loginWithValidCred(){
        openLoginPage();
        enterLoginIntoInputUserName(TestData.VALID_LOGIN);
        enterPassWordIntoInputPassWord(TestData.VALID_PASS);
        clickOnButtonLogIn();
        return new MyAccountPage(webDriver);
    }

    private void openLoginPage() {
        try {
            webDriver.get(baseUrl + "/my-account/");
            logger.info("Login Page was opened");

        }catch (Exception e){
            logger.error("Can not open Login Page" + e);
            Assert.fail("Can not open Login Page" + e);
        }
    }

}
