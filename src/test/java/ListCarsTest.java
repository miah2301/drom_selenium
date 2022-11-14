import io.qameta.allure.junit4.DisplayName;
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
    @DisplayName("Проверка резултатов поиска. Год авто не меньше 2007")
    public void checkingTheFilterOfTheYear(){

        List<WebElement> carNameFistPage = searchPage.getListCar();
        for (WebElement webElement : carNameFistPage) {
            String[] headingInfo = webElement.getText().split(", ");
            int year = Integer.parseInt(headingInfo[1]);

            Assert.assertTrue(year >= 2007);
        }
    }

    @Test
    @DisplayName("Проверка резултатов поиска. Нет проданных авто (отсутствует перечеркнутый текст)")
    public void noCrossedOutCars() {
        List<WebElement> carWithLine = searchPage.getListHeaderCarWithLine();

        Assert.assertEquals(0, carWithLine.size());
    }

    @Test
    @DisplayName("Проверка резултатов поиска. У каждого объявления в списке есть пробег.")
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