package homework;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.YandexPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


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

/*    @Test
    public void search_for_product_in_the_market_yandex(){
        driver.get("https://market.yandex.ru");
        Assert.assertEquals(12, yandexPage.searchProductAndGetProductCount("Планшет"));
        Assert.assertTrue("Товары отсортированы не по возрастанию", yandexPage.clickPriceLinkAndGetResultInAscending().contains("asc"));
        Assert.assertTrue("Товары отсортированы не по убыванию", yandexPage.clickPriceLinkAndGetResultInDescending().contains("desc"));
    }*/

    @Test
    public void search_for_product_in_the_market_yandex_and_check_product_count(){
        int productCount = 12;
        driver.get("https://market.yandex.ru");
        yandexPage.enterNameProductAndSearch("Планшет");
        assertThat(yandexPage.getProductCount("Планшет")).describedAs("На странице отображается НЕ 12 товаров").isEqualTo(productCount);
    }


}
