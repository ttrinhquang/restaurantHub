package restaurantHub;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import reportConfig.TestListener;
import commons.Platform;
import io.appium.java_client.AppiumDriver;
import pageObject.*;
import reportConfig.ExtentReportManager;

@Listeners(TestListener.class)
public class Smoke_Test_QA_Build extends BaseTest {

    private AppiumDriver driver;
    private String storeName = "93 Avenue Mall";

    @Parameters({"platform", "deviceName", "appiumPort"})
    @BeforeClass
    public void beforeClass(@Optional("ANDROID") String platform, @Optional("emulator-5554") String deviceName, @Optional("4725") int appiumPort) {
        // Initialize driver
        driver = getDriver(Platform.valueOf(platform), deviceName, appiumPort);

        // Perform login - this is a precondition for all tests
        LoginPageObject loginPage = new LoginPageObject(driver);
        RestaurantListPageObject restaurantListPage = new RestaurantListPageObject(driver);

        loginPage.clickToAllowPopup();
        loginPage.clickToConnectPopup();
        loginPage.clickToLoginButton();
        loginPage.clickToLoginWithPasswordButton();
        loginPage.enterYumID("hMh6768");
        loginPage.enterPassword("Hutbot@3");
        loginPage.clickToSignInButton();
        restaurantListPage.clickToRestaurant(storeName);
        restaurantListPage.clickToYesButton();
    }


    @Test(description = "Verify that the items in the navigation menu are visible and clickable.")
    public void TC_01_The_Items_In_The_Navaigation_Menu_Are_Visible_And_Clickable() {
        ExtentReportManager.logInfo("Step_01: Tap 'Our Feed' icon.");
        OurFeedPageObject ourFeedPage = new OurFeedPageObject(driver);
        ourFeedPage.tapToOurFeedIcon();

        ExtentReportManager.logInfo("Step_02: Verify that the text 'All Feeds', 'What Guests are telling us' are visible.");
        Assert.assertEquals(ourFeedPage.getAllFeedsText(), "All Feeds");

        ExtentReportManager.logInfo("Step_03: Tap 'Action Plan' icon.");
        ActionPlanPageObject actionPlanPageObject = new ActionPlanPageObject(driver);
        actionPlanPageObject.clickToActionPlanIcon();

        ExtentReportManager.logInfo("Step_04: Verify that the text 'Action Plan' is visible.");
        Assert.assertEquals(actionPlanPageObject.getActionPlanText(), "Action Plan");

        ExtentReportManager.logInfo("Step_05: Tap 'XM Report' icon.");
        XMReportPageObject xmReportPageObject = new XMReportPageObject(driver);
        xmReportPageObject.clickToXMReportIcon();

        ExtentReportManager.logInfo("Step_06: Verify the button 'Week', 'Month' is visible.");
        Assert.assertEquals(xmReportPageObject.getXMReportText().substring(0, 9), "XM Report");

        ExtentReportManager.logInfo("Step_07: Tap 'My Zone' icon.");
        MyZonePageObject myZonePageObject = new MyZonePageObject(driver);
        myZonePageObject.clickToMyZoneIcon();

        ExtentReportManager.logInfo("Step_08: Verify 'All TIME' text is visible.");
        Assert.assertEquals(myZonePageObject.getALLTIMEText(), "ALL TIME");

        ExtentReportManager.logInfo("Step_09: Tap 'MRD' icon.");
        MRDPageObject mrdPageObject = new MRDPageObject(driver);
        mrdPageObject.clickToMRDIcon();

        ExtentReportManager.logInfo("Step_10: Verify the text 'Products' is visible.");
        Assert.assertEquals(mrdPageObject.getProductsText(), "Products");

        ExtentReportManager.logInfo("Step_11: Tap 'AR' icon.");
        ARPageObject arPageObject = new ARPageObject(driver);
        arPageObject.clickToARIcon();

        ExtentReportManager.logInfo("Step_12: Verify the text 'Select Brand' is visible.");
        Assert.assertEquals(arPageObject.getSelectBrandText(), "Select brand");

        ExtentReportManager.logInfo("Step_13: Tap 'PH Wiki' icon.");
        PHWikiPageObject phWikiPageObject = new PHWikiPageObject(driver);
        phWikiPageObject.clickToPHWikiIcon();

        ExtentReportManager.logInfo("Step_14: Verify the button 'Sign in' is visible.");
        Assert.assertEquals(phWikiPageObject.getSignInToYUMText(), "Sign in to Yum! Network");


    }

    @Test(description = "Verify that the Summary page is displayed correctly with the Scorecard and Key Metrics sections")
    public void TC_02_The_Summary_Page_Is_Displayed_Correctly_With_The_ScoreCard_And_Key_Metrics_Sections() {
        ExtentReportManager.logInfo("Step_01: Tap 'Summary' icon.");
        SummaryPageObject summaryPageObject = new SummaryPageObject(driver);
        summaryPageObject.clickToSummaryIcon();

        ExtentReportManager.logInfo("Step_02: Tap 'View History'");
        summaryPageObject.tapToViewHistoryText();

        ExtentReportManager.logInfo("Step_03: Verify that the text 'Weekly Overall Score', 'Score Breakdown', 'Key Metrics' are visible.");
        Assert.assertEquals(summaryPageObject.getWeeklyOverallScoreText(), "Weekly Overall Score");
        Assert.assertEquals(summaryPageObject.getScoreBreakdownText(), "Score Breakdown");
        Assert.assertEquals(summaryPageObject.getKeyMetricsText(), "Key Metrics");

        ExtentReportManager.logInfo("Step_04: Tap 'i' icon.");
        summaryPageObject.tapToIIcon();

        ExtentReportManager.logInfo("Step_05: Verify that the pop-up is visible");
        Assert.assertTrue(summaryPageObject.isThePopUpDisplayed());

        ExtentReportManager.logInfo("Step_06: Tap 'i' icon.");
        summaryPageObject.tapToIIcon();

        ExtentReportManager.logInfo("Step_07: Verify the pop-up is closed.");
        Assert.assertFalse(summaryPageObject.isThePopUpDisplayed());

        ExtentReportManager.logInfo("Step_08: Tap 'Month' button.");
        summaryPageObject.tapToMonthButton();

        ExtentReportManager.logInfo("Step_09: Verify that the text 'Monthly Overall Score', 'Score Breakdown', 'Key Metrics' are visible.");
        Assert.assertEquals(summaryPageObject.getMonthlyOverallScoreText(), "Monthly Overall Score");
        Assert.assertEquals(summaryPageObject.getScoreBreakdownText(), "Score Breakdown");
        Assert.assertEquals(summaryPageObject.getKeyMetricsText(), "Key Metrics");

        ExtentReportManager.logInfo("Step_10: Tap 'i' icon.");
        summaryPageObject.tapToIIconMonth();

        ExtentReportManager.logInfo("Step_11: Verify that the pop-up is visible.");
        Assert.assertTrue(summaryPageObject.isThePopUpDisplayed());

        ExtentReportManager.logInfo("Step_12: Tap 'i' icon.");
        summaryPageObject.tapToIIconMonth();

        ExtentReportManager.logInfo("Step_13: Verify that the pop-up is closed.");
        Assert.assertFalse(summaryPageObject.isThePopUpDisplayed());

        ExtentReportManager.logInfo("Step_14: Scroll to the bottom of the page.");
        summaryPageObject.scrollFromBottomToTop(driver, 0.5);

        ExtentReportManager.logInfo("Step_15: Verify that the text 'Brand' is visible");
        Assert.assertEquals(summaryPageObject.getBrandText(), "Brand");

        ExtentReportManager.logInfo("Step_16: Tap 'Scorecard History'");
        summaryPageObject.tapToScorecardHistoryText();

        ExtentReportManager.logInfo("Step_17: Verify that the text 'Weekly Overall Score', 'Weekly Leaderboard', 'What Guests are telling us', 'Key Metrics' are visible.");
        Assert.assertEquals(summaryPageObject.getWeeklyOverallScoreText(), "Weekly Overall Score");
        Assert.assertEquals(summaryPageObject.getWeeklyLeaderboardText(), "Weekly Leaderboard");
        Assert.assertEquals(summaryPageObject.getWhatGuestsAreTellingUsText(), "What Guests are telling us");
        Assert.assertEquals(summaryPageObject.getKeyMetricsText(), "Key Metrics");

        ExtentReportManager.logInfo("Step_18: Tap 'View Full ScoreCard'");
        summaryPageObject.tapToViewFullScoreCardButton();

        ExtentReportManager.logInfo("Step_19: Verify that the text 'Growth', 'Best Jobs', 'Best Moments', 'Best Operations' are visible.");
        Assert.assertEquals(summaryPageObject.getGrowthText(), "Growth");
        Assert.assertEquals(summaryPageObject.getBestJobsText(), "Best Jobs");
        Assert.assertEquals(summaryPageObject.getBestMomentsText(), "Best Moments");
        Assert.assertEquals(summaryPageObject.getBestOperationsText(), "Best Operations");

        ExtentReportManager.logInfo("Step_20: Tap 'X' icon");
        summaryPageObject.tapToCloseIcon();

        ExtentReportManager.logInfo("Step_21: Verify the ScoreCard pop-up is closed.");
        Assert.assertFalse(summaryPageObject.isGrowthTextDisplayed());

        ExtentReportManager.logInfo("Step_22: Tap 'View Full LeaderBoard'");
        summaryPageObject.tapToViewFullLeaderBoardButton();

        ExtentReportManager.logInfo("Step_23: Verify that the text 'All Restaurants' is visible.");
        Assert.assertEquals(summaryPageObject.getAllRestaurantsText(), "ALL RESTAURANTS");

        ExtentReportManager.logInfo("Step_24: Tap 'X' icon.");
        summaryPageObject.tapToCloseIcon();

        ExtentReportManager.logInfo("Step_25: Verify the pop-up is closed.");
        Assert.assertFalse(summaryPageObject.isAllRestaurantTextDisplayed());


    }

    @Test(description = "Verify that the Chatbot function works properly on the Our Feed page")
    public void TC_03_The_Chatbot_Function_Works_Properly_On_The_Our_Feed_Page() {
        ExtentReportManager.logInfo("Step_01: Tap 'Our Feed' icon.");
        OurFeedPageObject ourFeedPage = new OurFeedPageObject(driver);
        ourFeedPage.tapToOurFeedIcon();

        ExtentReportManager.logInfo("Step_02: Tap 'Chat With MAC' button");
        ourFeedPage.tapToChatWithMactButton();

        ExtentReportManager.logInfo("Step_03: Verify that the text 'My AI Coach' is visible.");
        Assert.assertEquals(ourFeedPage.getMyAICoachText(), "My AI Coach");

//        ExtentReportManager.logInfo("Step_04: Tap 'Type a message' textbox");
//        ourFeedPage.tapToTypeAMessage();

        ExtentReportManager.logInfo("Step_05: Send a message.");
        ourFeedPage.sendKeysToChatBot("What is the big 6?");

        ExtentReportManager.logInfo("Step_06: Tap '->' icon");
        ourFeedPage.tapToSendButton();

        ExtentReportManager.logInfo("Step_07: Verify the server responses a message (Chat bot icon is visible in the response)");
        Assert.assertTrue(ourFeedPage.isChatBotIconDisplayed());

        ExtentReportManager.logInfo("Step_08: Tap 'Thumbs up' icon");
        ourFeedPage.tapToThumpUpIcon();

//        ExtentReportManager.logInfo("Step_09:  Verify that the 'Thumbs up' icon is bold.");
//        Assert.assertTrue(ourFeedPage.isThumpUpIconBold());

        ExtentReportManager.logInfo("Step_10: Send the second message.");
        ourFeedPage.sendKeysToChatBot("What is FSCC visit?");
        ourFeedPage.tapToSendButton();


        ExtentReportManager.logInfo("Step_11: Verify the server responses a message (Chat bot icon is visible in the response)");
        Assert.assertTrue(ourFeedPage.isChatBotIconDisplayed());

        ExtentReportManager.logInfo("Step_12: Tap 'Thumbs down' icon");
        ourFeedPage.tapToThumpDownIcon();

        ExtentReportManager.logInfo("Step_13: Verify that the pop-up is visible.");
        Assert.assertTrue(ourFeedPage.isSubmitButtonDisplayed());

        ExtentReportManager.logInfo("Step_14: Tap 'Cancel' button");
        ourFeedPage.tapToCancelButton();

        ExtentReportManager.logInfo("Step_15: Verify that the pop-up is closed");
        Assert.assertFalse(ourFeedPage.isSubmitButtonDisplayed());

        ExtentReportManager.logInfo("Step_16: Tap 'Thumbs down' icon");
        ourFeedPage.tapToThumpDownIcon();

        ExtentReportManager.logInfo("Step_17: Send a message");
        ourFeedPage.sendKeysToExplanationTextBox("Test");

        ExtentReportManager.logInfo("Step_18: Tap 'Submit'");
        ourFeedPage.tapToSubmitButton();

        ExtentReportManager.logInfo("Step_19: Verify that the pop-up is closed");
        Assert.assertFalse(ourFeedPage.isSubmitButtonDisplayed());

//        ExtentReportManager.logInfo("Step_20: Verify that the 'Thumbs down' icon is bold");
//        Assert.assertTrue(ourFeedPage.isThumpDownIconBold());

    }

    @Test(description = "Verify that the XM Report page is displayed correctly with Best Moments, Best Operations, and Emerging Themes sections")
    public void TC_04_The_XM_Report_Page_Is_Displayed_Correctly_With_These_Sections() {
        ExtentReportManager.logInfo("Step_01: Tap 'XM Report' icon.");
        XMReportPageObject xmReportPage = new XMReportPageObject(driver);
        xmReportPage.clickToXMReportIcon();

        ExtentReportManager.logInfo("Step_02: Verify the text 'Win Score', 'Smart OSAT', 'Aggregator', 'Best Moments', 'Best Operations', 'Where Our Guests Say to Focus', 'Emerging Theme' are visible.");
        Assert.assertEquals(xmReportPage.getWinScoreText(), "Win Score");
        Assert.assertEquals(xmReportPage.getSmartOSATText(), "Smart OSAT");
        Assert.assertEquals(xmReportPage.getAggregatorText(), "Aggregator");
        Assert.assertEquals(xmReportPage.getSocialText(), "Social");
        Assert.assertEquals(xmReportPage.getBestMomentsText(), "Best Moments");
        Assert.assertEquals(xmReportPage.getBestOperationsText(), "Best Operations");
        Assert.assertEquals(xmReportPage.getWhereOurGuestsSayToFocusText(), "Where Our Guests Say to Focus");
        Assert.assertEquals(xmReportPage.getEmergingThemeText(), "Emerging Theme");

        ExtentReportManager.logInfo("Step_03: Scroll to the bottom.");
        xmReportPage.scrollFromBottomToTop(driver,0.5);

        ExtentReportManager.logInfo("Step_04: Verify the text 'Recognition', 'Win Score Trend', 'Win Score B2B Trend' are visible.");
        Assert.assertEquals(xmReportPage.getRecognitionText(), "Recognition");
        Assert.assertEquals(xmReportPage.getWinScoreTrendText(), "Win Score Trend");
        Assert.assertEquals(xmReportPage.getWinScoreB2BTrendText(), "Win Score B2B Trend");

        ExtentReportManager.logInfo("Step_05: Scroll to the top.");
        xmReportPage.scrollFromTopToTheBottom(driver,0.5);

        ExtentReportManager.logInfo("Step_06: Tap 'i' icon");
        xmReportPage.tapToIIcon();

        ExtentReportManager.logInfo("Step_07: Verify that the pop-up is visible.");
        Assert.assertTrue(xmReportPage.isWinScoreTextDisplayed());

        ExtentReportManager.logInfo("Step_08: Tap 'i' icon");
        xmReportPage.tapToIIcon();

        ExtentReportManager.logInfo("Step_09:  Verify that the pop-up is closed");
        Assert.assertFalse(xmReportPage.isWinScoreTextDisplayed());

        ExtentReportManager.logInfo("Step_10: Tap 'Week' button");
        xmReportPage.tapToWeekButton();

        ExtentReportManager.logInfo("Step_11: Verify the text 'Win Score', 'Smart OSAT', 'Aggregator', 'Best Moments', 'Best Operations', 'Where Our Guests Say to Focus', 'Emerging Theme' are visible.");
        Assert.assertEquals(xmReportPage.getWinScoreText(), "Win Score");
        Assert.assertEquals(xmReportPage.getSmartOSATText(), "Smart OSAT");
        Assert.assertEquals(xmReportPage.getAggregatorText(), "Aggregator");
        Assert.assertEquals(xmReportPage.getSocialText(), "Social");
        Assert.assertEquals(xmReportPage.getBestMomentsText(), "Best Moments");
        Assert.assertEquals(xmReportPage.getBestOperationsText(), "Best Operations");
        Assert.assertEquals(xmReportPage.getWhereOurGuestsSayToFocusText(), "Where Our Guests Say to Focus");
        Assert.assertEquals(xmReportPage.getEmergingThemeText(), "Emerging Theme");

        ExtentReportManager.logInfo("Step_12: Scroll to the bottom.");
        xmReportPage.scrollFromBottomToTop(driver, 0.5);

        ExtentReportManager.logInfo("Step_13: Verify the text 'Recognition', 'Win Score Trend', 'Win Score B2B Trend' are visible.");
        Assert.assertEquals(xmReportPage.getRecognitionText(), "Recognition");
        Assert.assertEquals(xmReportPage.getWinScoreTrendText(), "Win Score Trend");
        Assert.assertEquals(xmReportPage.getWinScoreB2BTrendText(), "Win Score B2B Trend");

        ExtentReportManager.logInfo("Step_14: Scroll to the top.");
        xmReportPage.scrollFromTopToTheBottom(driver, 0.5);

        ExtentReportManager.logInfo("Step_15: Tap 'i' icon");
        xmReportPage.tapToIIcon();

        ExtentReportManager.logInfo("Step_16: Verify that the pop-up is visible.");
        Assert.assertTrue(xmReportPage.isWinScoreTextDisplayed());

        ExtentReportManager.logInfo("Step_17: Tap 'i' icon");
        xmReportPage.tapToIIcon();

        ExtentReportManager.logInfo("Step_18: Verify that the pop-up is closed");
        Assert.assertFalse(xmReportPage.isWinScoreTextDisplayed());

    }

    @Test(description = "Verify that the My Zone page is displayed correctly with the Last 3 Months and All Time sections")
    public void TC_05_The_MyZone_Page_Is_Displayed_Correctly_With_The_Last_3_Months_And_All_Time_Sections() {
        ExtentReportManager.logInfo("Step_01: Tap 'My Zone' icon.");
        MyZonePageObject myZonePage = new MyZonePageObject(driver);
        myZonePage.clickToMyZoneIcon();

        ExtentReportManager.logInfo("Step_02: Verify that the store name is visible.");
        Assert.assertEquals(myZonePage.getStoreNameText(), storeName);

        ExtentReportManager.logInfo("Step_03: Tap 'All Time'");
        myZonePage.tapToAllTimeText();

        ExtentReportManager.logInfo("Step_04: Verify that the store name is visible");
        Assert.assertEquals(myZonePage.getStoreNameText(), storeName);


    }

    @Test(description = "Verify that the user can log out of the Restaurant Hub successfully")
    public void TC_06_The_User_Can_Log_Out_Of_The_RestaurantHub_Successfully() {
        ExtentReportManager.logInfo("Step_01: Tap 'Log out' icon.");
        LogoutPageObject logoutPage = new LogoutPageObject(driver);
        logoutPage.clickToLogOutIcon();

        LoginPageObject loginPage = new LoginPageObject(driver);
        ExtentReportManager.logInfo("Step_02: Verify that the text 'Log in with Manager App' is visible");
        Assert.assertEquals(loginPage.getLogInWithManagerAppText(), "Log in with Manager App");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeSession(driver);
    }
}
