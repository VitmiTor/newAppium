package automation;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {
    private final By usernameInput = AppiumBy.accessibilityId("test-Username");
    private final By passwordInput = AppiumBy.accessibilityId("test-Password");
    private final By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    private final By msjError = AppiumBy.androidUIAutomator("description(\"test-Error message\")" +
            ".childSelector(className(\"android.widget.TextView\"))");

    @Override
    @Step("Esperando que cargue la pagina")
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la pagina")
    public void verifyPage() {
        Logs.info("verifying page");
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Rellendo")
    public void sendCredential(String username, String password) {
        find(usernameInput).sendKeys(username);
        Logs.info("Sending password");
        find(passwordInput).sendKeys(password);

        find(loginButton).click();
    }

    @Step("verify mistake")
    public void verifyErrorMsj(String message) {
        final var errorMessage = waitForDisplayed(msjError, 3);

        Logs.info("Verificando msj error");
        Logs.info("Holaa" + errorMessage.getText());
        softAssert.assertTrue(errorMessage.isDisplayed());
        softAssert.assertEquals(errorMessage.getText(), message);
        softAssert.assertAll();
    }
}
