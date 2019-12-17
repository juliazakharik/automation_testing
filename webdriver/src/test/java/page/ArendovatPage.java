package page;

import model.Error;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ArendovatPage extends AbstractPage{
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String ARENDOVATPAGE_URL = "https://rentride.ru/arendovat/sankt-peterburg/";
    private Logger log = LogManager.getRootLogger();

    public ArendovatPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        LOGGER.info("Created Arendovat Page")
    }

    protected ArendovatPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
    }

    public ArendovatPage openPage() {
        driver.navigate().to(ARENDOVATPAGE_URL);
        LOGGER.info("Arendovat Page Opened")
        return this;
    }

    @FindBy(xpath = "//*[@id=\"block-home-search_button-search\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"search-location-pickup\"]")
    private WebElement locationSelect;

    @FindBy(xpath = "//*[@id=\"search-city\"]")
    private WebElement citySelect;

    @FindBy(xpath = "//*[@id=\"search-country\"]")
    private WebElement countrySelect;

    @FindBy(xpath = "//*[@id=\"country-error\"]")
    private WebElement countryError;

    @FindBy(xpath = "//*[@id=\"cars-filter-property-availability-date-begin\"]")
    private WebElement beginRentDate;

    @FindBy(xpath = "//*[@id=\"cars-filter-property-availability-date-end\"]")
    private WebElement finishRentDate;

    @FindBy(xpath = "//*[@id=\"card_27567\"]/div/div[2]/div[2]/div[2]/a[2]")
    private WebElement rentButton;

    @FindBy(xpath = "//*[@id=\"rent-error\"]")
    private WebElement rentError;

    public void rentCar(String beginDate, String beginTime, String fiinishDate, String finishTime, Location location){
        inputBeginRentDate(beginDate, beginTime);
        inputFinishRentDate(fiinishDate, finishTime);
        selectLocation(location);
        clickSearchButton();
        log.info("Trying to rent");
    }

    public void selectCountry(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(countrySelect));
        Select dropdown = new Select(countrySelect);
        dropdown.selectByVisibleText(country);
        LOGGER.info(country+ " selected");
    }

    public void selectCity(String city) {
        wait.until(ExpectedConditions.elementToBeClickable(citySelect));
        Select dropdown = new Select(citySelect);
        dropdown.selectByVisibleText(city);
        LOGGER.info(city+ " selected");
    }

    public void selectLocationInCity(String location) {
        wait.until(ExpectedConditions.elementToBeClickable(locationSelect));
        Select dropdown = new Select(locationSelect);
        dropdown.selectByVisibleText(location);
        LOGGER.info(place+ " selected");
    }

    public void selectLocation(Location location) {
        selectCountry(place.getCountry());
        selectCity(place.getCity());
        selectLocationInCity(place.getLocationInCity());
        LOGGER.info("Complete place selected");
    }

    public boolean checkLocationErrorMessage(Error error) {
        return countryError.isDisplayed()
                && countryError.getText().
                contains(error.getErrorDescription());
    }

    public void inputBeginRentDate(String date, String time){
        beginRentDate.sendKeys(date);
        beginRentDate.sendKeys(Keys.TAB);

        beginRentDate.sendKeys(time);

    }

    public void inputFinishRentDate(String date, String time){
        finishRentDate.sendKeys(date);
        finishRentDate.sendKeys(Keys.TAB);

        finishRentDate.sendKeys(time);

    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public boolean checkAgeErrorMessage(Error error) {
        return rentError.isDisplayed()
                && rentError.getText().
                contains(error.getErrorDescription());
    }

}
