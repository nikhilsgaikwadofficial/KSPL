package testcase;

import org.testng.annotations.Test;
import pages.CreateUserPage;

public class AddUserTest extends BaseTest {


    @Test(priority = 1)
    public void verify_CreateUser() {
        CreateUserPage createUser = new CreateUserPage(driver);
        createUser.clickMaster();
        createUser.clickUser();
        createUser.clickAddUser();

        createUser.enterEmpId("044");
        createUser.enterEmpName("Shubhman");
        createUser.enterMobile("9821491410");
        createUser.enterEmail("Shubhman@gmail.com");
        createUser.enterPassword("12345678");


        createUser.selectRole("Level 1");
        createUser.selectDesignation("Supervisor");
        createUser.selectBranch("205");
        createUser.setMaprole("Ghansoli");

        createUser.clickSubmit();

    }
}

//  createUser.enterBloodGroup("A+");
//  createUser.enterEmergencyContact("9988663310");
//  createUser.enterBasicSalary("22000");