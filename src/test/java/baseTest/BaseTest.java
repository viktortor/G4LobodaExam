package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected MyAccountPage myAccountPage;

    @Before
    public void setUp(){
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
        logger.info("Browser was closed");

    }

    private WebDriver initDriver(){
        String browser = System.getProperty("browser");
        if((browser==null) || browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }else if ("ie".equalsIgnoreCase(browser)) {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        }

        return webDriver;
    }


}
