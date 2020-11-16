package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class GoogleResultPage extends BasePage {

    @FindBy (css = ".LC20lb")
    List<WebElement> searchResultsHeaders;

    @FindBy (css = "h3.LC20lb")
    List<WebElement> searchResultsHeaderLines;

    @FindBy (css = "#search h3.LC20lb")
    List<WebElement> headerDescription;

    @FindBy (css = "#logo > img")
    WebElement logoResultPage;

    @FindBy (css = "#topabar #resultStats")
    WebElement resultsQuantity;

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public void openFirstLink(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(logoResultPage));
        headerDescription.get(0).click();
    }



}
