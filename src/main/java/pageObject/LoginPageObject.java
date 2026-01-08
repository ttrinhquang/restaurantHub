package pageObject;


import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {

    private AppiumDriver driver;

    public LoginPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickToAllowPopup() {
        waitForElementVisible(driver, LoginPageUI.ALLOW_POPUP_BUTTON);
        clickToElement(driver, LoginPageUI.ALLOW_POPUP_BUTTON);
    }

    public void clickToConnectPopup() {
        waitForElementVisible(driver, LoginPageUI.CONNECT_POPUP_BUTTON);
        clickToElement(driver, LoginPageUI.CONNECT_POPUP_BUTTON);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        sleepInSecond(5);
    }

    public void clickToLoginWithPasswordButton() {
        try {
            waitForElementVisible(driver, LoginPageUI.LOGIN_WITH_PASSWORD_BUTTON);
            clickToElement(driver, LoginPageUI.LOGIN_WITH_PASSWORD_BUTTON);
        } catch (Exception e) {
            System.out.println("Login with Password button not found - skipping");
        }
    }

    public void tapToLoginWithPasswordButton() {
        try {
            waitForElementVisible(driver, LoginPageUI.LOGIN_WITH_PASSWORD_BUTTON);
            tapToElement(driver, LoginPageUI.LOGIN_WITH_PASSWORD_BUTTON);
        } catch (Exception e){
            System.out.printf("Login with Password button was not displayed - skipping");
        }
    }

    public void enterYumID(String yumID) {
        waitForElementVisible(driver, LoginPageUI.YUM_ID_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.YUM_ID_TEXTBOX, yumID);
    }

    public void enterPassword(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void tapToSignInButton(){
        waitForElementVisible(driver, LoginPageUI.SIGN_IN_BUTTON);
        tapToElement(driver, LoginPageUI.SIGN_IN_BUTTON);
    }
    public void clickToSignInButton() {
        waitForElementVisible(driver, LoginPageUI.SIGN_IN_BUTTON);
        clickToElement(driver, LoginPageUI.SIGN_IN_BUTTON);
        sleepInSecond(2);
    }

    public String getLogInWithManagerAppText() {
        waitForElementVisible(driver, LoginPageUI.LOG_IN_WITH_MANAGER_APP_TEXT);
        return getElementText(driver, LoginPageUI.LOG_IN_WITH_MANAGER_APP_TEXT);
    }
}
