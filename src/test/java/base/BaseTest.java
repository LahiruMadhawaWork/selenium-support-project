package base;

import java.time.Duration;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.chaintest.service.ChainPluginService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.AdminPage;
import pages.HeaderPage;
import pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;
    protected String browserName;
    protected String url;

    protected LoginPage loginPage;
    protected AdminPage adminPage;
    protected HeaderPage headerPage;

    @Parameters({"url", "browser"})
    @BeforeTest
    public void setUp(@Optional String urlParam, @Optional String browserParam) {
        if(browserParam!=null){
            browserName = browserParam;
            ChainPluginService.getInstance().addSystemInfo("Build#", "1.0");
            ChainPluginService.getInstance().addSystemInfo("Owner Name#", "Lahiru Madhawa");
        } else {
            browserName = "chrome";
        }
        System.out.println("browser is : " + browserName);
        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("plz supply the right browser...." + browserName);
                throw new IllegalArgumentException("WRONG BROWSER : " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        if(urlParam!=null) {
            url = urlParam;
        } else {
            url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        }
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        headerPage = new HeaderPage(driver);
        driver.get(url);
    }

    @AfterMethod
    public void attachScreenshot(ITestResult result){
        if(!result.isSuccess()){
            ChainTestListener.embed(takeScreenshot(), "image/png");
        }
    }

    /**
     * takescreenshot
     * @return
     */

    public byte[] takeScreenshot(){
       return ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.BYTES);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
