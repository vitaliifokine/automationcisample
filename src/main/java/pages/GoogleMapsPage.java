package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleMapsPage extends BasePage {

    @FindBy(css = "#searchboxinput")
    WebElement searchInput;

    @FindBy(css = "#searchbox-directions")
    WebElement directions;

    @FindBy(css = "#sb_ifc51 > input")
    WebElement fromLocation;

    @FindBy(css = "#sb_ifc52 > input")
    WebElement to;

    @FindBy(css = "div.section-directions-trip-numbers > div")
    WebElement tripTime;

    public GoogleMapsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleMapsPage isPageDisplayed(WebDriver driver){
        waitUntilDisplayedBy(driver, searchInput);
        return this;
    }

    public GoogleMapsPage fromToDestination(WebDriver driver, String from, String destination) throws IOException {
        directions.click();
        waitUntilDisplayedBy(driver, fromLocation);
        fromLocation.clear();
        fromLocation.sendKeys(from);
        to.sendKeys(destination);
        to.sendKeys(Keys.ENTER);
        waitUntilDisplayedBy(driver, tripTime);
        System.out.println("Using public transportation Currently from location: "+from+" to location: "+destination+" is: "+tripTime.getText());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        captureScreenshot(driver);
        return this;
    }
}
