package Kspl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddNotice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ourattendance.com/web-portal_uat/public/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("kadmin@test.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']")).click();


        WebElement master = driver.findElement(By.xpath("//i[@class='fa fa-database ']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", master);

        WebElement notice= driver.findElement(By.xpath("//p[normalize-space()='Notice']"));

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", notice);

        WebElement addNotice= driver.findElement(By.xpath("//p[normalize-space()='Add Notice']"));
        JavascriptExecutor js2=(JavascriptExecutor)driver;
        js2.executeScript("arguments[0].click()",addNotice);

        WebElement title= driver.findElement(By.xpath("//input[@name='title']"));
        title.click();
        title.sendKeys("Christmas party");

        WebElement msg= driver.findElement(By.xpath("//textarea[@name='message']"));
        msg.click();
        msg.sendKeys("Everyone has to come in party on time  ");

       // addNotice.click();
    }
}
