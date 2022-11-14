import org.openqa.selenium.*;

import java.util.List;

public class FilterPage extends BasePage{

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    private final By brand = By.xpath("//input[@placeholder = 'Марка']");
    private final By firstResultBrand = By.xpath("//div[@class = 'css-10zrduq e140pxhy0']//div[@role='option']");
    private final By modal = By.xpath("//input[@placeholder = 'Модель']");
    private final By firstResultModal = By.xpath("//div[@data-ftid = 'sales__filter_mid']/div[2]/div/div[3]");
    private final By fuel = By.xpath("//button[text() = 'Топливо']");
    private final By buttonShow = By.xpath("//button[@data-ftid = 'sales__filter_submit-button']");
    private final By hybridFuel = By.xpath("//div[text() = 'Гибрид']");
    private final By unsoldCheckbox = By.xpath("//label[text() = 'Непроданные']");
    private final By advancedSearch = By.xpath("//span[text() = 'Расширенный поиск']");
    private final By mileageFrom = By.xpath("//input[@data-ftid = 'sales__filter_mileage-from']");
    private final By yearFrom = By.xpath("//button[text() = 'Год от']");
    private final By selectYearFrom = By.xpath("//div[@data-ftid = 'sales__filter_year-from']/div/div");

    public void chooseCarBrand(String myBrand) throws InterruptedException {
        driver.findElement(brand).click();
        driver.findElement(brand).sendKeys(myBrand);
        Thread.sleep(1000);
    }
    public void clickChooseCarBrand(){
        driver.findElement(firstResultBrand).click();
    }

    public void chooseCarModal(String carModal) throws InterruptedException {
        driver.findElement(modal).click();
        driver.findElement(modal).sendKeys(carModal);
        Thread.sleep(1000);
    }
    public void clickChooseCarModal(){
        driver.findElement(firstResultModal).click();
    }

    public void chooseCarFuel() {
        driver.findElement(fuel).click();
        driver.findElement(hybridFuel).click();
    }

    public void chooseUnsold() {
        driver.findElement(unsoldCheckbox).click();
    }

    public void clickOnAdvancedSearch() {
        driver.findElement(advancedSearch).click();
    }

    public void chooseMileageFrom(int mileage) {
        driver.findElement(mileageFrom).sendKeys(String.valueOf(mileage));
    }

    public void chooseYearFrom(int index) {
        driver.findElement(yearFrom).click();

        List<WebElement> elements = driver.findElements(selectYearFrom);
        elements.get(index).click();
    }

    public void clickButtonShow() {
        driver.findElement(buttonShow).click();
    }

    public void mySelect() throws InterruptedException {
        chooseCarBrand("Toyota");
        clickChooseCarBrand();
        chooseCarModal("Harrier");
        clickChooseCarModal();
        chooseCarFuel();
        chooseUnsold();
        clickOnAdvancedSearch();
        chooseMileageFrom(1);
        chooseYearFrom(17);
        clickButtonShow();
    }
}
