package test.user;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.UserPage;
import test.BaseTest;

public class EmpIdValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testEmpIdEmpty() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.setEmployeeId(""); // Leave Emp ID empty
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.empIdInput);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.empIdInput);

        Assert.assertFalse(error.isEmpty(), "Error message should be shown for empty Employee ID");
        Assert.assertTrue(error.toLowerCase().contains("required") || error.toLowerCase().contains("fill"),
                "Error message should indicate Employee ID is required: " + error);
    }

    @Test(priority = 2)
    public void testEmpIdWithInput() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.setEmployeeId("TEST_ID_123"); // Valid Emp ID
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.empIdInput);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.empIdInput);

        Assert.assertTrue(error.isEmpty(), "Error message should be empty when valid Employee ID is provided! Actual: " + error);
    }
}
