package test;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ArendovatPage;
import service.*;

import java.util.List;

public class ArendovatPageTest {
    private WebDriver driver;
    private ArendovatPage page;

    @Before
    public void setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "D://drivers/chromedriver.exe");
        driver = new ChromeDriver();
        page = new ArendovatPage(driver);
        driver.manage().window().maximize();
    }
    @Test
    public void rentCarTest(){
        Date date = new Date("123122",  "102931");
        Time time = new Time("102931", "1232");
        page.rentCar(date, time, new Location("Belarus", "Minsk","Bsu"));
        ErrorAlert exp = ErrorCreator.rentError();
        Assert.assertTrue(page.ageErrorMessage(exp));
    }

    @Test
    public void invalidAgeTest() {
        ArendovatPage page = new ArendovatPage(driver).openPage();
        Location location = LocationCreator.infoLocation();
        page.selectLocation(location);
        Age age = AgeCreator.infoAge();
        page.setAge(age);
        page.clickSearchButton();
        ErrorAlert expectedError = ErrorCreator.ageError();
        Assert.assertTrue(page.ageErrorMessage(expectedError));
    }

    @Test
    public void invalidDateTest() {
        ArendovatPage page = new ArendovatPage(driver).openPage();
        Location location = LocationCreator.infoLocation();
        page.selectLocation(location);
        Date date = DateCreator.infoDate();
        page.setDate(date);
        page.clickSearchButton();
        ErrorAlert expectedError = ErrorCreator.ageError();
        Assert.assertTrue(page.ageErrorMessage(expectedError));
    }


    @Test
    public void emptyInputTest() {
        ArendovatPage page = new ArendovatPage(driver).openPage();
        page.clickSearchButton();
        ErrorAlert expectedError = ErrorCreator.emptyError();
        Assert.assertTrue(page.locationErrorMessage(expectedError));
    }




}