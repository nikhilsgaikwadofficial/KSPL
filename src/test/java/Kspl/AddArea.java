package Kspl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddArea {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =new ChromeDriver();

        driver.get("https://ourattendance.com/web-portal_uat/public/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("kadmin@test.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']")).click();




        WebElement master = driver.findElement(By.xpath("//i[@class='fa fa-database ']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", master);

        WebElement area= driver.findElement(By.xpath("(//i[@class='fa fa-map-marked-alt '])"));
        JavascriptExecutor js1=(JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();",area);

        WebElement add= driver.findElement(By.xpath("(//i[@class='fa fa-edit '])[1]"));
        JavascriptExecutor js2=(JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();",add);

       WebElement state= driver.findElement(By.xpath("//select[@id='states']"));
        Select  s= new Select(state);
        s.selectByVisibleText("Bihar");

       WebElement name= driver.findElement(By.xpath("//input[@name='name']"));
       name.click();
       name.sendKeys("Kanishka Software");
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Vasai");
       WebElement lati= driver.findElement(By.xpath("//input[@name='lat']"));
       lati.sendKeys("22.808244");
       WebElement longi= driver.findElement(By.xpath("//input[@name='long']"));
       longi.sendKeys("92.0808273");


       WebElement worktype= driver.findElement(By.xpath("//select[@name='work_type']"));
        worktype.click();
        Select ss2=new Select(worktype);
        ss2.selectByVisibleText("Hourly");

        driver.findElement(By.xpath("//input[@name='working_hours']")).sendKeys("9:00");

        driver.findElement(By.xpath("//input[@name='start_time']")).sendKeys("9:30");

        driver.findElement(By.xpath("//input[@name='end_time']")).sendKeys("19:30");

        WebElement forceout= driver.findElement(By.xpath("//select[@id='enable_force_checkout']"));
        Select ss=new Select(forceout);
        ss.selectByVisibleText("Yes");

        WebElement allowlate= driver.findElement(By.xpath("//select[@name='allow_late']"));
        allowlate.click();
        Select ss1=new Select(allowlate);
        ss1.selectByVisibleText("Yes");



        WebElement radius= driver.findElement(By.xpath("//select[@id='enable_radius']"));
        radius.click();
        Select ss3=new Select(radius);
        ss3.selectByVisibleText("Yes");
        driver.findElement(By.xpath("//input[@name='radius_value']")).sendKeys("0656");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("saveLocationData")));

        saveBtn.click();


        //driver.findElement(By.xpath("//button[@id='saveLocationData']")).click();


    }
}
