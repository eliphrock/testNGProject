package techproed.tests.listeners;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LogInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;
public class ListenersTest3 {
    HomePage homePage;
    LogInPage logInPage;

    @Test
    public void US100201_Admin_Login() {
//going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        click on home page login link
        homePage = new HomePage();
        logInPage = new LogInPage();
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
//        ALTERNATIVELY WE CAN ASSERT IF HOME PAGE LOGIN LINK IS NOT DISPLAYED. NOT RECOMMENDED
//        ReusableMethods.verifyElementNotDisplayed(homePage.homePageLoginLink);
        Driver.closeDriver();
    }
}