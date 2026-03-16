package test.area;
import test.BaseTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.AreaPage;

public class AddressValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testAddressEmpty() {
        login();
        AreaPage areaPage = new AreaPage(driver);
        areaPage.navigateToAddArea();

        areaPage.setAddress(""); // Empty address
        areaPage.clickSubmit();

        String errorMsg = areaPage.getFieldError(areaPage.addressInput);
        if (errorMsg.isEmpty()) errorMsg = areaPage.getValidationMessage(areaPage.addressInput);

        Assert.assertTrue(errorMsg.contains("required") || errorMsg.contains("address"),
                "Validation message mismatch for empty Address!");
    }

    @Test(priority = 2)
    public void testAddressWithInput() {
        login();
        AreaPage areaPage = new AreaPage(driver);
        areaPage.navigateToAddArea();

        areaPage.setAddress("Valid Address 123"); // Valid address
        areaPage.clickSubmit();

        String errorMsg = areaPage.getFieldError(areaPage.addressInput);
        if (errorMsg.isEmpty()) errorMsg = areaPage.getValidationMessage(areaPage.addressInput);

        Assert.assertTrue(errorMsg.isEmpty(),
                "Error message should be empty when valid Address is provided! Actual: " + errorMsg);
    }
    }


