package by.htp.steps;

import org.openqa.selenium.WebDriver;

import by.htp.pages.MainPage;
import by.htp.webdriver.DriverSingleton;

public class SearchTicketSteps {
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
	
	public void searchTicketOneWay() {
		MainPage mainPage = new MainPage(driver);
		mainPage.searchTicketOneWay();
	}

	public void searchTicketRoundTrip() {
		MainPage mainPage = new MainPage(driver);
		mainPage.searchTicketRoundTrip();
	}
}
