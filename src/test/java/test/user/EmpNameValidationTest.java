package test.user;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.UserPage;
import test.BaseTest;

public class EmpNameValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testEmpNameEmpty() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.setName(""); // Leave Name empty
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.nameInput);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.nameInput);

        Assert.assertFalse(error.isEmpty(), "Error message should be shown for empty Name");
        Assert.assertTrue(error.toLowerCase().contains("required") || error.toLowerCase().contains("fill"),
                "Error message should indicate Name is required: " + error);
    }

    @Test(priority = 2)
    public void testEmpNameWithInput() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.setName("Valid Name"); // Valid Name
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.nameInput);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.nameInput);

        Assert.assertTrue(error.isEmpty(), "Error message should be empty when valid Name is provided! Actual: " + error);
    }
}
