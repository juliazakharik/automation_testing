package test;

import model.Location;
import org.junit.Test;
import page.HomePage;
import service.LocationCreator;

import static org.junit.Assert.*;

public class HomePageTest extends CommonConditions{
    @Test
    public void invalidAgeTest() {
        HomePage page = new HomePage(driver).openPage();
        Location location = LocationCreator.withInfoFromProperty();
        page.selectCompletePlace(location);
        page.setAgeCheckButton();
        Age age = AgeCreator.withInfoFromProperty();
        page.setAge(age);
        page.search();
        Assert.assertTrue(page.checkAgeErrorMessage(expectedError));
    }
    @Test(description = "Test for checking being able to search for cars without specifying any info")
    public void emptyInputTest() {
        HomePage page = new HomePage(driver).openPage();
        page.search();
        PageError expectedError = PageErrorCreator.EmptyErrorWithInfoFromPropety();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

}