package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LoginPage;
import test.BaseTest;

public class LoginValidationTest extends BaseTest {


    @DataProvider(name = "loginData")
    public Object[][] getLoginTestData() {
        return new Object[][]{
                {"venture@example.com", "12345678", true, "Valid credentials"},
                {"kadmin@test.com", "Kadmin@Test", false, "Invalid password"},
                {"KAdmin@test.com", "123455678", false, "Invalid username"},
                {"", "12345678", false, "Empty username"},
                {"kadmin@test.com", "", false, "Empty password"}};
    }

    @Test(dataProvider = "loginData")
    public void validateLogin(String user, String pass, boolean isValid, String scenario) {
        System.out.println("\n------------------------------------------------------------");
        System.out.println("SCENARIO: " + scenario);
        System.out.println("------------------------------------------------------------");

        SoftAssert softAssert = new SoftAssert();
        LoginPage lp = new LoginPage(driver);

        System.out.println("Execution Steps:");
        System.out.println("Entering Username: " + (user.isEmpty() ? "(empty)" : user));
        lp.Username(user);
        
        System.out.println("Entering Password: " + (pass.isEmpty() ? "(empty)" : "****"));
        lp.password(pass);
        
        System.out.println("Clicking Sign In");
        lp.Signin();

        System.out.println("\nValidation & Assertions:");
        if (isValid) {
            System.out.println("Expected Result: Login Successful");
            boolean dashboardDisplayed = lp.isDashboardDisplayed();
            
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("ASSERTION: Checking if dashboard is displayed. Expected: true, Actual: " + dashboardDisplayed);
            softAssert.assertTrue(dashboardDisplayed, "PASSED: " + scenario + " -> User should be logged in successfully");
            
            if (dashboardDisplayed) {
                System.out.println("SUCCESS: " + scenario + " -> User logged in successfully. Dashboard displayed.");
            } else {
                System.out.println("FAILURE: " + scenario + " -> Dashboard was not displayed after login.");
            }
        } else {
            System.out.println("Expected Result: Login Rejection");
            boolean dashboardDisplayed = lp.isDashboardDisplayed();
            
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("ASSERTION: Checking if dashboard is NOT displayed. Expected: false, Actual: " + dashboardDisplayed);
            softAssert.assertFalse(dashboardDisplayed, "PASSED: " + scenario + " -> User should NOT be logged in");
            
            String errorMsg = lp.getErrorMessage();
            System.out.println("ASSERTION: Checking if error message is displayed. Actual: '" + errorMsg + "'");
            softAssert.assertTrue(errorMsg.length() > 0, "FAILED: " + scenario + " -> Error message is not displayed");
            
            if (!dashboardDisplayed && errorMsg.length() > 0) {
                System.out.println("SUCCESS: " + scenario + " -> Login correctly rejected. Error: " + errorMsg);
            } else {
                System.out.println("FAILURE: " + scenario + " -> Expected login rejection. Dashboard displayed: " + dashboardDisplayed + ", Error msg: " + errorMsg);
            }
        }

        System.out.println("------------------------------------------------------------\n");
        softAssert.assertAll();
    }

}
