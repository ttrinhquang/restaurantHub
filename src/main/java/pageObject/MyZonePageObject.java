package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.MyZonePageUI;

public class MyZonePageObject extends BasePage {
    private AppiumDriver driver;

    public MyZonePageObject(AppiumDriver driver){
        this.driver = driver;
    }

    public void clickToMyZoneIcon() {
        waitForElementVisible(driver, MyZonePageUI.MY_ZONE_ICON);
        clickToElement(driver, MyZonePageUI.MY_ZONE_ICON);
        sleepInSecond(1);
    }

    public String getALLTIMEText() {
        waitForElementVisible(driver, MyZonePageUI.ALL_TIME_TEXT);
        return getElementText(driver, MyZonePageUI.ALL_TIME_TEXT);
    }

    public String getStoreNameText() {
        waitForElementVisible(driver, MyZonePageUI.STORE_NAME_TEXT);
        return getElementText(driver, MyZonePageUI.STORE_NAME_TEXT);
    }

    public void tapToAllTimeText() {
        waitForElementVisible(driver, MyZonePageUI.ALL_TIME_TEXT);
        tapToElement(driver, MyZonePageUI.ALL_TIME_TEXT);
    }
}
