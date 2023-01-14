package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day17_FirstConfigTest {
    @Test
    public void firstConfigTest(){
      //  Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().get(ConfigReader.getProperty("url_prod_techproed"));


        //verify the title contains techpro education
        String actualtitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualtitle.contains(ConfigReader.getProperty("app_title")));

    }
}
