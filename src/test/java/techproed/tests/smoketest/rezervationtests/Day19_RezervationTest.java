package techproed.tests.smoketest.rezervationtests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LogInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Day19_RezervationTest {
    HomePage homePage;
    LogInPage logInPage;
    Faker faker;
    @Test
    public void rezervationTest(){
        //        Given user is on the home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        //LOGIN THE APP
        logInPage= new LogInPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        logInPage.userName.sendKeys("jack@gmail.com");
        ReusableMethods.waitFor(3);
        logInPage.password.sendKeys("12345");
        ReusableMethods.waitFor(3);
        logInPage.loginButton.click();
        ReusableMethods.waitFor(3);
//        Verify login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);

//        NOW THAT U LOGGED IN THE APPLICATION, WE CAN ENTER THE REQUIRED FIELD
//        And select a car
        homePage=new HomePage();
        Select carSelect=new Select(homePage.selectACar);
        carSelect.selectByIndex(3);
//        And enter pick up field
       faker=new Faker();
       homePage.pickUpLocation.sendKeys(Faker.instance(Locale.UK).address().cityName());
//        And enter drop off field
        homePage.dropOfLocation.sendKeys(Faker.instance(Locale.US).address().cityName());

//        Pick Up Date
//        Pick Up Time
//        Drop Off Date
//        Drop Off Time
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hhmmaa");
        Calendar calendar=Calendar.getInstance();
        //enter pick up date
        homePage.pickUpDate.sendKeys("10/10/2023");
        //enter pick up hour
        homePage.pickUpTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));
        //enter drop off date
        homePage.dropOffDate.sendKeys("12/11/2023");
        //enter drop off hour
        homePage.dropOffTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));
//===================================================================================================
//        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hhmmaa");
//        Calendar calendar=Calendar.getInstance();
//        calendar.add(Calendar.YEAR,30);
////        homePage.pickUpDate.sendKeys(simpleDateFormat.format(calendar.getTime()));
//        homePage.pickUpDate.sendKeys("10/10/2025");
//        homePage.pickUpTime.sendKeys(simpleDateFormat1.format(new Date()));
//        calendar.add(Calendar.MONTH,1);
////        homePage.dropOffDate.sendKeys(simpleDateFormat.format(calendar.getTime()));
//        homePage.dropOffDate.sendKeys("10/11/2025");
//        calendar.add(Calendar.HOUR,1);
//        homePage.dropOffTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));


//===============================================================================
//        And click continue reservation

        homePage.continueRezervationButton.click();

        // car is not reserved........there is a blocker!!!!!!

//        And verify complete reservation screen pops up
//        And enter card number
//        And enter name on the card
//        And enter expire date and CVC
//        And checks the agreement
//        And click complete reservation
//        Then verify ‘Reservation created successfully’ pop up
//        And naviaged to Reservations screen
//        And verify the last reservation is created
//        When you click on the last reservation
//        Then verify reservation detail page is displayed
//        And verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age
//        And click on back to reservations
//        And verify Reservations page is displayed
//        And click on Home link
//        Then verify the home page is displayed
    }
}
