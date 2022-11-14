import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By authButton = By.xpath("//a[@data-ftid = 'component_header_login']");
    private final By loginField = By.xpath("//input[@name = 'sign']");
    private final By passwordField = By.xpath("//input[@name = 'password']");
    private final By signButton = By.xpath("//button[@id = 'signbutton']");

    @Step("Вход в аккаунт")
    public void enterAccount(String login, String password){
        driver.findElement(authButton).click();
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signButton).click();
    }
}
