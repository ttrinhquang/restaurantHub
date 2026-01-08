// import io.appium.java_client.AppiumBy;
// import io.appium.java_client.AppiumDriver;
// import java.util.Set;

// public class WebViewHelper {
    
//     public static void switchToWebView(AppiumDriver driver) {
//         try {
//             // Get all available contexts
//             Set<String> contexts = driver.getContextHandles();
            
//             // Print all contexts for debugging
//             for (String context : contexts) {
//                 System.out.println("Available context: " + context);
//             }
            
//             // Switch to WebView context (usually contains "WEBVIEW")
//             for (String context : contexts) {
//                 if (context.contains("WEBVIEW")) {
//                     driver.context(context);
//                     System.out.println("Switched to WebView context: " + context);
//                     break;
//                 }
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
    
//     public static void switchToNativeApp(AppiumDriver driver) {
//         try {
//             // Switch back to native app context
//             driver.context("NATIVE_APP");
//             System.out.println("Switched back to Native App context");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }