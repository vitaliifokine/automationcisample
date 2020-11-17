package entities;

import org.testng.annotations.DataProvider;

public class Destinations {

    @DataProvider(name = "Destinations")
    public static Object[][] destinations() {
        return new Object[][] {
                {"San Francisco", "San Jose"},
                {"Boston", "New York"}
        };
    }
}
