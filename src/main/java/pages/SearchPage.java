package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class SearchPage extends BasePage {
    Map<String, Integer> hmap = new HashMap<String, Integer>();
    Map<String, String> stadium = new HashMap<String, String>();

    @FindBy(css = "div.a4bIc > input")
    private WebElement searchInput;

    @FindBy(css = ".FPdoLc input[name=\"btnK\"]")
    private WebElement button;

    @FindBy(css = "#hdtb-msb-vis > div:nth-child(2) > a")
    private WebElement searchResultLogo;

    @FindBy(xpath = "//a[contains(text(), \"/Stadium\")]/../following-sibling::span/a")
    private WebElement stadiumValue;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage openSearchPage(WebDriver driver){
        driver.get("https://www.google.us");
        return this;
    }

    public GoogleResultPage doSearchOf(WebDriver driver, String searchText){
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchInput.sendKeys(Keys.ENTER);
        waitUntilDisplayedBy(driver, searchResultLogo);
        return new GoogleResultPage(driver);
    }

    public String getButtonNqame(WebDriver driver){
        waitUntilDisplayedBy(driver, button);
        return button.getAttribute("value");
    }


    public void  getSearchedText(String searchText){
        searchInput.getText();
    }


}