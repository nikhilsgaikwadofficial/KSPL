package test.area;
import test.BaseTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.AreaPage;

public class LatitudeNumericValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testLatitudeEmpty() {
        login();
        AreaPage areaPage = new AreaPage(driver);
        areaPage.navigateToAddArea();

        areaPage.setLatitude(""); // Empty latitude
        areaPage.clickSubmit();

        String errorMsg = areaPage.getFieldError(areaPage.latitudeInput);
        if (errorMsg.isEmpty()) errorMsg = areaPage.getValidationMessage(areaPage.latitudeInput);

        Assert.assertTrue(errorMsg.contains("numeric") || errorMsg.contains("invalid") || errorMsg.contains("lat") || errorMsg.contains("required"),
                "Validation message mismatch for missing/invalid Latitude!");
    }

    @Test(priority = 2)
    public void testLatitudeWithInput() {
        login();
        AreaPage areaPage = new AreaPage(driver);
        areaPage.navigateToAddArea();

        areaPage.setLatitude("19.0760"); // Valid latitude
        areaPage.clickSubmit();

        String errorMsg = areaPage.getFieldError(areaPage.latitudeInput);
        if (errorMsg.isEmpty()) errorMsg = areaPage.getValidationMessage(areaPage.latitudeInput);

        Assert.assertTrue(errorMsg.isEmpty(),
                "Error message should be empty when valid Latitude is provided! Actual: " + errorMsg);
    }
    }

