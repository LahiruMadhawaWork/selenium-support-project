package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import com.aventstack.chaintest.generator.ChainTestPropertyKeys;
import com.aventstack.chaintest.service.ChainPluginService;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginTest extends BaseTest {
    @Test
    public void loginTestPOM() {
        loginPage.performLogin("Admin", "admin123");
        adminPage.clickAdminLink();
        headerPage.performLogout();
    }

    @Test
    public void loginTestLinear() {
        // Test name: LoginTest
        // Step # | name | target | value
        // 1 | open | /web/index.php/auth/login |
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // 2 | setWindowSize | 1238x676 |
        //driver.manage().window().setSize(new Dimension(1238, 676));
        // 3 | type | name=username | Admin
        driver.findElement(By.name("username")).sendKeys("Admin");
        // 4 | type | name=password | admin123
        driver.findElement(By.name("password")).sendKeys("admin123");
        // 5 | click | css=.oxd-button |
        driver.findElement(By.cssSelector(".oxd-button")).click();
        // 6 | click | linkText=Admin |
        driver.findElement(By.linkText("Admin")).click();
        // 7 | mouseOver | linkText=Admin |
        {
            WebElement element = driver.findElement(By.linkText("Admin"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        // 8 | mouseOut | linkText=Admin |
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        // 9 | click | css=.oxd-userdropdown-icon |
        driver.findElement(By.cssSelector(".oxd-userdropdown-icon")).click();
        // 10 | doubleClick | css=.oxd-userdropdown-icon |
        {
            WebElement element = driver.findElement(By.cssSelector(".oxd-userdropdown-icon"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        // 11 | click | linkText=Logout |
        driver.findElement(By.linkText("Logout")).click();
    }
}
