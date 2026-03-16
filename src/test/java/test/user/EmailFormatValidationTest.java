package test.user;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.UserPage;
import test.BaseTest;



public class EmailFormatValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testEmailInvalid() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.setEmail("invalid-email"); // Invalid format
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.emailInput);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.emailInput);

        Assert.assertFalse(error.isEmpty(), "Error message should be shown for invalid email format");
    }

    @Test(priority = 2)
    public void testEmailValid() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.setEmail("valid.email@example.com"); // Valid format
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.emailInput);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.emailInput);

        Assert.assertTrue(error.isEmpty(), "Error message should be empty when valid Email is provided! Actual: " + error);
    }
}
