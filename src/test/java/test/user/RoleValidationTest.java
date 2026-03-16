package test.user;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.UserPage;
import test.BaseTest;

public class RoleValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testRoleEmpty() throws InterruptedException {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.clickSubmit();
        Thread.sleep(2000); // Wait for validation to trigger

        String error = userPage.getFieldError(userPage.roleSelect);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.roleSelect);
        System.out.println("Role Selection Validation Message/Error Data: '" + error + "'");
        
        System.out.println("\n--- All text-danger / invalid-feedback messages ---");
        java.util.List<org.openqa.selenium.WebElement> errors = driver.findElements(org.openqa.selenium.By.xpath("//*[contains(@class, 'text-danger') or contains(@class, 'invalid-feedback') or contains(@class, 'error')]"));
        for (org.openqa.selenium.WebElement e : errors) {
            System.out.println("ERROR FOUND: " + e.getText());
        }
        System.out.println("---------------------------------------------------\n");

        Assert.assertFalse(error.isEmpty(), "Error message should be shown for unselected Role");
    }

    @Test(priority = 2)
    public void testRoleWithInput() {
        login();
        UserPage userPage = new UserPage(driver);
        userPage.navigateToAddUser();

        userPage.selectRole("Level 1"); // Valid Role
        userPage.clickSubmit();

        String error = userPage.getFieldError(userPage.roleSelect);
        if (error.isEmpty()) error = userPage.getValidationMessage(userPage.roleSelect);

        Assert.assertTrue(error.isEmpty(), "Error message should be empty when valid Role is provided! Actual: " + error);
    }
}
