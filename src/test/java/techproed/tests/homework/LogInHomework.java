package techproed.tests.homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestHomePage;
import techproed.pages.TestLogInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class LogInHomework {
    //   https://testcenter.techproeducation.com/index.php?page=form-authentication
//   Login the application using page object model
    @Test
    public void logInTest() {
        Driver.getDriver().get(ConfigReader.getProperty("test_login_url"));
        TestLogInPage testLoginPage = new TestLogInPage();
        TestHomePage testHomePage = new TestHomePage();
        testLoginPage.username.sendKeys("techproed");
        testLoginPage.password.sendKeys("SuperSecretPassword");
        testLoginPage.submitButton.click();
        //verifying login is successful
        Assert.assertTrue(testHomePage.loginMessage.isDisplayed());
    }
}
