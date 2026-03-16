package test.Login;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import test.BaseTest;

public class MandatoryEmailTest extends BaseTest {

    @Test
    public void testMandatoryEmail() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword("12345678");
        loginPage.clickSignIn();

        String validationMsg = loginPage.getValidationMessage(loginPage.emailInput);
        Assert.assertFalse(validationMsg.isEmpty(), "Validation message should be shown for empty email.");
        Assert.assertTrue(validationMsg.toLowerCase().contains("fill") || validationMsg.toLowerCase().contains("required"),
                "Validation message should indicate email is required: " + validationMsg);
    }
}
