package automation;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Gestures;
import utilities.Logs;

import java.time.Duration;

public class ShoppingTests extends BaseTest {

    @BeforeMethod
    public void setUP() {

        final var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-Username")));

        Logs.info("Escribir el username");
        driver.findElement(AppiumBy.accessibilityId("test-Username"))
                .sendKeys("standard_user");

        Logs.info("Escribir el password");
        driver.findElement(AppiumBy.accessibilityId("test-Password"))
                .sendKeys("secret_sauce");

        Logs.info("Haciendo click en signin");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
    }

    @Test
    public void verificandoPaginaTest() {
        Logs.info("Verificando la pagina de shopping");

        final var tituloProducts = driver.findElement(AppiumBy.androidUIAutomator("text(\"PRODUCTS\")"));
        final var btnFiltro = driver.findElement(AppiumBy.accessibilityId("test-Modal Selector Button"));

        final var view = driver.findElement(AppiumBy.accessibilityId("test-Toggle"));
        final var listaItems = driver.findElement(AppiumBy.accessibilityId("test-PRODUCTS"));

        softAssert.assertTrue(tituloProducts.isDisplayed());
        softAssert.assertTrue(btnFiltro.isDisplayed());
        softAssert.assertTrue(btnFiltro.isEnabled());
        softAssert.assertTrue(listaItems.isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void filtroPrecioTest() {
        Logs.info("Clicking filter button");
        driver.findElement(AppiumBy.accessibilityId("test-Modal Selector Button")).click();

        Logs.info("Esperando aparezcan los filtros");

        Logs.info("Click low to high");
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Price (low to high)\")")).click();

        Logs.info("Waiting to sort");
        sleep(1000);

        Logs.info("Verificando la información importante");
        final var listaTitulos = driver.findElements(AppiumBy.accessibilityId("test-Item title"));

        final var listPrecios = driver.findElements(AppiumBy.accessibilityId("test-Price"));

        final var firstTitle = listaTitulos.get(0).getText();
        final var primerPrecio = Double.parseDouble(
                listPrecios.get(0).getText().replace("$", ""));

        softAssert.assertEquals(firstTitle, "Sauce Labs Onesie");
        softAssert.assertEquals(primerPrecio, 7.99);
        softAssert.assertAll();
    }

    @Test
    public void dragDropItemCarts() {
        Logs.info("Haciendo tap formato lista");
        Gestures.tap(driver.findElement(AppiumBy.accessibilityId("test-Toggle")));

        sleep(1500);

        final var listaBotonesArrastre = driver.findElements(AppiumBy
                .accessibilityId("test-Drag Handle"));


        final var elementoOrigen = listaBotonesArrastre.get(2);

        final var elementoDestiny = driver.findElement(AppiumBy.accessibilityId("test-Cart drop zone"));

        Logs.info("Arrastramos los elementos");
        Gestures.dragTo(elementoOrigen, elementoDestiny);

        Logs.info("Verificamos que hay en el carrito");
        final var labelText = driver.findElement(
                AppiumBy.androidUIAutomator("description(\"test-Cart\")" +
                        ".childSelector(className(\"android.widget.TextView\"))"));

        Assert.assertEquals(Integer.parseInt(labelText.getText()), 1);
    }
}
