import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    WebDriver driver = new FirefoxDriver();
    private static final String BASE_URL = "https://auto.drom.ru/";

    @Before
    public void openUrl(){
        driver.get(BASE_URL);
    }

    @After
    public void close(){
        driver.quit();
    }
}
