package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.OurFeedPageUI;

public class OurFeedPageObject extends BasePage {
    private AppiumDriver driver;

    public OurFeedPageObject(AppiumDriver driver){
        this.driver = driver;
    }

    public void clickToOurFeedIcon() {
        System.out.println("Attempting to click Our Feed icon...");
        try {
            waitForElementVisible(driver, OurFeedPageUI.OUR_FEED_ICON);
            clickToElement(driver, OurFeedPageUI.OUR_FEED_ICON);
        } catch (Exception e) {
            System.out.println("Failed to click Our Feed icon: " + e.getMessage());
            throw e;
        }
    }

    public String getAllFeedsText() {
        waitForElementVisible( driver, OurFeedPageUI.OUR_FEED_TEXT);
        return getElementText(driver, OurFeedPageUI.OUR_FEED_TEXT);
    }

    public void tapToOurFeedIcon() {
        waitForElementVisible(driver, OurFeedPageUI.OUR_FEED_ICON);
        tapToElement(driver, OurFeedPageUI.OUR_FEED_ICON);
        sleepInSecond(2);
    }

    public void tapToChatWithMactButton() {
        waitForElementVisible(driver, OurFeedPageUI.CHAT_WITH_MAC_BUTTON);
        tapToElement(driver, OurFeedPageUI.CHAT_WITH_MAC_BUTTON);
    }

    public String getMyAICoachText() {
        waitForElementVisible(driver, OurFeedPageUI.MY_AI_COACH_TEXT);
        return getElementText(driver, OurFeedPageUI.MY_AI_COACH_TEXT);
    }

    public void sendKeysToChatBot(String test) {
        waitForElementVisible(driver, OurFeedPageUI.TYPE_A_MESSAGE_TEXTBOX);
        sendKeysToElement(driver, OurFeedPageUI.TYPE_A_MESSAGE_TEXTBOX, test);
    }

    public void tapToSendButton() {
        waitForElementVisible(driver, OurFeedPageUI.SEND_BUTTON);
        tapToElement(driver, OurFeedPageUI.SEND_BUTTON);
    }

    public boolean isChatBotIconDisplayed() {
        waitForElementVisible(driver, OurFeedPageUI.CHATBOT_ICON);
        return isElementDisplayed(driver, OurFeedPageUI.CHATBOT_ICON);
    }

    public void tapToThumpUpIcon() {
        waitForElementVisible(driver, OurFeedPageUI.THUMP_UP_ICON);
        tapToElement(driver, OurFeedPageUI.THUMP_UP_ICON);
    }

//    public boolean isThumpUpIconBold() {
//        waitForElementVisible(driver, OurFeedPageUI.THUMP_UP_BOLD_ICON);
//        isElementDisplayed(driver, OurFeedPageUI.THUMP_UP_BOLD_ICON);
//    }

    public void tapToThumpDownIcon() {
        waitForElementVisible(driver, OurFeedPageUI.THUMP_DOWN_ICON);
        tapToElement(driver, OurFeedPageUI.THUMP_DOWN_ICON);
    }

    public boolean isSubmitButtonDisplayed() {
        waitForElementVisible(driver, OurFeedPageUI.SUBMIT_BUTTON);
        return isElementDisplayed(driver, OurFeedPageUI.SUBMIT_BUTTON);
    }

    public void tapToCancelButton() {
        waitForElementVisible(driver, OurFeedPageUI.CANCEL_BUTTON);
        tapToElement(driver, OurFeedPageUI.CANCEL_BUTTON);
    }

    public void sendKeysToExplanationTextBox(String test) {
        waitForElementVisible(driver, OurFeedPageUI.EXPLANATION_TEXTBOX);
        sendKeysToElement(driver, OurFeedPageUI.EXPLANATION_TEXTBOX, test);
    }

    public void tapToSubmitButton() {
        waitForElementVisible(driver, OurFeedPageUI.SUBMIT_BUTTON);
        tapToElement(driver, OurFeedPageUI.SUBMIT_BUTTON);
    }

//    public boolean isThumpDownIconBold() {
//        waitForElementVisible(driver, OurFeedPageUI.THUMP_DOWN_BOLD_ICON);
//        isElementDisplayed(driver, OurFeedPageUI.THUMP_DOWN_BOLD_ICON);
//    }
}
