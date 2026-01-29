package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class AddAreaPages extends BasePage {
    public AddAreaPages(WebDriver driver){
        super(driver);
        js = (JavascriptExecutor) driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By master = By.xpath("(//i[@class='fa fa-database '])");
    By area=By.xpath("(//i[@class='fa fa-map-marked-alt '])");
    By add=By.xpath("(//i[@class='fa fa-edit '])[1]");
    By state=By.xpath("//select[@id='states']");
    By branch=By.xpath("//input[@name='name']");
    By address=By.xpath("//input[@name='address']");
    By latitude=By.xpath("//input[@name='lat']");
    By longitude=By.xpath("//input[@name='long']");
    By workType=By.xpath("//select[@id='work_type']");
    By startTime=By.xpath("//input[@name='start_time']");
    By endTime=By.xpath("//input[@name='end_time']");
    By checkout=By.xpath("//select[@id='enable_force_checkout']");
    By allowLate=By.xpath("//select[@name='allow_late']");
    By allowOt=By.xpath("//select[@name='allow_ot']");
    By radius=By.xpath("//select[@id='enable_radius']");
    By submit=By.xpath("//button[@id='saveLocationData']");

    public void clickMaster() {
        WebElement mast = wait.until(ExpectedConditions.visibilityOfElementLocated(master));
        js.executeScript("arguments[0].click();", mast);
    }
    public void clickArea() {
        WebElement areaa = wait.until(ExpectedConditions.visibilityOfElementLocated(area));
        js.executeScript("arguments[0].click();", areaa);
    }
    public void clickAdd(){
        WebElement addr = wait.until(ExpectedConditions.visibilityOfElementLocated(add));
        js.executeScript("arguments[0].click();", addr);}

    public void selectState(String stat) {
       new Select( driver.findElement(state)).selectByVisibleText(stat);
    }

    public void setBranch(String bran) {
        driver.findElement(branch).sendKeys(bran);
    }

    public void setAddress(String addres) {
      WebElement addresss=  driver.findElement(address);
      addresss.click(); addresss.sendKeys(addres);
    }

    public void setLatitude(String latitudee) {
      WebElement lati=  driver.findElement(latitude);
      lati.click(); lati.sendKeys(latitudee);
    }
    public void setLongitude(String longi){
        WebElement loni=  driver.findElement(longitude);
        loni.click(); loni.sendKeys(longi);
    }
    public void selectWorkType(String workType1){
       new Select(  driver.findElement(workType)).selectByVisibleText(workType1);

    }
    public void setStartTime(String start){
        WebElement st= driver.findElement(startTime);
        st.click(); st.sendKeys(start);
    }
    public void setEndTime(String end){
      WebElement et=  driver.findElement(endTime);
        et.click(); et.sendKeys(end);
    }
    public void selectCheckout(String yesno ){
        new Select( driver.findElement(checkout)).selectByVisibleText(yesno);
        //Select s=new Select(check);
        //s.selectByVisibleText(yesno);
    }
    public void selectAllowLate(String allow){new Select(driver.findElement(allowLate)).selectByVisibleText(allow);}
    public void selectAllowOt(String ot){new Select(driver.findElement(allowOt)).selectByVisibleText(ot);}
    public void selectRadius (String radios){new Select(driver.findElement(radius)).selectByVisibleText(radios);}
    public void clickSubmit()  {

        WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
        js.executeScript("arguments[0].scrollIntoView;",saveBtn);

        js.executeScript("arguments[0].click();",saveBtn);
    }

}