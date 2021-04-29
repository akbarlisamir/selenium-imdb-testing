import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class MainPage extends PageBase {

    private By signInButtonBy = By.xpath("//a[@class='ipc-button ipc-button--single-padding ipc-button--center-align-content ipc-button--default-height ipc-button--core-baseAlt ipc-button--theme-baseAlt ipc-button--on-textPrimary ipc-text-button imdb-header__signin-text']/div[@class='ipc-button__text']");
    private By signInWithIMDBButtonBy = By.xpath("//a[@class='list-group-item ']/span[@class='auth-provider-text']");
    
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.imdb.com");
    }    
    
    public LoginPage openLogin() {
        this.waitAndReturnElement(signInButtonBy).click();
        this.waitAndReturnElement(signInWithIMDBButtonBy).click();

        return new LoginPage(this.driver);
    }

    public String getSignInWordForUnloggedUsers() {
        return this.waitAndReturnElement(signInButtonBy).getText();
    }
}
