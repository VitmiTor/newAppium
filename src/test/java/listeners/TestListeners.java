package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.FileManager;
import utilities.Logs;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Logs.info("Comenzamos el Test: %s", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("Test exitoso: %s", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.info("Test Fallido: %s", result.getName());
        FileManager.getScreenshot(result.getName());
        FileManager.getPageSource(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("Test Skipped: %s", result.getName());
    }
}
