package automation;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Gestures;
import utilities.Logs;

public class DrawingTests extends BaseTest {
    private WebElement canvasElement;

    @BeforeMethod
    public void setUp() {
        final var deepLink = "swaglabs://drawing";

        Logs.info("Navengando al web");
        driver.get(deepLink);

        canvasElement = driver.findElement(AppiumBy.androidUIAutomator("text(\"Signature Pad demo\")" +
                ".childSelector(className(\"android.widget.Image\"))"));
    }

    @Test
    public void drawTest() {
        Logs.info("Line Vertical");
        Gestures.swipeVertical(50, 20, 80, canvasElement);

        Logs.info("Esperando ");
        sleep(5000);
    }

    @Test
    public void drawHorizontaTest() {
        Logs.info("lineVertical");
        Gestures.swipeHorizontal(50, 10, 90, canvasElement);
        sleep(5000);
    }

    @Test
    public void dibujoBackSlash() {
        Logs.info("dibujando simbolo slash");
        Gestures.swipeGeneral(20, 20, 80, 80, canvasElement);

        sleep(5000);
    }
}
