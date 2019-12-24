package page;

import model.ErrorAlert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage{
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String HOMEPAGE_URL =
            "https://rentride.ru/";
    private Logger log = LogManager.getRootLogger();

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        LOGGER.info("Created HomePage");
    }

    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        LOGGER.info("Home page opened");
        return this;
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

    @FindBy(xpath = "//*[@id=\"login-error\"]")
    private WebElement loginError;

    @FindBy(className = "link-location js-popup-regions")
    private WebElement getCities;



    public void openLoginForm() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginForm.click();
        log.info("Login form is opened");
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
        log.info("Trying to log");
    }

    public String getURL(){
        String URL = HOMEPAGE_URL;
        return URL;
    }

    public void moveToInfoButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(infoButton).build().perform();
    }

    public void HowToRent(){
        moveToInfoButton();
        howToRent.click();
    }

    public void auth(String email, String pass){
        openLoginForm();
        inputEmail(email);
        inputPass(pass);
        clickLoginButton();
    }

    public boolean checkLoginErrorMessage(ErrorAlert error) {
        return loginError.isDisplayed()
                && loginError.getText().
                contains(error.getErrorDescription());
    }

    public List<String> getAllCities() {
        List<WebElement> cities = new Select(getCities).getOptions();
        List<String> s = new ArrayList<>();
        Iterator<WebElement> itr = cities.iterator();
        while (itr.hasNext()) {
            String city = itr.next().getText();
            s.add(itr.next().getText());
            LOGGER.debug("City: " + city);
        }
        return s;
    }
}
