package automation;

import utilities.BaseTest;

public class DeepLinksTest extends BaseTest {

//
//    public void deepLinks() {
//        final var deepLinks = "swaglabs://complete";
//
//        driver.get(deepLinks);
//
//        sleep(1500);
//
//    }
//
//
//    public void changeContext() {
//        final var deepLinks = "swaglabs://webview";
//
//        driver.get(deepLinks);
//
//        sleep(1500);
//
//        Logs.info("Escribir la url del input");
//        driver.findElement(AppiumBy.accessibilityId("test-enter a https url here..."))
//                .sendKeys("www.saucedemo.com");
//
//        driver.findElement(AppiumBy.accessibilityId("test-GO TO SITE")).click();
//
//        sleep(2000);
//
//        Logs.debug("change context");
//        ContextUtilities.switchWebContext();
//
//        Logs.info("Verificando el username");
//        Assert.assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
//
//        Logs.info("change context native app");
//        ContextUtilities.switchNativeContext();
//
//        Logs.info("Pressing back button");
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//
//        sleep(1500);
//
//        Logs.info("Got to site view");
//        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("test-GO TO SITE")).isDisplayed());
//    }
}
