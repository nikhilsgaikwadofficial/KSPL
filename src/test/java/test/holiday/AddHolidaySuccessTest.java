package test.holiday;
import test.BaseTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.HolidayPage;

public class AddHolidaySuccessTest extends BaseTest {

        @Test
        public void testAddHolidaySuccess() {
            login();
            HolidayPage holidayPage = new HolidayPage(driver);
            holidayPage.navigateToAddHoliday();

            holidayPage.setDate("25-12-2026");
            holidayPage.setHolidayName("Christmas Day");
            holidayPage.selectState("Assam");
            holidayPage.clickSubmit();

            String successMsg = holidayPage.getSuccessMessageText();
            Assert.assertTrue(successMsg.contains("success") || successMsg.contains("added"),
                    "Success message mismatch! Actual: " + successMsg);
        }
    }

