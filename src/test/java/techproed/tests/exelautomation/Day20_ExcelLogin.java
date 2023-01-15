package techproed.tests.exelautomation;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LogInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day20_ExcelLogin {

    //1.create a login method
    HomePage homePage;
    LogInPage logInPage;
    ExcelUtils excelUtils;

    //will store excel data
    List<Map<String,String>> allTestData;
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage=new HomePage();
        logInPage=new LogInPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();
        ReusableMethods.waitFor(3);


        /*
        I AM ON LOGIN PAGE
        send username
        send password
        click on login BUTTON
        I AM ON HOME PAGE
        **********PATTERN 1**********
        click on user id
        click on log out
        click on ok
        I AM ON HOME PAGE AGAIN
        *********PATTERN 2***********
        click on login link
        send username
        send password
        click on login Button
        I AM ON HOME PAGE AGAIN
        *****************
         click on user id
        click on log out
        click on ok
        I AM ON HOME PAGE AGAIN
         ********************
        click on login link
        send username
        send password
        click on login Button
        I AM ON HOME PAGE AGAIN

         */
    }

    @Test
    public void customerLoginTest(){
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName="customer_info";
        excelUtils=new ExcelUtils(path,sheetName);
        //getDataList() method returns all excel data
        //we stored that data in allTestData variable
        allTestData=excelUtils.getDataList();
        System.out.println(allTestData);
    }
}
