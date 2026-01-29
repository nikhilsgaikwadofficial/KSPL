package Kspl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Kspl {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://ksplwebsite.kanishkatech.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.xpath("//button[@aria-label='Back to top']//*[name()='svg']")).click();
        driver.findElement(By.xpath("//div[@class=\"bg-white pointer-events-auto rounded-b-[72px]\"]//div//span[contains(text(),\"Book a Demo\")]"))
                .click();
    }
}
