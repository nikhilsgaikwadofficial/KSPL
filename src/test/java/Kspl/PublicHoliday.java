package Kspl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PublicHoliday {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://ourattendance.com/web-portal_uat/public/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("kadmin@test.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']")).click();

        WebElement master = driver.findElement(By.xpath("//i[@class='fa fa-database ']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", master);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
       WebElement holiday= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-calendar '])[1]")));
        JavascriptExecutor js1=(JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click():",holiday);

      /*  WebElement holiday= driver.findElement(By.xpath("(//i[@class='fa fa-calendar '])[1]"));
        JavascriptExecutor js1=(JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click():",holiday);*/

        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addholi=wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-edit '])[3]")));
        JavascriptExecutor js2=(JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();",addholi);


       /* WebElement addholiday= driver.findElement(By.xpath("//a[@class='nav-link active ']"));
        JavascriptExecutor js2=(JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();",addholiday);*/
    }
}
