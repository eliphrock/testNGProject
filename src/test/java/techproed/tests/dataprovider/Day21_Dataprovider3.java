package techproed.tests.dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LogInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class Day21_Dataprovider3 {
    /*
    in this method ,we will get the data from excel using data provider
    the only difference between class2 and class 3 is the place where we get the data
    in class2, we received the data from the class itself.in this class we get the data from excel
     */

    HomePage homePage;
    LogInPage logInPage;

    @DataProvider
    public Object[][] customerData() {
//    TEST DATA, get data from excel
        //path of excel sheet
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils=new ExcelUtils(path,sheetName);
        //use one of the excel util method to receieve the data from the excel

        Object [][] customerCredentials=excelUtils.getDataArrayWithoutFirstRow();
//        Object[][] customerCredentials = {
//                {"sam.walker@bluerentalcars.com", "c!fas_art"},
//                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
//                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
//                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
//        };
        return customerCredentials;
    }
    //    1. Create a login method
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new HomePage();
        logInPage =new LogInPage();
        ReusableMethods.waitFor(1);
        try {
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
        try{
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
        ReusableMethods.waitFor(1);
    }
    @Test(dataProvider = "customerData")
    public void customerLoginTest(String username, String password){
//            Takes us to the login page
        login();
        logInPage.userName.sendKeys(username);
        ReusableMethods.waitFor(1);
        logInPage.password.sendKeys(password);
        ReusableMethods.waitFor(1);
        logInPage.loginButton.click();
        ReusableMethods.waitFor(1);
//            Verify if login is successful
//            IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
        ReusableMethods.verifyElementDisplayed(homePage.userID);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
