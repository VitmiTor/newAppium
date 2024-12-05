package saucedemo;

import automation.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class LoginTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() {
        loginPage.waitPageToLoad();
    }

    @Test
    public void loginTest() {
        loginPage.sendCredential("locked_out_user", "secret_sauce");
        Logs.info("Verificando error");
        loginPage.verifyErrorMsj("Sorry, this user has been locked out.");
    }

    @Test
    public void loginVerify() {
        loginPage.verifyPage();
    }
}
