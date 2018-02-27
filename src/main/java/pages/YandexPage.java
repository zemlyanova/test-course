package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by zemlyanova on 19.02.2018.
 */
public class YandexPage {

    public YandexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@class='input__control input__input']")
    private WebElement searchField;

    @FindBy(css = ".search2__button")
    private WebElement searchButton;

    @FindBy(xpath = "(//*[@class='organic__title-wrapper typo typo_text_l typo_line_m'])[1]")
    private WebElement searchResult;

    @FindBy(xpath = "//*[@data-statlog='head.settings']")
    private WebElement settingsButton;

    @FindBy(xpath = "//*[@data-statlog='head.settings.other']")
    private WebElement portalButton;

    @FindBy(xpath = "//*[@data-statlog='tabs.lang']")
    private WebElement languageButton;

    @FindBy(xpath = "//*[@type='button']")
    private WebElement languageSelectButton;

    @FindBy(xpath = "//*[@class='select__text'][text()='English']")
    private WebElement textSelect;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@class='options__header']")
    private WebElement switchLanguageResult;

    @FindBy(css = ".input__control")
    private WebElement searchInput;

    private By productCount = By.cssSelector("div[data-id]");

    private By priceLink = By.cssSelector(".n-filter-sorter.i-bem.n-filter-sorter_js_inited:nth-child(3)");

    private By ascendingFilter = By.cssSelector(".n-filter-sorter.i-bem.n-filter-sorter_js_inited.n-filter-sorter_sort_asc.n-filter-sorter_state_select");

    private By descendingFilter = By.cssSelector(".n-filter-sorter.i-bem.n-filter-sorter_js_inited.n-filter-sorter_sort_desc.n-filter-sorter_state_select");

    public void searchWeather(String text){
        searchField.sendKeys(text);
        searchButton.click();
    }

    public String getSearchResult(){
        return searchResult.getText();
    }

    public void switchLanguage(){
        settingsButton.click();
        portalButton.click();
        languageButton.click();
        languageSelectButton.click();
        textSelect.click();
        saveButton.click();
        settingsButton.click();
        portalButton.click();
    }

    public String getSwitchLanguageResult(){
        return switchLanguageResult.getText();
    }

    public void enterNameProductAndSearch(String text){
        searchInput.sendKeys(text);
        searchButton.click();
    }

    public int getProductCount(){
        return driver.findElements(productCount).size();
    }

    public void clickPriceLink(){
        driver.findElement(priceLink).click();
    }

    public String getResultByAscending(){
        return driver.findElement(ascendingFilter).getAttribute("class");
    }

    public String getResultByDescending(String index){
        if (driver.findElement(ascendingFilter).getAttribute("class").contains(index))
        {
            driver.findElement(priceLink).click();
        }
        return driver.findElement(descendingFilter).getAttribute("class");
    }
}
