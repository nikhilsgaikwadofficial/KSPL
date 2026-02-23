package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }
   WebElement Username= driver.findElement(By.xpath("//input[@placeholder='Email']"));
    WebElement pwd= driver.findElement(By.xpath("//input[@placeholder='Password']"));
    WebElement signin= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']"));
    By errorMessage = By.xpath("//div[contains(@class,'alert')]");

    public void Username(String name){
    Username.click();
    Username.sendKeys(name);
}

    public void password(String pass){
    pwd.click();
    pwd.sendKeys(pass);
}
public void Signin(){
        signin.click();


    }



    public boolean isDashboardDisplayed() {
        try {
            wait.until(ExpectedConditions.urlContains("dashboard"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }


}
