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
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class PersonalDetails extends PageBase {

    private By genderSelectBy = By.xpath("//div[@class='pagecontent']/div[@class='redesign']/div[1]/div[1]/form/p[1]/select");
    private By submitButtonBy = By.xpath("//input[@type='submit']");

    public PersonalDetails(WebDriver driver) {
        super(driver);
    }

    public PersonalDetails setGender(int index) {
        Select gS = new Select(this.waitAndReturnElement(genderSelectBy));
        gS.selectByIndex(index);
        this.waitAndReturnElement(submitButtonBy).click();

        return new PersonalDetails(this.driver);
    }

}