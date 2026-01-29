package testcase;

import org.testng.annotations.Test;
import pages.AddAreaPages;

public class AddAreaTest extends BaseTest{

    @Test
    public void verify_addArea(){
        AddAreaPages addAreaPages=new AddAreaPages(driver);
        addAreaPages.clickMaster();
        addAreaPages.clickArea();
        addAreaPages.clickAdd();
        addAreaPages.selectState("Maharashtra");
        addAreaPages.setBranch("Kanishka(vikroli)");
        addAreaPages.setAddress("Vikroli");
        addAreaPages.setLatitude("19.11");
        addAreaPages.setLongitude("72.93");
        addAreaPages.selectWorkType("Shift");
        addAreaPages.setStartTime("8.00 ");
        addAreaPages.setEndTime("20.00");
        addAreaPages.selectCheckout("No");
        addAreaPages.selectAllowLate("Yes");
        addAreaPages.selectAllowOt("Yes");
        addAreaPages.selectRadius("No");
        addAreaPages.clickSubmit();
    }
}
