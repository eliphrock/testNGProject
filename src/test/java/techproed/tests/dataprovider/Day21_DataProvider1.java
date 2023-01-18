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


    /*
    <-TestNG xml files:
        What is it?
        An xml file can be used for test case groups, and do configuration. For example, pom.xml is used to add dependencies. TestNG xml files are used to create custom test groups such as class level test groups, package level test groups,…
        TestNG xml files are an alternative way of creating and running test cases.
        Why did you use?
        I used some xml files to run tests in parallel, set test priorities, and run specific test groups
        How did you use in your current framework?
        I used some xml files to run tests in parallel, set test priorities, and run specific test groups my current framework.
        Data Provider:
        What is it?
        Data provider is a testNG functionality.
        It is used to provide test data to the test cases in automation.
        It returns the data as 2D array
        Data provider has 2 parameters : name(to override the method name) and parallel(for doing parallel testing)
        How did you use it?
 ->       I
     */
}
