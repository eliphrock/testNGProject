package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day21_DataProvider1 {
    /*
    What is data provider?
    *****data provider is used to get list of data
    *****we can get data from external files,such as excel or json file
    ******DataProvider is an annotation of testNG
    *******I use Data Provider to get data such as credentials from excel sheet

    --------------------------------

    How do you get data in your testNG framework ?
    *******In data provider method,I use @DataProvider annotation, in Test method I give the method name in the parameter

    ------------------------------------------

    Data Provider has 2 parameters
    ******1.name : used to custom name for data provider  @DataProvider(name="my_smoke_data")
    ******2. parallel : used to do parallel testing. default is parallel = false. we can make parallel =true
     */

    //data provider method
    @DataProvider
    public Object[][] customerData(){
        //test data
        Object [][] customerCredentials={
                {"sam.walker@bluerentalcars.com","c!fas_art"},
                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
        return customerCredentials;
    }
//test method 1
    @Test(dataProvider = "customerData")
    public void dataProviderTest1(String username,String password){
        System.out.println("Username :"+username+"| Password :"+password);

    }

    //test method 2
    @Test(dataProvider = "customerData")
    public void dataProvidertest2(String user,String pass){
        System.out.println(user+"|" +pass);

    }
}
