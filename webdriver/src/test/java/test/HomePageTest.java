package test;

import model.Age;
import model.ErrorAlert;
import model.Location;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ArendovatPage;
import page.HomePage;
import service.AgeCreator;
import service.ErrorCreator;
import service.LocationCreator;
import service.UserCreator;

import java.util.List;

import static org.junit.Assert.*;

public class HomePageTest extends CommonConditions{
    private WebDriver driver;
    private HomePage page;
    private static final Logger LOGGER = LogManager.getRootLogger();

    @Before
    public void setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "D://drivers/chromedriver.exe");
        driver = new ChromeDriver();
        page = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @After
    public void tearDownChromeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void WrongLoginEnteredTest(){
        page.auth("123", "123");
        ErrorAlert exp = ErrorCreator.emptyError();
        Assert.assertTrue(page.checkLoginErrorMessage(exp));
    }

    @Test
    public void emptyInputLoginTest(){
        HomePage page = new HomePage(driver).openPage();
        page.clickLoginButton();
        ErrorAlert expectedError = ErrorCreator.emptyError();
        Assert.assertTrue(page.checkLoginErrorMessage(expectedError));
    }

    @Test
    public void loginToArendovatTest(){
        HomePage page = new HomePage(driver).openPage();
        page.auth("zakhrik.julia@gmail.com", "qwerty123");
        String homePageURL = page.getURL();
        ArendovatPage arendovatPage = new ArendovatPage(driver).openPage();
        String loginPageURL = arendovatPage.getURL();
        Assert.assertEquals(homePageURL, loginPageURL);
    }
//
//    @Test
//    public void checkAvailablePlaces() {
//        HomePage page = new HomePage(driver).openPage();
//        Location loc = LocationCreator.infoLocation();
//        page.selectCountry(loc.getCountry());
//        page.selectCity(loc.getCity());
//        List<String> expectedPlaces = loc;
//        List<String> actualPlaces = page.getAllCities();
//        Assert.assertEquals(expectedPlaces, actualPlaces);
//    }



}