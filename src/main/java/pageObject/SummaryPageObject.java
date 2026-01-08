package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.SummaryPageUI;


public class SummaryPageObject extends BasePage {
    private AppiumDriver driver;

    public SummaryPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickToSummaryIcon() {
        waitForElementVisible(driver, SummaryPageUI.SUMMARY_ICON);
        clickToElement(driver, SummaryPageUI.SUMMARY_ICON);
        sleepInSecond(1);
    }

    public void tapToViewHistoryText() {
        waitForElementVisible(driver, SummaryPageUI.VIEW_HISTORY_TEXT);
        tapToElement(driver, SummaryPageUI.VIEW_HISTORY_TEXT);
    }

    public String getWeeklyOverallScoreText() {
        waitForElementVisible(driver, SummaryPageUI.WEEKLY_OVERALL_SCORE_TEXT);
        return getElementText(driver, SummaryPageUI.WEEKLY_OVERALL_SCORE_TEXT);
    }

    public String getScoreBreakdownText() {
        waitForElementVisible(driver, SummaryPageUI.SCORE_BREAKDOWN_TEXT);
        return getElementText(driver, SummaryPageUI.SCORE_BREAKDOWN_TEXT);
    }

    public String getKeyMetricsText() {
        waitForElementVisible(driver, SummaryPageUI.KEY_METRICS_TEXT);
        return getElementText(driver, SummaryPageUI.KEY_METRICS_TEXT);
    }


    public void tapToIIcon() {
        waitForElementVisible(driver, SummaryPageUI.I_ICON);
        tapToElement(driver, SummaryPageUI.I_ICON);
    }

    public void tapToIIconMonth() {
        waitForElementVisible(driver, SummaryPageUI.I_ICON_MONTH);
        tapToElement(driver, SummaryPageUI.I_ICON_MONTH);
    }

    public boolean isThePopUpDisplayed() {
        waitForElementVisible(driver, SummaryPageUI.HUTBOT_ON_TIME_POPUP);
        return isElementDisplayed(driver, SummaryPageUI.HUTBOT_ON_TIME_POPUP);
    }

    public void tapToMonthButton() {
        waitForElementVisible(driver, SummaryPageUI.MONTH_BUTTON);
        tapToElement(driver, SummaryPageUI.MONTH_BUTTON);
    }

    public String getMonthlyOverallScoreText() {
        waitForElementVisible(driver, SummaryPageUI.MONTHLY_OVERALL_SCORE_TEXT);
        return getElementText(driver, SummaryPageUI.MONTHLY_OVERALL_SCORE_TEXT);
    }


    public String getBrandText() {
        waitForElementVisible(driver, SummaryPageUI.BRAND_TEXT);
        return getElementText(driver, SummaryPageUI.BRAND_TEXT);
    }

    public void tapToScorecardHistoryText() {
        waitForElementVisible(driver, SummaryPageUI.SCORECARD_HISTORY_TEXT);
        tapToElement(driver, SummaryPageUI.SCORECARD_HISTORY_TEXT);
    }


    public String getWeeklyLeaderboardText() {
        waitForElementVisible(driver, SummaryPageUI.WEEKLY_LEADERBOARD_TEXT);
        return getElementText(driver, SummaryPageUI.WEEKLY_LEADERBOARD_TEXT);
    }

    public String getWhatGuestsAreTellingUsText() {
        waitForElementVisible(driver, SummaryPageUI.WHAT_GUEST_ARE_TELLING_US_TEXT);
        return getElementText(driver, SummaryPageUI.WHAT_GUEST_ARE_TELLING_US_TEXT);
    }

    public void tapToViewFullScoreCardButton() {
        waitForElementVisible(driver, SummaryPageUI.VIEW_FULL_SCORECARD_BUTTON);
        tapToElement(driver, SummaryPageUI.VIEW_FULL_SCORECARD_BUTTON);
    }

    public String getGrowthText() {
        waitForElementVisible(driver, SummaryPageUI.GROWTH_TEXT);
        return getElementText(driver, SummaryPageUI.GROWTH_TEXT);
    }

    public String getBestJobsText() {
        waitForElementVisible(driver, SummaryPageUI.BEST_JOBS_TEXT);
        return getElementText(driver, SummaryPageUI.BEST_JOBS_TEXT);
    }

    public String getBestMomentsText() {
        waitForElementVisible(driver, SummaryPageUI.BEST_MOMMENTS_TEXT);
        return getElementText(driver, SummaryPageUI.BEST_MOMMENTS_TEXT);

    }

    public String getBestOperationsText() {
        waitForElementVisible(driver, SummaryPageUI.BEST_OPERATIONS_TEXT);
        return getElementText(driver, SummaryPageUI.BEST_OPERATIONS_TEXT);
    }

    public boolean isGrowthTextDisplayed() {
        return isElementDisplayed(driver, SummaryPageUI.GROWTH_TEXT);
    }

    public void tapToCloseIcon() {
        waitForElementVisible(driver, SummaryPageUI.CLOSE_ICON);
        tapToElement(driver, SummaryPageUI.CLOSE_ICON);
    }

    public void tapToViewFullLeaderBoardButton() {
        waitForElementVisible(driver, SummaryPageUI.VIEW_FULL_LEADERBOARD_BUTTON);
        tapToElement(driver, SummaryPageUI.VIEW_FULL_LEADERBOARD_BUTTON);
    }

    public String getAllRestaurantsText() {
        waitForElementVisible(driver, SummaryPageUI.ALL_RESTAURANTS_TEXT);
        return getElementText(driver, SummaryPageUI.ALL_RESTAURANTS_TEXT);
    }

    public boolean isAllRestaurantTextDisplayed() {
        return isElementDisplayed(driver, SummaryPageUI.ALL_RESTAURANTS_TEXT);
    }


}
