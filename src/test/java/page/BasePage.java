package page;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
        protected WebDriver driver;
        protected JavascriptExecutor js;
        protected WebDriverWait wait;
        public BasePage(WebDriver driver){
            this.driver=driver;
            this.js=(JavascriptExecutor)driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }

    }

