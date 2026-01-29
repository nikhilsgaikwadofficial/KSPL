package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

import java.time.Duration;

public class LoginValidationTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ourattendance.com/web-portal_uat/public/home");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
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

        SoftAssert softAssert = new SoftAssert();
        LoginPage lp = new LoginPage(driver);
        System.out.println("Executing Scenario: " + scenario);
        System.out.println("Username: " + user);
        System.out.println("Password: " + pass);


      lp.Username(user);
      lp.password(pass);
      lp.Signin();


        if (isValid) {
            System.out.println("Expected Result: Login Successful");

            softAssert.assertTrue(lp.isDashboardDisplayed(), " PASSED: " + scenario + " → User should be logged in successfully");
        }

        else {

            softAssert.assertFalse(lp.isDashboardDisplayed(), " PASSED: " + scenario + " → User should NOT be logged in");

            softAssert.assertTrue(lp.getErrorMessage().length() > 0, " FAILED: " + scenario + " → Error message is not displayed");
        }

        softAssert.assertAll();






}}




