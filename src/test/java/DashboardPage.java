import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
// import jdk.javadoc.internal.tool.Main;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class DashboardPage extends PageBase {

    // private By mainCardBy = By.xpath("//div[@class='Card-content']/div/div/h2/span");
    private By userDivBy = By.xpath("//div[@class='ipc-button__text']/span[@class='imdb-header__account-toggle--logged-in imdb-header__accountmenu-toggle navbar__user-name navbar__user-menu-toggle__name navbar__user-menu-toggle--desktop']");
    // private By yourActivityUserDivBy = By.xpath();
    private By usernameButtonBy = By.xpath("//span[@class='imdb-header__account-toggle--logged-in imdb-header__accountmenu-toggle navbar__user-name navbar__user-menu-toggle__name navbar__user-menu-toggle--desktop']"); 
    private By logoutButtonBy = By.xpath("//a[@class='ipc-list__item imdb-header-account-menu__sign-out']");
    private By accountSettingsButtonBy = By.xpath("//ul[@class='ipc-list imdb-header__account-menu ipc-list--baseAlt']/a[position()=6]");
    
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getUsername() {
        return this.waitAndReturnElement(userDivBy).getText();
    }

    public MainPage logout() {
        this.waitAndReturnElement(usernameButtonBy).click();
        this.waitAndReturnElement(logoutButtonBy).click();
        return new MainPage(this.driver);
    }

    public AccountSettings openAccountSettings() {
        this.waitAndReturnElement(usernameButtonBy).click();
        this.waitAndReturnElement(accountSettingsButtonBy).click();
        return new AccountSettings(this.driver);

    }
    
    // public String getMainCardTitle(){
    //     return this.waitAndReturnElement(mainCardBy).getText();
    // }
}
