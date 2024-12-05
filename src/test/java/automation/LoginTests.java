package automation;

import utilities.BaseTest;

public class LoginTests extends BaseTest {

//    @BeforeMethod(alwaysRun = true)
//    public void setUp() {
//        final var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-Username")));
//    }
//
//    @Test
//    public void loginTest() {
//        Logs.info("Escribir el username");
//        driver.findElement(AppiumBy.accessibilityId("test-Username"))
//                .sendKeys("locked_out_user");
//
//        Logs.info("Escribir el password");
//        driver.findElement(AppiumBy.accessibilityId("test-Password"))
//                .sendKeys("secret_sauce");
//
//        Logs.info("Haciendo click en signin");
//        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
//
//        final var wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        final var msjError = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("description(\"test-Error message\")" +
//                ".childSelector(className(\"android.widget.TextView\"))")));
//
//
//        softAssert.assertTrue(msjError.isDisplayed());
//        softAssert.assertEquals(msjError.getText(), "Sorry, this user has been locked out.");
//        softAssert.assertAll();
//    }
//
//    @Test(groups = {regression, smoke})
//    public void tapStandartTest() {
//        Logs.info("click en standart user");
//        Gestures.tap(driver.findElement(AppiumBy.accessibilityId("test-standard_user")));
//
//        Logs.info("haciendo tap en el login");
//        Gestures.tap(driver.findElement(AppiumBy.accessibilityId("test-LOGIN")));
//
//        final var wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        final var title = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                AppiumBy.accessibilityId("test-PRODUCTS")));
//        Logs.info("display products");
//        Assert.assertTrue(title.isDisplayed());
//    }
}
