package commons;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class BasePage {

    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    // private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

    private By getByLocator(String locatorType) {

        if (locatorType.startsWith("id=")) {
            return AppiumBy.id(locatorType.substring(3));
        } else if (locatorType.startsWith("xpath=")) {
            return AppiumBy.xpath(locatorType.substring(6));
        } else if (locatorType.startsWith("uiAutomator=")) {
            return AppiumBy.androidUIAutomator(locatorType.substring(12));
        } else if (locatorType.startsWith("accessibilityId=")) {
            return AppiumBy.accessibilityId(locatorType.substring(15));
        }
        return null;
    }

    private String getDynamicLocator(String locatorType, String... dynamicValues) {
        if (dynamicValues.length > 0) {
            return String.format(locatorType, (Object[]) dynamicValues);
        }
        return locatorType;
    }


    public WebElement getElement(AppiumDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    public WebElement getElement(AppiumDriver driver, String locatorType, String... dynamicValues) {
        return driver.findElement(getByLocator(getDynamicLocator(locatorType, dynamicValues)));
    }

    public List<WebElement> getListElements(AppiumDriver driver, String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }

    public void waitForElementVisible(AppiumDriver driver, String locatorType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }

    public void waitForElementVisible(AppiumDriver driver, String locatorType, String... dynamicValues) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locatorType, dynamicValues))));
    }

    public void clickToElement(AppiumDriver driver, String locatorType) {
        getElement(driver, locatorType).click();
    }

    public void clickToElement(AppiumDriver driver, String locatorType, String... dynamicValues) {
        getElement(driver, getDynamicLocator(locatorType, dynamicValues)).click();
    }

    public void tapToElement(AppiumDriver driver, String locatorType) {
        WebElement element = getElement(driver, locatorType);
        Point location = element.getLocation();
        int x = location.getX() + element.getSize().getWidth() / 2;
        int y = location.getY() + element.getSize().getHeight() / 2;
        tapByCoordinates(driver, x, y);

    }

    private void tapByCoordinates(AppiumDriver driver, int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(200)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

    public void sendKeysToElement(AppiumDriver driver, String locatorType, String value) {
        getElement(driver, locatorType).clear();
        getElement(driver, locatorType).sendKeys(value);
    }

    public String getElementText(AppiumDriver driver, String locatorType) {
        return getElement(driver, locatorType).getText();
    }

    public boolean isElementDisplayed(AppiumDriver driver, String locatorType) {
        return getElement(driver, locatorType).isDisplayed();
    }

    public void sleepInSecond(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void scrollFromBottomToTop(AppiumDriver driver,double scrollPercent) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.8);
        int endY = (int) (size.getHeight() * (0.8 - scrollPercent));
        swipeByCoordinates(driver, startX, startY, startX, endY, 300);
    }

    public void scrollFromTopToTheBottom(AppiumDriver driver, double scrollPercent) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth()/2;
        int startY= (int) (size.getHeight() * 0.2);
        int endY = (int) (size.getHeight() * (0.2 + scrollPercent));
        swipeByCoordinates(driver, startX, startY, startX, endY, 300);
    }

    public void swipeByCoordinates(AppiumDriver driver, int startX, int startY, int endX, int endY, int durationMs) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMs), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }






}