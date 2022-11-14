import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;


import java.util.List;

public class ListCarsTest extends BaseTest{
    FilterPage filterPage = new FilterPage(driver);
    SearchPage searchPage = new SearchPage(driver);

    @Before
    public void setUp() throws InterruptedException {
        filterPage.mySelect();
    }

    @Test
    public void checkingTheFilterOfTheYear(){

        List<WebElement> carNameFistPage = searchPage.getListCar();
        for (WebElement webElement : carNameFistPage) {
            String[] headingInfo = webElement.getText().split(", ");
            int year = Integer.parseInt(headingInfo[1]);

            Assert.assertTrue(year >= 2007);
        }
    }

    @Test
    public void noCrossedOutCars() {
        List<WebElement> carWithLine = searchPage.getListHeaderCarWithLine();

        Assert.assertEquals(0, carWithLine.size());
    }

    @Test
    public void availabilityOfMileage() {
        List<WebElement> components = searchPage.getListCarComponents();
        for (WebElement webElement : components) {
            String[] headingInfo = webElement.getText().split(", ");
            String[] mileage = headingInfo[4].split(" ");
            String actual = mileage[1] + " " + mileage[2];

            Assert.assertEquals(actual, "тыс. км");
        }
    }
}