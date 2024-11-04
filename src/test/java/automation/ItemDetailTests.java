package automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class ItemDetailTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Escribir el username");
        driver.findElement(AppiumBy.accessibilityId("test-Username"))
                .sendKeys("standard_user");

        Logs.info("Escribir el password");
        driver.findElement(AppiumBy.accessibilityId("test-Password"))
                .sendKeys("secret_sauce");

        Logs.info("Haciendo click en signin");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
     

        Logs.info("clicking images");
        driver.findElements(AppiumBy.androidUIAutomator("description(\"test-Item\")" +
                ".childSelector(className(\"android.widget.ImageView\"))")).get(0).click();

        Logs.info("Esperando a que cargue el detalle del producto");

    }

    @Test(groups = regression)
    public void verifyTest() {
        var listaDescription = driver.findElements(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]" +
                "/android.widget.TextView"));
        listaDescription.get(0);
    }

    @Test
    public void presionarAtras() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

}
