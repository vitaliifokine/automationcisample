package entities;

import org.testng.annotations.DataProvider;

public class Urls {
    @DataProvider(name = "urls")
    public static Object[][] urls() {
        return new Object[][] {
                {"https://www.google.com/" },
                {"https://www.yahoo.com/"},
                {"https://www.bing.com/"},
                {"https://www.un.org/en/"},
                {"https://en.wikipedia.org/wiki/Main_Page"}
        };
    }
}
