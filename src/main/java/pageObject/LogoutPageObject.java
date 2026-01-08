package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.LogoutPageUI;

public class LogoutPageObject extends BasePage {
    private AppiumDriver driver;

    public LogoutPageObject(AppiumDriver driver){
        this.driver = driver;
    }

    public void clickToLogOutIcon(){
        waitForElementVisible(driver, LogoutPageUI.LOG_OUT_ICON);
        clickToElement(driver, LogoutPageUI.LOG_OUT_ICON);
        sleepInSecond(1);
    }

}
