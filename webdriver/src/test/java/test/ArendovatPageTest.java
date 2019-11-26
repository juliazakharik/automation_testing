package test;

import model.Error;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ArendovatPage;
import page.HomePage;
import service.ErrorCreator;

import static org.junit.Assert.*;

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
        page.rentCar("123122", "1231", "102931", "1232");
        Error exp = ErrorCreator.rentErrorWithInfoFromProperty();
        Assert.assertTrue(page.checkAgeErrorMessage(exp));
    }

}