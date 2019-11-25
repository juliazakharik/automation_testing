import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Page {
    private final String HOMEPAGE_URL = "https://rentride.ru/";
    private final int WAIT_TIMEOUT_SECONDS = 20;

    private WebDriver driver;
    private WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        driver.get(HOMEPAGE_URL);
        driver.manage().window().setSize(new Dimension(1700, 1000));
        driver.navigate().refresh();
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @FindBy(xpath = "/html/body/div[3]/header/div/div/nav/ul[2]/li[4]/a")
    private WebElement loginForm;

    @FindBy(xpath = "//*[@id='login-user-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='login-user-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-user']/form/div/div[2]/div/input[2]")
    private WebElement loginButton;

    @FindBy(xpath ="/html/body/div[3]/header/div/div/nav/ul[1]/li[3]/a")
    private WebElement infoButton;

    @FindBy(xpath ="/html/body/div[3]/header/div/div/nav/ul[1]/li[3]/ul/li[1]/a")
    private WebElement howToRent;

    public void openLoginForm(String loginForm) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement login = driver.findElement(By.xpath(loginForm));
        login.click();
    }

    public void inputEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        emailInput.submit();
    }

    public void inputPass(String pass) {
        passwordInput.clear();
        passwordInput.sendKeys(pass);
        passwordInput.submit();
    }


    public void clickLoginButton() {
        loginButton.click();
    }

    public void moveToInfoButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(infoButton).build().perform();
    }

    public void HowToRent(String howToRent){
        moveToInfoButton();
        WebElement how = driver.findElement(By.xpath(howToRent));
        how.click();
    }

    public void auth(String login, String email, String pass){
        openLoginForm(login);
        inputEmail(email);
        inputPass(pass);
        clickLoginButton();
    }

}
