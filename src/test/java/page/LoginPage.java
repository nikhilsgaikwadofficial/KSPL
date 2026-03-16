package page;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import page.BasePage;
import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By emailInput = By.xpath("//input[@placeholder='Email']");
    public By passwordInput = By.xpath("//input[@placeholder='Password']");
    public By signInButton = By.xpath("//button[@class='btn btn-primary btn-block btn-flat']");
    public By alertMessage = By.xpath("//div[contains(@class,'alert-danger')]");
    public By successIndicator = By.xpath("//a[contains(@href,'/logout')]");
    
    // Exact logout locators provided by user
    public By userDropdownToggle = By.xpath("//img[@class='user-image img-circle elevation-2']");
    public By logoutBtn = By.xpath("//a[@id='logoutBtn']");

    public void enterEmail(String email) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        el.clear();
        el.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        el.clear();
        el.sendKeys(password);
    }

    public void clickSignIn() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        btn.click();
    }

    public String getAlertMessage() {
        try {
            WebElement msg = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
            return msg.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getValidationMessage(By locator) {
        try {
            return (String) js.executeScript("return arguments[0].validationMessage;", driver.findElement(locator));
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isLoginSuccessful() {
        try {
            // Wait for the browser to navigate away from the login page (up to 10s)
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(d -> !d.getCurrentUrl().contains("/login"));
            String url = driver.getCurrentUrl();
            System.out.println("Current URL after login attempt: " + url);
            return !url.contains("/login");
        } catch (Exception e) {
            // Still on /login after timeout → login failed (bad credentials, error shown, etc.)
            System.out.println("isLoginSuccessful() → still on login page after 10s, login failed.");
            return false;
        }
    }

    public void logout() {
        try {
            if (driver.getCurrentUrl().contains("/login")) {
                System.out.println("Already on login page, skipping logout.");
                return;
            }

            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Click user profile dropdown
            try {
                WebElement toggle = shortWait.until(ExpectedConditions.elementToBeClickable(userDropdownToggle));
                toggle.click();
                System.out.println("Clicked user profile dropdown using provided locator.");
            } catch (Exception e) {
                System.out.println("User dropdown toggle not clickable: " + e.getMessage());
            }

            // Click logout button
            try {
                WebElement btn = shortWait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
                btn.click();
                System.out.println("Clicked logout button using provided locator.");
            } catch (Exception e) {
                System.out.println("Logout button not clickable: " + e.getMessage());
            }

            // Wait for redirect to login page
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlContains("/login"));
            System.out.println("Logout successful. Current URL: " + driver.getCurrentUrl());

        } catch (Exception e) {
            System.out.println("Logout process encountered an error: " + e.getMessage());
        }
    }


    public void Username(String email) { 
        System.out.println("Entering username: " + email);
        enterEmail(email); 
    }
    public void password(String pass) { 
        System.out.println("Entering password: [PROTECTED]");
        enterPassword(pass); 
    }
    public void Signin() { 
        System.out.println("Clicking Sign In");
        clickSignIn(); 
    }
    public boolean isDashboardDisplayed() { return isLoginSuccessful(); }
    public String getErrorMessage() { return getAlertMessage(); }
}
