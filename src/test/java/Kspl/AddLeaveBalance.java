package Kspl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddLeaveBalance {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://ourattendance.com/web-portal_uat/public/");
        driver.manage().window().maximize();

            driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("kadmin@test.com");
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
            driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']")).click();

          WebElement leaveManage=  driver.findElement(By.xpath("(//a[@class='nav-link active nav-item '])"));
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].click();", leaveManage);

            WebElement addBalance=  driver.findElement(By.xpath("//a[contains(@href,'https://ourattendance.com/web-portal_uat/public/leavebalance/add')]"));
           JavascriptExecutor js1= (JavascriptExecutor) driver;
           js1.executeScript("arguments[0].click();", addBalance);

            WebElement eId= driver.findElement(By.xpath("//input[@name='user_id']"));
            eId.click(); eId.sendKeys("");

            WebElement pL=  driver.findElement(By.xpath("//input[@name='paid_leaves']"));
            pL.click(); pL.sendKeys("");

            WebElement cL=driver.findElement(By.xpath("//input[@name='casual_leaves']"));
           cL.click(); cL.sendKeys("");

             WebElement sL=  driver.findElement(By.xpath("//input[@name='sick_leaves']"));
            sL.click(); sL.sendKeys("");

              WebElement year=driver.findElement(By.xpath("//select[@name='year']"));
              year.click();
              Select s1=new Select(year);
              s1.selectByVisibleText("");

             WebElement submit=   driver.findElement(By.xpath("//button[@name='submit']"));
            submit.click();

    }
}
