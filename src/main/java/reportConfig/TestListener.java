package reportConfig;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import commons.BaseTest;
import io.appium.java_client.AppiumDriver;
import utilities.ScreenshotHelper;

public class TestListener implements ITestListener {
    
    @Override
    public void onStart(ITestContext context) {
        System.out.println("========== Test Suite Started: " + context.getName() + " ==========");
        ExtentReportManager.createInstance();
    }
    
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("========== Test Suite Finished: " + context.getName() + " ==========");
        System.out.println("Total Tests: " + context.getAllTestMethods().length);
        System.out.println("Passed: " + context.getPassedTests().size());
        System.out.println("Failed: " + context.getFailedTests().size());
        System.out.println("Skipped: " + context.getSkippedTests().size());
        
        ExtentReportManager.flush();
        System.out.println("Report generated: " + ExtentReportManager.getReportPath());
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        String className = result.getTestClass().getName();
        
        // Start test with category and author
        ExtentReportManager.startTest(
            testName,
            description != null ? description : testName,
            "Smoke Test",  // Category
            "QA Team"      // Author
        );
        
        ExtentReportManager.logInfo("Test Class: " + className);
        ExtentReportManager.logInfo("Test Method: " + testName);
        ExtentReportManager.logInfo("========== Test Execution Started ==========");
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        long duration = (result.getEndMillis() - result.getStartMillis()) / 1000;
        
        ExtentReportManager.logPass("Test PASSED: " + testName);
        ExtentReportManager.logInfo("Execution Time: " + duration + " seconds");
        
        // Add colored markup (v5.x feature)
        ExtentReportManager.getTest().pass(
            MarkupHelper.createLabel("Test Passed Successfully", ExtentColor.GREEN)
        );
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        long duration = (result.getEndMillis() - result.getStartMillis()) / 1000;
        
        ExtentReportManager.logFail("Test FAILED: " + testName);
        ExtentReportManager.logFail("Error: " + result.getThrowable().getMessage());
        ExtentReportManager.logInfo("Execution Time: " + duration + " seconds");
        
        // Add colored markup
        ExtentReportManager.getTest().fail(
            MarkupHelper.createLabel("Test Failed", ExtentColor.RED)
        );
        
        // Capture and attach screenshot
        try {
            Object testInstance = result.getInstance();
            if (testInstance instanceof BaseTest) {
                AppiumDriver driver = ((BaseTest) testInstance).getDriver();
                if (driver != null) {
//                    // Method 1: Save screenshot to file
//                    String screenshotPath = ScreenshotHelper.captureScreenshot(driver, testName);
//                    if (screenshotPath != null) {
//                        ExtentReportManager.getTest().fail("Failure Screenshot",
//                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//                    }
                    
//                     Method 2: Embed Base64 screenshot (alternative)
                     String base64 = ScreenshotHelper.getBase64Screenshot(driver);
                     if (base64 != null) {
                         ExtentReportManager.getTest().fail("Failure Screenshot",
                             MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
                     }
                }
            }
        } catch (Exception e) {
            ExtentReportManager.logWarning("Could not capture screenshot: " + e.getMessage());
        }
        
        // Add stack trace
        ExtentReportManager.getTest().fail(result.getThrowable());
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        
        ExtentReportManager.logSkip("Test SKIPPED: " + testName);
        if (result.getThrowable() != null) {
            ExtentReportManager.logSkip("Reason: " + result.getThrowable().getMessage());
        }
        
        // Add colored markup
        ExtentReportManager.getTest().skip(
            MarkupHelper.createLabel("Test Skipped", ExtentColor.YELLOW)
        );
    }
}