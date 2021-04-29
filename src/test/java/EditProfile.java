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

class EditProfile extends PageBase {

    private By bioElementBy = By.xpath("//textarea[@class='multiline']");
    private By saveDescButtonBy = By.xpath("//div[@class='user-bio-actions']/div[@class='auth-button-link auth-button--primary']");


    public EditProfile(WebDriver driver) {
        super(driver);
    }

    public String getBio() {
        return this.waitAndReturnElement(bioElementBy).getText();
    }

    public AccountSettings setBio(String str) {
        this.waitAndReturnElement(bioElementBy).clear();
        this.waitAndReturnElement(bioElementBy).sendKeys(str);
        this.waitAndReturnElement(saveDescButtonBy).click();
        return new AccountSettings(this.driver);
    }


}