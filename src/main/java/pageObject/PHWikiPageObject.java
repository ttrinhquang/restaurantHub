package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.PHWikiPageUI;

public class PHWikiPageObject extends BasePage {
    private AppiumDriver driver;

    public PHWikiPageObject(AppiumDriver driver){
        this.driver = driver;
    }

    
    public void clickToPHWikiIcon() {
        waitForElementVisible(driver, PHWikiPageUI.PH_WIKI_ICON);
        clickToElement(driver, PHWikiPageUI.PH_WIKI_ICON);
        sleepInSecond(1);
    }

    public String getSignInToYUMText() {
        waitForElementVisible(driver, PHWikiPageUI.SIGN_IN_TO_YUM_TEXT);
        return getElementText(driver, PHWikiPageUI.SIGN_IN_TO_YUM_TEXT);
    }
}
