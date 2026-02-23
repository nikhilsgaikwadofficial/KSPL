package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    private static final Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    private static final ExtentReports extent = ExtentReportManager.getExtentReport();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized void startTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
    }

    public static synchronized void endTest() {
        extentTestMap.remove((int) Thread.currentThread().getId());
    }

    public static synchronized void logInfo(String message) {
        ExtentTest test = getTest();
        if (test != null) {
            test.log(Status.INFO, message);
        }
    }

    public static synchronized void logPass(String message) {
        ExtentTest test = getTest();
        if (test != null) {
            test.log(Status.PASS, message);
        }
    }

    public static synchronized void logFail(String message) {
        ExtentTest test = getTest();
        if (test != null) {
            test.log(Status.FAIL, message);
        }
    }

    public static synchronized void logSkip(String message) {
        ExtentTest test = getTest();
        if (test != null) {
            test.log(Status.SKIP, message);
        }
    }
}
