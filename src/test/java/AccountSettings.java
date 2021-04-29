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

class AccountSettings extends PageBase {

    private By editProfileButtonBy = By.xpath("//div[@class='redesign']/div[@class='pagecontent']/div/div[1]/div[@class='article']/div[1]/ul/li[1]/a");
    private By personalDetailsButtonBy = By.xpath("//div[@class='redesign']/div[@class='pagecontent']/div/div[1]/div[@class='article']/div[1]/ul/li[3]/a");

    public AccountSettings(WebDriver driver) {
        super(driver);
    }

    public EditProfile openEditProfile() {
        this.waitAndReturnElement(editProfileButtonBy).click();

        return new EditProfile(this.driver);
    }

    public PersonalDetails openPersonalDetails() {
        this.waitAndReturnElement(personalDetailsButtonBy).click();

        return new PersonalDetails(this.driver);
    }


}