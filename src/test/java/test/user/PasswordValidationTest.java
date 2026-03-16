package test.user;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.UserPage;
import test.BaseTest;

public class PasswordValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testPasswordEmpty() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.setPassword(""); // Leave Password empty
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.passwordInput);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.passwordInput);

        Assert.assertFalse(error.isEmpty(), "Error message should be shown for empty Password");
    }

    @Test(priority = 2)
    public void testPasswordWithInput() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.setPassword("Pass@123"); // Valid Password
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.passwordInput);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.passwordInput);

        Assert.assertTrue(error.isEmpty(), "Error message should be empty when valid Password is provided! Actual: " + error);
    }
}
