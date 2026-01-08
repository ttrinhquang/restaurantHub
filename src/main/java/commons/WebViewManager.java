// import io.appium.java_client.AppiumDriver;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import java.time.Duration;
// import java.util.Set;

// public class WebViewManager {
    
//     public static boolean switchToWebViewWithWait(AppiumDriver driver, int timeoutSeconds) {
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        
//         try {
//             // Wait for WebView context to be available
//             wait.until(d -> {
//                 Set<String> contexts = driver.getContextHandles();
//                 return contexts.stream().anyMatch(context -> context.contains("WEBVIEW"));
//             });
            
//             // Get contexts and switch to WebView
//             Set<String> contexts = driver.getContextHandles();
//             for (String context : contexts) {
//                 if (context.contains("WEBVIEW")) {
//                     driver.context(context);
//                     System.out.println("Successfully switched to WebView: " + context);
//                     return true;
//                 }
//             }
//         } catch (Exception e) {
//             System.err.println("Failed to switch to WebView: " + e.getMessage());
//         }
        
//         return false;
//     }
// }