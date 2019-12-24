package test;

import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ArendovatPage;
import page.HomePage;
import service.*;

import java.util.List;

public class ArendovatPageTest {
    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getRootLogger();
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

//    @Test
//    public void bookingPickupWrongTime() {
//        User user = UserCreator.withCredentialsFromProperty();
//        Location loc = new Location("Belarus", "Minsk", "Bsu");
//        Date date = new Date("26.12.2019", "27.12.2019");
//        Age age = new Age(20);
//        String errorMessage = new ArendovatPage(driver)
//                .openPage()
//                .selectLocation(loc)
//                .inputBeginRentDate(date.getDateNow().plusDays(2))
//                .inputFinishRentDate(date.getDateNow().plusDays(2))
//                .setAge(age)
//                .getErrorMessage();
//
//        Assert.assertEquals(errorMessage, ERROR_MESSAGE_BOOK_DATE_ORDER);
//        logger.log(Level.INFO, "Impossible to book before now");
//    }
//
//    @Test
//    public void impossiblePlacesForBooking() {
//        ArendovatPage page = new ArendovatPage(driver).openPage();
//        Location loc = LocationCreator.infoLocation();
//        page.openPage()
//                .selectLocation(loc)
//                .selectCar();
//        Assert.assertEquals("Sorry! No Budget locations are available in address provided.!",
//                page.getErrorMessage());
//        logger.log(Level.INFO, "Impossible place to book ");
//    }
//
//    @Test
//    public void cannotBeReturnedOnTheSameDayAtTheSameTime() {
//        ArendovatPage page = new ArendovatPage(driver).openPage();
//        Date date = DateCreator.infoDate();
//        Location loc = LocationCreator.infoLocation();
//        page.openPage()
//                .selectLocation(loc)
//                .inputBeginRentDate(date.getDateNow().plusDays(2))
//                .inputFinishRentDate(date.getDateNow().plusDays(2))
//                .clickSearchButton()
//        Assert.assertEquals("Pick-up Date cannot be after Return Date.",
//                page.getErrorMessage());
//        logger.log(Level.INFO, "Cant return car at the day rent");
//    }





}