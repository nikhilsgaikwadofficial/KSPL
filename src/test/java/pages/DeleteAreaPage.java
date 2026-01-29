package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteAreaPage extends BasePage{
    WebDriver driver;

    public DeleteAreaPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By master = By.xpath("(//i[@class='fa fa-database '])");
    By area=By.xpath("(//i[@class='fa fa-map-marked-alt '])");
    By List=By.xpath("//a[@href='https://ourattendance.com/web-portal_uat/public/areas']");
    By delete=By.xpath("(//i[@class='fa fa-trash'])[7]");


}
