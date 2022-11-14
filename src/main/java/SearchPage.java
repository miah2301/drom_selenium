import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By headingsCars = By.xpath("//span[@data-ftid='bull_title']");
    private final By headingCar = By.xpath("//div[@data-ftid = 'component_inline-bull-description']");
    private final By headerCarWithLine = By.xpath("//div[contains(@class, 'css-r91w5p')]");

    private final By audiField = By.xpath("//a[text() = 'Audi']");
    private final By firstCarAudi = By.xpath("//div[@data-ftid = 'bull_image']");
    private final By addFavorite = By.xpath("//span[text() = 'Добавить в избранное']");
    private final By removeFavorite = By.xpath("//span[text() = 'Удалить из избранного']");

    private final By modalWindow = By.xpath("//div[@data-ftid = 'component_notification_type_success']");

    public List<WebElement> getListCar() {
        return driver.findElements(headingsCars);
    }

    public List<WebElement> getListCarComponents() {
        return driver.findElements(headingCar);
    }

    public List<WebElement> getListHeaderCarWithLine() {
        return driver.findElements(headerCarWithLine);
    }

    public void selectCarModal(){
        driver.findElement(audiField).click();
    }

    public void clickFirstAuto() {
        driver.findElement(firstCarAudi).click();
    }

    public void clickFavorite(){
        driver.findElement(addFavorite).click();

    }

    public boolean modalWindowIsDisplayed(){
        return driver.findElement(modalWindow).isDisplayed();
    }

    public void clickRemoveFavorite(){
        driver.findElement(removeFavorite).click();
    }
}
