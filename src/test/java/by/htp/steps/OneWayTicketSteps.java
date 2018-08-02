package by.htp.steps;

import org.openqa.selenium.WebDriver;

import by.htp.webdriver.DriverSingleton;

public class OneWayTicketSteps {
	private WebDriver driver;
	
	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}
}
