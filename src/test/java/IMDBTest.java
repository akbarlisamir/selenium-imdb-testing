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
import java.util.*;  


public class IMDBTest {
    public WebDriver driver;
    
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //body texts and title test
    @Test
    public void staticMainPageTest() {
        MainPage mP = new MainPage(this.driver);

        String bodyText1 = "Up next";
        String bodyText2 = "Browse trailers";
        String bodyText3 = "Featured today";

        Assert.assertTrue(mP.getBodyText().contains(bodyText1));
        Assert.assertTrue(mP.getBodyText().contains(bodyText2));
        Assert.assertTrue(mP.getBodyText().contains(bodyText3));

        Assert.assertTrue(mP.getTitle().contains("IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows"));
    }

    @Test
    public void loginTest() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.openLogin();
        DashboardPage dashboardPage = loginPage.login("wijiyij113@laraskey.com","Samir1997");
 
        Assert.assertTrue(dashboardPage.getUsername().contains("smrkbr"));
        
        // System.out.println(dashboardPage.getUsername());
        // Assert.assertTrue(dashboardPage.getMainCardTitle().contains("Start by creating your first Doodle"));
    }

    @Test
    public void logoutTest() {
        MainPage mP = new MainPage(this.driver);
        LoginPage lP = mP.openLogin();
        DashboardPage dP = lP.login("wijiyij113@laraskey.com","Samir1997");

        Assert.assertTrue(dP.getUsername().contains("smrkbr"));

        MainPage mPLO = dP.logout();

        Assert.assertTrue(mPLO.getSignInWordForUnloggedUsers().contains("Sign In"));
    }

    @Test
    public void editProfileSetBioTest() {
        String bio = "Samir Akbarli / CSCTNP";
        MainPage mP = new MainPage(this.driver);
        LoginPage lP = mP.openLogin();
        DashboardPage dP = lP.login("wijiyij113@laraskey.com","Samir1997");
        AccountSettings aS = dP.openAccountSettings();
        EditProfile eP = aS.openEditProfile();
        AccountSettings aSAfterSettingBio = eP.setBio(bio);

        Assert.assertTrue(aSAfterSettingBio.openEditProfile().getBio().contains(bio));
    }

    @Test
    public void personalDetailsDropDownTest() {
        int gender = 2;
        MainPage mP = new MainPage(this.driver);
        LoginPage lP = mP.openLogin();
        DashboardPage dP = lP.login("wijiyij113@laraskey.com","Samir1997");
        AccountSettings aS = dP.openAccountSettings();
        PersonalDetails pD = aS.openPersonalDetails();

        PersonalDetails pDFemale = pD.setGender(gender);

        Assert.assertTrue(pDFemale.getBodyText().contains("You have successfully updated your account details!"));
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
