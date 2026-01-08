package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.ActionPlanPageUI;

public class ActionPlanPageObject extends BasePage {
    private AppiumDriver driver;

    public ActionPlanPageObject (AppiumDriver driver){
        this.driver = driver;
    }

    public void clickToActionPlanIcon() {
        waitForElementVisible(driver, ActionPlanPageUI.ACTION_PLAN_ICON);
        clickToElement(driver, ActionPlanPageUI.ACTION_PLAN_ICON );
        sleepInSecond(1);
    }

    public String getActionPlanText() {
        waitForElementVisible(driver, ActionPlanPageUI.ACTION_PLAN_TEXT);
        return getElementText(driver, ActionPlanPageUI.ACTION_PLAN_TEXT);
    }
}
