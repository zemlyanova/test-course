package homework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by zemlyanova on 19.02.2018.
 */
public class YandexTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/2.34/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ya.ru/");
    }

    @Test
    public void weather_search() {
        WebElement searchField = driver.findElement(By.xpath("//*[@class='input__control input__input']"));
        searchField.sendKeys("погода пенза");
        WebElement searchButton = driver.findElement(By.xpath("//*[@class='search2__button']"));
        searchButton.click();
        WebElement searchResults = driver.findElement(By.xpath("(//*[@class='organic__title-wrapper typo typo_text_l typo_line_m'])[1]"));
        String currentResults = searchResults.getText();
        Assert.assertEquals("Погода в Пензе", currentResults);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
