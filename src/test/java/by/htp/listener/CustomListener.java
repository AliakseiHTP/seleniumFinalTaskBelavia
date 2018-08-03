package by.htp.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import by.htp.utils.Log;
import by.htp.webdriver.DriverSingleton;

public class CustomListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Log.getLogInfo("-----------===TEST START===-----------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.getLogInfo("----------===TEST SUCCESS===----------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("<img src= \"" + takeScreenshot() +"\">");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

	private static String getDate() {
		return new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(Calendar.getInstance().getTime());
    }
	
	private String takeScreenshot() {
		String filePath = String.format("test-output/screenshots/screenshot %s.png", getDate());
		String filePathToReports = String.format("screenshots/screenshot %s.png", getDate());
		File screenShot = ((TakesScreenshot)DriverSingleton
				.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(filePath));
            Log.getLogInfo(String.format("See screenshot here '%s'",filePath));
        } catch (IOException e) {
        	Log.getLogWarn("Failed to save screenshot: " + e.getLocalizedMessage());
        }
        return filePathToReports;
    }
}
