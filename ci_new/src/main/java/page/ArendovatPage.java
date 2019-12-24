//package page;
//
//import model.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//
//public class ArendovatPage extends AbstractPage{
//    private static final Logger LOGGER = LogManager.getRootLogger();
//    private final String ARENDOVATPAGE_URL = "https://rentride.ru/arendovat/sankt-peterburg/";
//    private Logger log = LogManager.getRootLogger();
//    private final WebDriverWait wait = null;
//
//    public ArendovatPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(this.driver, this);
//        LOGGER.info("Created Arendovat Page");
//    }
//
//    protected ArendovatPage(WebDriver driver, WebDriverWait wait) {
//        super(driver);
//    }
//
//    public ArendovatPage openPage() {
//        driver.navigate().to(ARENDOVATPAGE_URL);
//        LOGGER.info("Arendovat Page Opened");
//        return this;
//    }
//
//    @FindBy(xpath = "//*[@id=\"block-home-search_button-search\"]")
//    private WebElement searchButton;
//
//    @FindBy(xpath = "//*[@id=\"search-location-pickup\"]")
//    private WebElement locationSelect;
//
//    @FindBy(xpath = "//*[@id=\"search-city\"]")
//    private WebElement citySelect;
//
//    @FindBy(xpath = "//*[@id=\"search-country\"]")
//    private WebElement countrySelect;
//
//    @FindBy(xpath = "//*[@id=\"country-error\"]")
//    private WebElement countryError;
//
//    @FindBy(xpath = "//*[@id=\"cars-filter-property-availability-date-begin\"]")
//    private WebElement beginRentDate;
//
//    @FindBy(xpath = "//*[@id=\"cars-filter-property-availability-date-end\"]")
//    private WebElement finishRentDate;
//
//
//    @FindBy(xpath = "//*[@id=\"card_27567\"]/div/div[2]/div[2]/div[2]/a[2]")
//    private WebElement rentButton;
//
//    @FindBy(xpath = "//*[@id=\"rent-error\"]")
//    private WebElement rentError;
//
//    @FindBy(xpath = "//*[@id=\"search-age-input\"]")
//    private WebElement ageValue;
//
//    @FindBy(xpath = "//*[@id=\"no-email-error\"]")
//    private WebElement loginError;
//
//    public void rentCar(Date date, Time time, Location location){
//        inputBeginRentDate(date.getStartDate(), time.getStartTime());
//        inputFinishRentDate(date.getEndDate(), time.getEndTime());
//        selectLocation(location);
//        clickSearchButton();
//        log.info("Trying to rent");
//    }
//
//    public void selectCountry(String country) {
//        wait.until(ExpectedConditions.elementToBeClickable(countrySelect));
//        Select dropdown = new Select(countrySelect);
//        dropdown.selectByVisibleText(country);
//        LOGGER.info(country+ " selected");
//    }
//
//    public void selectCity(String city) {
//        wait.until(ExpectedConditions.elementToBeClickable(citySelect));
//        Select dropdown = new Select(citySelect);
//        dropdown.selectByVisibleText(city);
//        LOGGER.info(city+ " selected");
//    }
//
//    public void selectLocationInCity(String location) {
//        wait.until(ExpectedConditions.elementToBeClickable(locationSelect));
//        Select dropdown = new Select(locationSelect);
//        dropdown.selectByVisibleText(location);
//        LOGGER.info(location+ " selected");
//    }
//
//    public void selectLocation(Location location) {
//        selectCountry(location.getCountry());
//        selectCity(location.getCity());
//        selectLocationInCity(location.getLocationInCity());
//        LOGGER.info("Complete place selected");
//    }
//
//    public boolean locationErrorMessage(ErrorAlert error) {
//        return countryError.isDisplayed()
//                && countryError.getText().
//                contains(error.getErrorDescription());
//    }
//
//    public void inputBeginRentDate(String date, String time){
//        beginRentDate.sendKeys(date);
//        beginRentDate.sendKeys(Keys.TAB);
//
//        beginRentDate.sendKeys(time);
//
//    }
//
//    public void inputFinishRentDate(String date, String time){
//        finishRentDate.sendKeys(date);
//        finishRentDate.sendKeys(Keys.TAB);
//
//        finishRentDate.sendKeys(time);
//
//    }
//    public void setAge(Age age) {
//        ageValue.click();
//        ageValue.clear();
//        String ageString = String.valueOf(age.getAge());
//        ageValue.sendKeys(ageString);
//        LOGGER.info("Age: " + age.getAge());
//
//    }
//
//    public void setDate(Date date) {
//        beginRentDate.click();
//        beginRentDate.sendKeys(date.getStartDate());
//        finishRentDate.click();
//        finishRentDate.sendKeys(date.getEndDate());
//        LOGGER.info("DATE: "+ date.getStartDate()+" - "+date.getEndDate());
//
//    }
//
//    public String getURL(){
//        String URL = ARENDOVATPAGE_URL;
//        return URL;
//    }
//
//
//    public void clickSearchButton(){
//        searchButton.click();
//    }
//
//    public boolean ageErrorMessage(ErrorAlert error) {
//        return rentError.isDisplayed()
//                && rentError.getText().
//                contains(error.getErrorDescription());
//    }
//
//    public void choosePickUpDate(){
//
//    }
//
//    public boolean loginErrorMessage(ErrorAlert error) {
//        return loginError.isDisplayed()
//                && loginError.getText().
//                contains(error.getErrorDescription());
//    }
//
//}
