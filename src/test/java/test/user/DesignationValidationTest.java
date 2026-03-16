package test.user;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.UserPage;
import test.BaseTest;

public class DesignationValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testDesignationEmpty() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        // Leave Designation empty (default state)
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.designationSelect);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.designationSelect);

        Assert.assertFalse(error.isEmpty(), "Error message should be shown for unselected Designation");
    }

    @Test(priority = 2)
    public void testDesignationWithInput() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.selectDesignation("F&B Executive"); // Valid Designation
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.designationSelect);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.designationSelect);

        Assert.assertTrue(error.isEmpty(), "Error message should be empty when valid Designation is provided! Actual: " + error);
    }
}
