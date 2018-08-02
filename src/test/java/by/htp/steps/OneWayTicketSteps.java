package by.htp.steps;

import org.openqa.selenium.WebDriver;

import by.htp.pages.MainPage;
import by.htp.webdriver.DriverSingleton;

public class OneWayTicketSteps {
	private WebDriver driver;
	
	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}
	
	public void openMainPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
	}
}
