package test.user;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.UserPage;
import test.BaseTest;

public class DeployedBranchValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testDeployedBranchEmpty() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        // Leave Deployed Branch empty (default state)
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.branchSelect);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.branchSelect);

        Assert.assertFalse(error.isEmpty(), "Error message should be shown for unselected Deployed Branch");
    }

    @Test(priority = 2)
    public void testDeployedBranchWithInput() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.selectBranch("ghatkopar(S8ul bootcamp)"); // Valid Deployed Branch
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.branchSelect);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.branchSelect);

        Assert.assertTrue(error.isEmpty(), "Error message should be empty when valid Deployed Branch is provided! Actual: " + error);
    }
}

