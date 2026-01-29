package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AddHolidaysPage;

public class AddHolidayTest extends BaseTest{

    @Test
    public void Verify_Holiday(){
        AddHolidaysPage ahp=new AddHolidaysPage( driver);
        ahp.clickMaster();
        ahp.clickPublicHoliday();
        ahp.clickAddHoli();
        ahp.setDate("26-1-2026");
      //  ahp.selectDate("30-12-2025");
        ahp.setHolidayName("Republic Day ");
        ahp.selectState("Gujarat");
        ahp.clickSubmit();
    }
}
