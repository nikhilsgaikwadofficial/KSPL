package test.area;
import test.BaseTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.AreaPage;

public class BranchNameValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testBranchNameEmpty() {
        login();
        AreaPage areaPage = new AreaPage(driver);
        areaPage.navigateToAddArea();

        areaPage.setBranch(""); // Leave branch empty
        areaPage.clickSubmit();

        String errorMsg = areaPage.getFieldError(areaPage.branchInput);
        if (errorMsg.isEmpty()) errorMsg = areaPage.getValidationMessage(areaPage.branchInput);

        Assert.assertTrue(errorMsg.contains("required") || errorMsg.contains("name"),
                "Validation message mismatch for empty Branch Name!");
    }

    @Test(priority = 2)
    public void testBranchNameWithInput() {
        login();
        AreaPage areaPage = new AreaPage(driver);
        areaPage.navigateToAddArea();

        areaPage.setBranch("Valid Branch"); // Valid branch
        areaPage.clickSubmit();

        String errorMsg = areaPage.getFieldError(areaPage.branchInput);
        if (errorMsg.isEmpty()) errorMsg = areaPage.getValidationMessage(areaPage.branchInput);

        Assert.assertTrue(errorMsg.isEmpty(),
                "Error message should be empty when valid Branch Name is provided! Actual: " + errorMsg);
    }
    }

