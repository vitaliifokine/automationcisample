import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {

    @Test(description = "Unit Validation")
    public void testAddition(){
        int addition = 5 + 5;
        Assert.assertEquals(addition, 10);
    }

}
