package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.ARPageUI;

public class ARPageObject extends BasePage {
    private AppiumDriver driver;

    public ARPageObject(AppiumDriver driver){
        this.driver = driver;
    }

    public void clickToARIcon() {
        waitForElementVisible(driver, ARPageUI.AR_ICON);
        clickToElement(driver, ARPageUI.AR_ICON);
        sleepInSecond(1);

    }

    public String getSelectBrandText() {
        waitForElementVisible(driver, ARPageUI.SELECT_BRAND_TEXT);
        return getElementText(driver, ARPageUI.SELECT_BRAND_TEXT);
    }
}
