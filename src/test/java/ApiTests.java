import io.qameta.allure.Allure;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ApiTests {

    @Test(description = "API Formula 1 Gran Prix Size")
    public void granPrix(){
        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(20)).log().body();

        String body = given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().extract().body().asString();
        Allure.description("Formula 1 Gran Prix  " + body);

        String text = given().
                when().
                get("https://www.google.com/maps/").
                then().extract().body().asString();


    }
    @Test(description = "Google Maps")
    public void maps(){
        String text = given().
                when().
                get("https://www.google.com/maps/").
                then().extract().body().asString();
        System.out.println(text);


    }
}
