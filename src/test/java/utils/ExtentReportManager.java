package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static final String REPORT_PATH = "test-output/ExtentReports/";

    public static ExtentReports getExtentReport() {
        if (extent == null) {
            extent = createExtentReport();
        }
        return extent;
    }

    private static ExtentReports createExtentReport() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "LoginValidationReport_" + timestamp + ".html";
        String fullPath = REPORT_PATH + reportName;

        new File(REPORT_PATH).mkdirs();

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fullPath);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("Login Validation Test Report");
        sparkReporter.config().setDocumentTitle("OurAttendance - Login Test Results");
        sparkReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Project", "OurAttendance Web Portal");
        extent.setSystemInfo("Environment", "UAT");
        extent.setSystemInfo("Browser", "Chrome");

        return extent;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
