package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day16_SoftAssert {
    @Test
    public void softAssertTest() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Line 10 Code");
        softAssert.assertEquals(3, 5);
        System.out.println("Line 12 Code");
        softAssert.assertEquals("apple", "orange");//fails
        System.out.println("Line 14 Code");
        softAssert.assertTrue(false);//fails
        System.out.println("Line 16 Code");
        softAssert.assertAll();//marking the test case as failed or passed
    }
}
