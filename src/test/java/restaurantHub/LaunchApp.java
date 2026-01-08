

// package restaurantHub;

// import io.appium.java_client.AppiumBy;
// import io.appium.java_client.AppiumDriver;

// import java.time.Duration;

// import org.openqa.selenium.By;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import commons.BaseTest;
// import commons.Platform;


// public class LaunchApp extends BaseTest {
//     public static void main(String[] args) {
        
//         AppiumDriver driver = null; // Declare driver outside try block
        
//         try {
//             driver = BaseTest.getDriver(Platform.ANDROID);
//             Thread.sleep(5000);
//             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//             By allowPopup = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")");
//             wait.until(ExpectedConditions.visibilityOfElementLocated(allowPopup)).click();
    
//             By connectPopup = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")");
//             wait.until(ExpectedConditions.visibilityOfElementLocated(connectPopup)).click();
    
//             By loginButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");  
    
//             wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    
            
//             By usernameTextbox = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"userId\")");
//             wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextbox)).sendKeys("qdt3280");
    
//             By passwordTextbox = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"password\")");
//             wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextbox)).sendKeys("li69nux@X1234567");
    
//             By loginButtonWebView = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"submit\")");
//             wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonWebView)).click();
//             Thread.sleep(10000);

//         } catch (Exception e) {
//             e.printStackTrace(); 
//         }


//         //Close Session
//         if (driver != null) {
//             driver.quit();
//         }
//     }
// }