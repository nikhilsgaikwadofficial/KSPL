package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

        public WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ourattendance.com/web-portal_uat/public/home");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void logScenario(Method method) {
        String packageName = method.getDeclaringClass().getPackage().getName();
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();

        System.out.println("\n" + "=".repeat(80));
        System.out.println("PACKAGE  : " + packageName);
        System.out.println("CLASS    : " + className);
        System.out.println("SCENARIO : " + methodName);
        System.out.println("=".repeat(80));
    }

    public void login(String email, String password) {
        driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']")).click();
    }

    public void login() {
        login("goldys8ul@gmail.com", "S8ulmortal");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

