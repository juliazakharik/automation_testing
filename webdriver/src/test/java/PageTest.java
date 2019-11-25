import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class PageTest {
    private WebDriver driver;
    private Page page;

    @Before
    public void setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "D://drivers/chromedriver.exe");
        driver = new ChromeDriver();
        page = new Page(driver);
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
    public void auth(){
        page.auth("/html/body/div[3]/header/div/div/nav/ul[2]/li[4]/a", "123", "123");
    }
    
    @Test
    public void how(){
        page.HowToRent("/html/body/div[3]/header/div/div/nav/ul[1]/li[3]/ul/li[1]/a");
    }

}