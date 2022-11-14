import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class AddFavoriteAutoTest extends BaseTest{

    LoginPage authPage = new LoginPage(driver);
    SearchPage searchPage = new SearchPage(driver);

    @Test
    public void addFavoriteAuto(){
        authPage.enterAccount("79853443468", "password");

        searchPage.selectCarModal();
        searchPage.clickFirstAuto();
        searchPage.clickFavorite();

        Assert.assertTrue(searchPage.modalWindowIsDisplayed());
    }

    @After
    public void tearDown(){
        searchPage.clickRemoveFavorite();
        searchPage.modalWindowIsDisplayed();
    }
}
