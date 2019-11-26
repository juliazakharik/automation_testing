package test;

import model.Error;
import model.Location;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;
import service.ErrorCreator;
import service.LocationCreator;

import static org.junit.Assert.*;

public class HomePageTest extends CommonConditions{
    private WebDriver driver;
    private HomePage page;

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
    public void authForm(){
        page.auth("123", "123");
        Error exp = ErrorCreator.emptyErrorWithInfoFromPropety();
        Assert.assertTrue(page.checkAgeErrorMessage(exp));
    }


}