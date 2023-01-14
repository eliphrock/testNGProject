package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day17_FirstDrivertest {
    @Test
    public void firstDriverTest(){
        //driver -> driver.getdriver()
        Driver.getDriver().get("https://www.techproeducation.com");

        //close the driver
        Driver.closeDriver();
    }
}
