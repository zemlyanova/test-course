package homework;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.YandexPage;

/**
 * Created by zemlyanova on 19.02.2018.
 */
public class YandexTest extends BaseTest{

    private static YandexPage yandexPage;

    @BeforeClass
    public static void beforeTest() throws InterruptedException {
        yandexPage = PageFactory.initElements(driver, YandexPage.class);
    }

    @Test
    public void weather_search(){
        driver.get("https://ya.ru/");
        yandexPage.searchWeather("погода пенза");
        Assert.assertEquals("Погода в Пензе", yandexPage.getSearchResult());
    }

    @Test
    public void checking_the_language_selection() {
        driver.get("http://yandex.ru");
        yandexPage.switchLanguage();
        Assert.assertEquals("Search settings", yandexPage.getSwitchLanguageResult());
    }
}
