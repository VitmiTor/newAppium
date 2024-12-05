package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {
    protected SoftAssert softAssert;
    protected final String regression = "regression";
    protected final String smoke = "smoke";
    private final DriverManager driverManager = new DriverManager();

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        driverManager.buildDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {
        driverManager.killDriver();
    }

    protected void sleep(int timeMS) {
        try {
            Thread.sleep(timeMS);
        } catch (InterruptedException interruptedException) {
            Logs.error("Interrupted Exception: %s", interruptedException.getLocalizedMessage());
        }
    }

}
