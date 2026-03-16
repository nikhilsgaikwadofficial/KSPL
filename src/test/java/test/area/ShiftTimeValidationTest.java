package test.area;
import test.BaseTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.AreaPage;

public class ShiftTimeValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testShiftTimeInvalid() {
        login();
        AreaPage areaPage = new AreaPage(driver);
        areaPage.navigateToAddArea();

        areaPage.selectWorkType("Shift");
        areaPage.setStartTime("19:00");
        areaPage.setEndTime("08:00"); // End time before start time
        areaPage.clickSubmit();

        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}

        String fieldError = areaPage.getFieldError(areaPage.endTimeInput);
        String genericError = areaPage.getGenericErrorMessage();
        String validationMsg = areaPage.getValidationMessage(areaPage.endTimeInput);

        String finalError = !fieldError.isEmpty() ? fieldError : (!genericError.isEmpty() ? genericError : validationMsg);

        Assert.assertFalse(finalError.isEmpty(), "An error message should be shown when End Time is before Start Time!");
    }

    @Test(priority = 2)
    public void testShiftTimeValid() {
        login();
        AreaPage areaPage = new AreaPage(driver);
        areaPage.navigateToAddArea();

        areaPage.selectWorkType("Shift");
        areaPage.setStartTime("09:00");
        areaPage.setEndTime("18:00"); // Valid times
        areaPage.clickSubmit();

        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}

        String fieldError = areaPage.getFieldError(areaPage.endTimeInput);
        String genericError = areaPage.getGenericErrorMessage();
        String validationMsg = areaPage.getValidationMessage(areaPage.endTimeInput);

        String finalError = !fieldError.isEmpty() ? fieldError : (!genericError.isEmpty() ? genericError : validationMsg);

        Assert.assertTrue(finalError.isEmpty(), "No error message should be shown when Shift Times are valid! Actual: " + finalError);
    }
}
