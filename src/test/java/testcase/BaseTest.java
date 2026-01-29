package testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public WebDriver driver;
    @BeforeClass
    public void setUp(){


        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ourattendance.com/web-portal_uat/public/home");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("venture@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']")).click();
    }
    @AfterClass
    public void tearDown()  {

     //driver.quit();
}}
