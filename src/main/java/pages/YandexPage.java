package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zemlyanova on 19.02.2018.
 */
public class YandexPage {
    @FindBy(xpath = "//*[@class='input__control input__input']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@class='search2__button']")
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
}
