package test.holiday;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.HolidayPage;
import test.BaseTest;

public class EmptyNameValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testHolidayNameEmpty() {
        login();
        HolidayPage holidayPage = new HolidayPage(driver);
        holidayPage.navigateToAddHoliday();

        holidayPage.setHolidayName(""); // Empty name
        holidayPage.clickSubmit();

        String errorMsg = holidayPage.getFieldError(holidayPage.holidayNameInput);
        if (errorMsg.isEmpty()) errorMsg = holidayPage.getValidationMessage(holidayPage.holidayNameInput);

        Assert.assertEquals(errorMsg, "Holiday Name is required.", "Validation message mismatch for empty Holiday Name!");
    }

    @Test(priority = 2)
    public void testHolidayNameWithInput() {
        login();
        HolidayPage holidayPage = new HolidayPage(driver);
        holidayPage.navigateToAddHoliday();

        holidayPage.setHolidayName("Valid Holiday"); // Valid name
        holidayPage.clickSubmit();

        String errorMsg = holidayPage.getFieldError(holidayPage.holidayNameInput);
        if (errorMsg.isEmpty()) errorMsg = holidayPage.getValidationMessage(holidayPage.holidayNameInput);

        Assert.assertTrue(errorMsg.isEmpty(), "Error message should be empty when valid Holiday Name is provided! Actual: " + errorMsg);
    }
}

