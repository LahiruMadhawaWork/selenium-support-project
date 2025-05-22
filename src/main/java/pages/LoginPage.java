package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 1. By Locator: page objects: OR
    private By txtEmailId = By.name("username");
    private By txtPassword = By.name("password");
    private By btnLogin = By.cssSelector(".oxd-button");

    public void performLogin(String strUsername, String strPassword) {
        enterUsername(strUsername);
        enterPassword(strPassword);
        clickLogin();
    }
    public void enterUsername(String strUsername) {
        driver.findElement(this.txtEmailId).sendKeys(strUsername);
    }
    public void enterPassword(String strPassword) {
        driver.findElement(this.txtPassword).sendKeys(strPassword);
    }
    public void clickLogin() {
        driver.findElement(this.btnLogin).click();
    }
}
