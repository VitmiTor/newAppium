package automation;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class BurgerTest extends BaseTest {

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
        //sleep(1500);

        Logs.info("Abriendo el burger Menu");
        driver.findElement(AppiumBy.accessibilityId("test-Menu")).click();
//        sleep(2000);
    }

    @Test(groups = regression)
    public void logoutTest() {
        Logs.info("Clickeando el boton Logout");
        driver.findElement(AppiumBy.accessibilityId("test-LOGOUT")).click();


//        sleep(2000);

        Logs.info("Verificando pantalla inicial");
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("test-Password")).isDisplayed());
    }


}
