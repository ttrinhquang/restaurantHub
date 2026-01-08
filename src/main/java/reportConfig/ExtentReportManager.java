package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static String reportPath;
    
    /**
     * Initialize ExtentReports with Spark Reporter (v5.x)
     */
    public static ExtentReports createInstance() {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportDir = System.getProperty("user.dir") + "/test-output/extent-reports/";
        reportPath = reportDir + "ExtentReport_" + timestamp + ".html";
        
        // Create directory if not exists
        File dir = new File(reportDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        // ExtentSparkReporter - new in v5.x
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        
        // Configure Spark Reporter
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Restaurant Hub - Automation Report");
        sparkReporter.config().setReportName("Mobile Test Execution Results");
        sparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        sparkReporter.config().setEncoding("UTF-8");
        sparkReporter.config().setCss(".badge-primary { background-color: #0d6efd; }");
        sparkReporter.config().setJs("document.title = 'Restaurant Hub Report';");
        
        // View order customization (v5.x feature)
        sparkReporter.viewConfigurer()
            .viewOrder()
            .as(new ViewName[] {
                ViewName.DASHBOARD,
                ViewName.TEST,
                ViewName.CATEGORY,
                ViewName.AUTHOR,
                ViewName.DEVICE,
                ViewName.EXCEPTION,
                ViewName.LOG
            })
            .apply();
        
        // Create ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        // System/Environment Information
        extent.setSystemInfo("Application", "Restaurant Hub");
        extent.setSystemInfo("Platform", "Android/iOS");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("Architecture", System.getProperty("os.arch"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Appium Version", "2.0");
        
        return extent;
    }
    
    /**
     * Get or create ExtentReports instance
     */
    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }
    
    /**
     * Create a new test entry
     */
    public static synchronized ExtentTest startTest(String testName, String description) {
        ExtentTest test = getInstance().createTest(testName, description);
        extentTest.set(test);
        return test;
    }
    
    /**
     * Create test with category and author (v5.x feature)
     */
    public static synchronized ExtentTest startTest(String testName, String description, 
                                                    String category, String author) {
        ExtentTest test = getInstance().createTest(testName, description);
        test.assignCategory(category);
        test.assignAuthor(author);
        test.assignDevice(System.getProperty("os.name"));
        extentTest.set(test);
        return test;
    }
    
    /**
     * Get current test
     */
    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }
    
    /**
     * Create child test (nested tests)
     */
    public static synchronized ExtentTest createNode(String nodeName) {
        return getTest().createNode(nodeName);
    }
    
    // Logging methods
    public static void logInfo(String message) {
        getTest().log(Status.INFO, message);
    }
    
    public static void logPass(String message) {
        getTest().log(Status.PASS, "✓ " + message);
    }
    
    public static void logFail(String message) {
        getTest().log(Status.FAIL, "✗ " + message);
    }
    
    public static void logSkip(String message) {
        getTest().log(Status.SKIP, "⊘ " + message);
    }
    
    public static void logWarning(String message) {
        getTest().log(Status.WARNING, "⚠ " + message);
    }
    
    /**
     * Assign category to test
     */
    public static void assignCategory(String... categories) {
        getTest().assignCategory(categories);
    }
    
    /**
     * Assign author to test
     */
    public static void assignAuthor(String... authors) {
        getTest().assignAuthor(authors);
    }
    
    /**
     * Assign device to test
     */
    public static void assignDevice(String... devices) {
        getTest().assignDevice(devices);
    }
    
    /**
     * Flush and finalize report
     */
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
    
    /**
     * Get report file path
     */
    public static String getReportPath() {
        return reportPath;
    }
}