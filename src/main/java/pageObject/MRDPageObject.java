package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.MRDPageUI;

public class MRDPageObject extends BasePage {
    private AppiumDriver driver;

    public MRDPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickToMRDIcon() {
        waitForElementVisible(driver, MRDPageUI.MRD_ICON);
        clickToElement(driver, MRDPageUI.MRD_ICON);
        sleepInSecond(1);
    }

    public String getProductsText() {
        waitForElementVisible(driver, MRDPageUI.PRODUCTS_TEXT);
        return getElementText(driver, MRDPageUI.PRODUCTS_TEXT);
    }
}
