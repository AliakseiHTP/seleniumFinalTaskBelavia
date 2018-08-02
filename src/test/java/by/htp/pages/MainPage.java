package by.htp.pages;

import static by.htp.utils.PropertyManager.getProperty;

import org.openqa.selenium.WebDriver;

import by.htp.utils.Log;

public class MainPage extends BasePage{
	private static final String BASE_URL = getProperty("main.page.url");
	
	MainPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		Log.getLogInfo("Main page was appear");
	}

}
