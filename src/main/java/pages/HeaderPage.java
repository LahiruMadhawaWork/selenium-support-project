package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    // 1. By Locator: page objects: OR
    private By dropDownUserMenu = By.cssSelector(".oxd-userdropdown-icon");
    private By linkLogout = By.linkText("Logout");

    public void performLogout() {
        clickUserMenuDropDown();
        clickLogoutLink();
    }
    public void clickUserMenuDropDown() {
        driver.findElement(this.dropDownUserMenu).click();
    }
    public void clickLogoutLink() {
        driver.findElement(this.linkLogout).click();
    }
}
