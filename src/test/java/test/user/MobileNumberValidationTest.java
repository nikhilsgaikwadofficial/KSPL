package test.user;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.UserPage;
import test.BaseTest;

public class MobileNumberValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testMobileEmpty() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.setMobile(""); // Leave Mobile empty
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.mobileInput);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.mobileInput);

        Assert.assertFalse(error.isEmpty(), "Error message should be shown for empty mobile number");
    }

    @Test(priority = 2)
    public void testMobileWithInput() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.setMobile("9876543210"); // Valid Mobile
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.mobileInput);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.mobileInput);

        Assert.assertTrue(error.isEmpty(), "Error message should be empty when valid Mobile is provided! Actual: " + error);
    }
}
