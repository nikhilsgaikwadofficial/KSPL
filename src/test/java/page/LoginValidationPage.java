package page;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginValidationPage {


    WebDriver driver;
    WebDriverWait wait;


    // Updated locators to match the actual application
    By usernameField = By.xpath("//input[@placeholder='Email']");
    By passwordField = By.xpath("//input[@placeholder='Password']");
    By signInButton = By.xpath("//button[@class='btn btn-primary btn-block btn-flat']");
    By errorMsg = By.xpath("//div[contains(@class,'alert-danger')]");
    By dashboard = By.xpath("//a[contains(@href,'/logout')]");


    public LoginValidationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void Username(String user) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        el.clear();
        el.sendKeys(user);
    }


    public void password(String pass) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        el.clear();
        el.sendKeys(pass);
    }


    public void SignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }


    public String getErrorMessage() {
        try {
            WebElement err = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            return err.getText();
        } catch (Exception e) {
            return "";
        }
    }


    public boolean isDashboardDisplayed() {
        try {
            // Check both for the logout element and if URL navigated away from login
            boolean urlChanged = wait.until(driver -> !driver.getCurrentUrl().contains("/login"));
            if (urlChanged) {
                return wait.until(ExpectedConditions.presenceOfElementLocated(dashboard)).isDisplayed();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}
