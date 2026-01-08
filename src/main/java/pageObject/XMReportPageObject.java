package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.XMReportPageUI;

public class XMReportPageObject extends BasePage {
    private AppiumDriver driver;

    public XMReportPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickToXMReportIcon() {
        waitForElementVisible(driver, XMReportPageUI.XM_REPORT_ICON);
        clickToElement(driver, XMReportPageUI.XM_REPORT_ICON);
        sleepInSecond(2);
    }

    public String getXMReportText() {
        waitForElementVisible(driver, XMReportPageUI.XM_REPORT_TEXT);
        return getElementText(driver, XMReportPageUI.XM_REPORT_TEXT);
    }

    public String getWinScoreText() {
        waitForElementVisible(driver, XMReportPageUI.WIN_SCORE_TEXT);
        return getElementText(driver, XMReportPageUI.WIN_SCORE_TEXT);
    }

    public String getSmartOSATText() {
        waitForElementVisible(driver, XMReportPageUI.SMART_OSAT_TEXT);
        return getElementText(driver, XMReportPageUI.SMART_OSAT_TEXT);
    }

    public String getAggregatorText() {
        waitForElementVisible(driver, XMReportPageUI.AGGREGATOR_TEXT);
        return getElementText(driver, XMReportPageUI.AGGREGATOR_TEXT);
    }

    public String getSocialText() {
        waitForElementVisible(driver, XMReportPageUI.SOCIAL_TEXT);
        return getElementText(driver, XMReportPageUI.SOCIAL_TEXT);
    }

    public String getBestMomentsText() {
        waitForElementVisible(driver, XMReportPageUI.BEST_MOMENTS_TEXT);
       return getElementText(driver, XMReportPageUI.BEST_MOMENTS_TEXT);
    }

    public String getBestOperationsText() {
        waitForElementVisible(driver, XMReportPageUI.BEST_OPERATIONS_TEXT);
        return getElementText(driver, XMReportPageUI.BEST_OPERATIONS_TEXT);

    }

    public String getWhereOurGuestsSayToFocusText() {
        waitForElementVisible(driver, XMReportPageUI.WHERE_OUR_GUESTS_SAY_TO_FOCUS_TEXT);
        return getElementText(driver, XMReportPageUI.WHERE_OUR_GUESTS_SAY_TO_FOCUS_TEXT);
    }

    public String getEmergingThemeText() {
        waitForElementVisible(driver, XMReportPageUI.EMERGING_THEME_TEXT);
        return getElementText(driver, XMReportPageUI.EMERGING_THEME_TEXT);
    }


    public String getRecognitionText() {
        waitForElementVisible(driver, XMReportPageUI.RECOGNITION_TEXT);
       return  getElementText(driver, XMReportPageUI.RECOGNITION_TEXT);
    }

    public String getWinScoreTrendText() {
        waitForElementVisible(driver, XMReportPageUI.WIN_SCORE_TREND_TEXT);
        return getElementText(driver, XMReportPageUI.WIN_SCORE_TREND_TEXT);
    }

    public String getWinScoreB2BTrendText() {
        waitForElementVisible(driver, XMReportPageUI.WIN_SCORE_B2B_TREND_TEXT);
       return getElementText(driver, XMReportPageUI.WIN_SCORE_B2B_TREND_TEXT);
    }


    public void tapToIIcon() {
        waitForElementVisible(driver, XMReportPageUI.I_ICON);
        tapToElement(driver, XMReportPageUI.I_ICON);
    }

    public boolean isWinScoreTextDisplayed() {
        waitForElementVisible(driver, XMReportPageUI.WIN_SCORE_TEXT_POP_UP);
        return isElementDisplayed(driver, XMReportPageUI.WIN_SCORE_TEXT_POP_UP);
    }

    public void tapToWeekButton() {
        waitForElementVisible(driver, XMReportPageUI.WEEK_BUTTON);
        tapToElement(driver, XMReportPageUI.WEEK_BUTTON);
    }
}
