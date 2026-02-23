package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.ExtentTestManager;

import java.time.Duration;

public class LoginValidationTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void initReport() {
        ExtentReportManager.getExtentReport();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ourattendance.com/web-portal_uat/public/home");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        ExtentTestManager.endTest();
    }

    @AfterSuite
    public void flushReport() {
        ExtentReportManager.flushReport();
    }

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
        ExtentTestManager.startTest("validateLogin - " + scenario, "Validates login for: " + scenario);

        SoftAssert softAssert = new SoftAssert();
        LoginPage lp = new LoginPage(driver);

        ExtentTestManager.logInfo("Executing Scenario: " + scenario);
        ExtentTestManager.logInfo("Username: " + (user.isEmpty() ? "(empty)" : user));
        ExtentTestManager.logInfo("Password: " + (pass.isEmpty() ? "(empty)" : "****"));

        lp.Username(user);
        lp.password(pass);
        lp.Signin();

        if (isValid) {
            ExtentTestManager.logInfo("Expected Result: Login Successful");
            boolean dashboardDisplayed = lp.isDashboardDisplayed();
            softAssert.assertTrue(dashboardDisplayed, "PASSED: " + scenario + " → User should be logged in successfully");
            if (dashboardDisplayed) {
                ExtentTestManager.logPass(scenario + " → User logged in successfully. Dashboard displayed.");
            } else {
                ExtentTestManager.logFail(scenario + " → Dashboard was not displayed after login.");
            }
        } else {
            boolean dashboardDisplayed = lp.isDashboardDisplayed();
            softAssert.assertFalse(dashboardDisplayed, "PASSED: " + scenario + " → User should NOT be logged in");
            String errorMsg = lp.getErrorMessage();
            softAssert.assertTrue(errorMsg.length() > 0, "FAILED: " + scenario + " → Error message is not displayed");
            if (!dashboardDisplayed && errorMsg.length() > 0) {
                ExtentTestManager.logPass(scenario + " → Login correctly rejected. Error: " + errorMsg);
            } else {
                ExtentTestManager.logFail(scenario + " → Expected login rejection. Dashboard displayed: " + dashboardDisplayed + ", Error msg: " + errorMsg);
            }
        }

        softAssert.assertAll();
    }
}
