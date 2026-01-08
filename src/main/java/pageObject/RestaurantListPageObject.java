package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import pageUIs.RestaurantListPageUI;

public class RestaurantListPageObject extends BasePage {
    private AppiumDriver driver;

    public RestaurantListPageObject(AppiumDriver driver){
        this.driver = driver;
    }

    public void clickToRestaurant(String restaurantName){
        waitForElementVisible(driver, String.format(RestaurantListPageUI.RESTAURANT_NAME, restaurantName));
        clickToElement(driver, String.format(RestaurantListPageUI.RESTAURANT_NAME, restaurantName));
    }

    public void clickToYesButton(){
        waitForElementVisible(driver, RestaurantListPageUI.YES_BUTTON);
        clickToElement(driver, RestaurantListPageUI.YES_BUTTON);
        sleepInSecond(2);
    }

}
