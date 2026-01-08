package commons;

import java.net.URI;
import java.net.URL;
import java.util.Set;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver; 


public class BaseTest {

    private AppiumDriver driver;

    public AppiumDriver getDriver(){
        return this.driver;
    }

    public static AppiumDriver getDriver(Platform platform, String deviceName, int appiumPort){
        AppiumDriver driver = null;
        URL appiumServer = null;

        try{
             appiumServer = URI.create("http://127.0.0.1:" + appiumPort).toURL();

        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (platform) {
            case ANDROID:
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setDeviceName(deviceName);
            options.setAppPackage("com.yum.restauranthub.qa");
            options.setAppActivity("com.yum.restauranthub.MainActivity");
            driver = new AndroidDriver(appiumServer, options);
            break;

            case IOS:
            //Todo: Add iOS driver setup
            break;
        }
        return driver;
}


public static void switchToWebView(AppiumDriver driver, Platform platform) {
    try {
        Set<String> contexts = null;
        switch(platform){
            case ANDROID:
            contexts = ((AndroidDriver) driver).getContextHandles();
            break;

            case IOS:
            contexts = ((IOSDriver)driver).getContextHandles();
            break;
        }

        for (String context : contexts) {
            System.out.println("Available context: " + context);
        }
        for (String context : contexts) {
            if (context.contains("WEBVIEW")) {
                switchToContext(driver, context, platform);
                System.out.println("Switched to WebView context: " + context);
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void switchToContext(AppiumDriver driver, String context, Platform platform){
    switch(platform){
        case ANDROID:
        ((AndroidDriver) driver).context(context);
        break;

        case IOS:
        ((IOSDriver) driver).context(context);
        break;  
    }
}

public static void switchToNativeApp(AppiumDriver driver, Platform platform) {
    try {
        switch(platform){
            case ANDROID:
            ((AndroidDriver) driver).context("NATIVE_APP");
            break;

            case IOS:
            ((IOSDriver) driver).context("NATIVE_APP");
            break;
        }
        System.out.println("Switched back to Native App context");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void closeSession(AppiumDriver driver) {
    if(driver != null){
        driver.quit();
    }
}

public void sleepInSeconds(long seconds){
    try {
        Thread.sleep(seconds * 1000);
    } catch (Exception e) {
}
}
}
