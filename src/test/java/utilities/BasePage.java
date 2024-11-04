package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private final static int defaultTimeout = 5;
    protected final SoftAssert softAssert;
    private int timeout;

    public BasePage(int timeout) {
        softAssert = new SoftAssert();
        this.timeout = timeout;
    }

    public BasePage() {
        this(defaultTimeout);
    }

    protected AndroidDriver getDriver() {
        return new DriverProvider().get();
    }

    protected WebElement waitForDisplayed(By locator, int timeout) {
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForDisplayed(By locator) {
        return waitForDisplayed(locator, defaultTimeout);
    }

    protected void waitPage(By locator, String pageName) {
        Logs.info("Esperando que la pagina %s cargue", pageName);
        waitForDisplayed(locator, timeout);
        Logs.info("%s cargo todo ok");
    }

    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    public void pressBack() {
        Logs.info("presionando atras en el dispositvo");
        getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
    }

    protected void sleep(int timeMS) {
        try {
            Thread.sleep(timeMS);
        } catch (InterruptedException interruptedException) {
            Logs.error("InterruptedException: %s", interruptedException);
        }
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();
}

