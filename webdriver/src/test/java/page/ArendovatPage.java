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
    private final String ARENDOVATPAGE_URL = "https://rentride.ru/arendovat/sankt-peterburg/";
    private Logger log = LogManager.getRootLogger();

    public ArendovatPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    protected ArendovatPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
    }

    public ArendovatPage openPage() {
        driver.navigate().to(ARENDOVATPAGE_URL);
        return this;
    }

    @FindBy(xpath = "//*[@id=\"block-home-search_button-search\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"cars-filter-property-availability-date-begin\"]")
    private WebElement beginRentDate;

    @FindBy(xpath = "//*[@id=\"cars-filter-property-availability-date-end\"]")
    private WebElement finishRentDate;

    @FindBy(xpath = "//*[@id=\"card_27567\"]/div/div[2]/div[2]/div[2]/a[2]")
    private WebElement rentButton;

    @FindBy(xpath = "//*[@id=\"rent-error\"]")
    private WebElement rentError;

    public void rentCar(String beginDate, String beginTime, String fiinishDate, String finishTime){
        inputBeginRentDate(beginDate, beginTime);
        inputFinishRentDate(fiinishDate, finishTime);
        clickSearchButton();
        log.info("Trying to rent");
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
