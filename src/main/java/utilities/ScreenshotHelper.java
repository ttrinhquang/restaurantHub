package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;

public class ScreenshotHelper {
    
    /**
     * Capture screenshot and save to file
     */
    public static String captureScreenshot(AppiumDriver driver, String screenshotName) {
        try {
            String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            String fileName = screenshotName + "_" + timestamp + ".png";
            
            String screenshotDir = System.getProperty("user.dir") + "/test-output/screenshots/";
            String screenshotPath = screenshotDir + fileName;
            
            // Create directory if not exists
            File dir = new File(screenshotDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            // Capture screenshot
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotPath);
            FileUtils.copyFile(source, destination);
            
            System.out.println("Screenshot saved: " + screenshotPath);
            return screenshotPath;
            
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Get screenshot as Base64 string (for embedding in reports)
     */
    public static String getBase64Screenshot(AppiumDriver driver) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            System.err.println("Failed to capture Base64 screenshot: " + e.getMessage());
            return null;
        }
    }
}