package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    private WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    // 1. By Locator: page objects: OR
    private By linkAdmin = By.linkText("Admin");

    public void clickAdminLink() {
        driver.findElement(this.linkAdmin).click();
    }
}
