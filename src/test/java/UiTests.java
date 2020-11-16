import entities.Destinations;
import entities.Urls;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleMapsPage;
import pages.GoogleResultPage;
import pages.SearchPage;

import java.io.IOException;

public class UiTests {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(description = "Navigate and check", dataProvider = "urls", dataProviderClass = Urls.class)
    public void test(String urls) throws IOException {
       navigateAndCheckUrl(urls);
    }

    @Test(description = "Google Maps", dataProvider = "Destinations", dataProviderClass = Destinations.class)
    public void googleMapsDestinations(String from, String to) throws IOException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.openSearchPage(driver)
                .doSearchOf(driver, "Google Maps");

        GoogleResultPage googleResultPage = new GoogleResultPage(driver);
        googleResultPage.openFirstLink(driver);

        // Google Maps
        GoogleMapsPage googleMapsPage = new GoogleMapsPage(driver);
        googleMapsPage.isPageDisplayed(driver)
                .fromToDestination(driver, from, to);
    }

    @Step("Validate url")
    private void navigateAndCheckUrl(String url) throws IOException {
        driver.get(url);
        captureScreenshot();
    }

    @Attachment
    private byte[] captureScreenshot()throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
