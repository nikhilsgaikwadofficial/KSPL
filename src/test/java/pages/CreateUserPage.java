package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CreateUserPage extends BasePage {



    public CreateUserPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }


    By master = By.xpath("(//i[@class='fa fa-database '])");
    By user = By.xpath("(//i[@class='fa fa-user ']) ");
    By addUser = By.xpath("//a[contains(@href,'https://ourattendance.com/web-portal_uat/public/users/add')]");
    By empId = By.xpath("//input[@name='emp_id']");
    By empName = By.xpath("//input[@name='name']");
    By mobile = By.xpath("//input[@name='mobile_number']");
    By email = By.xpath("//input[@name='email']");
    By password = By.xpath("//input[@id='password']");
    By bloodGroup = By.xpath("//input[@name='blood_group']");
    By emergencyContact = By.xpath("//input[@name='emergency_contact']");
    By basicSalary = By.xpath("//input[@name='basic_salary']");
    By role = By.xpath("//select[@id='role']");
    By designation = By.xpath("//select[@id='designation']");
    By branch =By.xpath("//select[@name='area_id'][1]");
    By mapRole=By.xpath("//input[@role='searchbox']");
    By submit = By.xpath("//button[@id='btn-admin-member-submit']");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void clickMaster() {
        WebElement mast = wait.until(ExpectedConditions.visibilityOfElementLocated(master));
        js.executeScript("arguments[0].click();", mast);
    }

    public void clickUser() {
     WebElement users=   wait.until(ExpectedConditions.visibilityOfElementLocated(user));
        js.executeScript("arguments[0].click();", users);
    }

    public void clickAddUser() {
    WebElement addupdate=    wait.until(ExpectedConditions.visibilityOfElementLocated(addUser));
        js.executeScript("arguments[0].click();", addupdate);
    }

    public void enterEmpId(String id) {
        driver.findElement(empId).sendKeys(id);
    }

    public void enterEmpName(String name) {
        driver.findElement(empName).sendKeys(name);
    }

    public void enterMobile(String number) {
        driver.findElement(mobile).sendKeys(number);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void enterBloodGroup(String bloodgroup) {
        driver.findElement(bloodGroup).sendKeys(bloodgroup);
    }

    public void enterEmergencyContact(String number) {
        driver.findElement(emergencyContact).sendKeys(number);
    }

    public void enterBasicSalary(String salary) {
        driver.findElement(basicSalary).sendKeys(salary);
    }

    public void selectRole(String roleText) {
        new Select(driver.findElement(role)).selectByVisibleText(roleText);
    }

    public void selectDesignation(String designationText) {
         new Select(driver.findElement(designation)).selectByVisibleText(designationText);
    }

    public void selectBranch(String branchText){
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(branch));

        Actions action = new Actions(driver);
        action.moveToElement(option).click().perform();
         new Select(driver.findElement(branch)).selectByValue(branchText);

    }

    public void setMaprole(String maprole) {
        WebElement mapdrop= driver.findElement(mapRole);
        Actions drop=new Actions(driver);
        drop.moveToElement(mapdrop).click().perform();
        new Select(driver.findElement(mapRole)).selectByVisibleText(maprole);
    }

    public void clickSubmit() {
        WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
        js.executeScript("arguments[0].click();", save);
       // driver.findElement(submit).click();
    }
}
//Select bran= new Select(branch);
//  bran.selectByVisibleText(branchText);