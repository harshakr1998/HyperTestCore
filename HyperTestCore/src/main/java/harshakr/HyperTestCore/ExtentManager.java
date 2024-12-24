package harshakr.HyperTestCore;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setDocumentTitle("Automation Test Report");
            htmlReporter.config().setReportName("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Tester", "Your Name");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
