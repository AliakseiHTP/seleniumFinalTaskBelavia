package by.htp.steps;

import by.htp.pages.TariffCalendarPage;
import by.htp.pages.TicketInfoPage;
import by.htp.pages.Elements.ElementsEnum;

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
	
	public void searchTicketOneWay(ElementsEnum selOriginLocation,
    		ElementsEnum selCityFrom, ElementsEnum selDestinationLocation, ElementsEnum selCityTo,
    		ElementsEnum selWay) {
		MainPage mainPage = new MainPage(driver);
		mainPage.searchTicketOneWay(selOriginLocation, selCityFrom, selDestinationLocation, selCityTo,
				selWay);
	}

	public void searchTicketRoundTrip(ElementsEnum selOriginLocation,
    		ElementsEnum selCityFrom, ElementsEnum selDestinationLocation, ElementsEnum selCityTo,
    		ElementsEnum selWay) {
		MainPage mainPage = new MainPage(driver);
		mainPage.searchTicketRoundTrip(selOriginLocation, selCityFrom, selDestinationLocation, selCityTo,
				selWay);
	}

    public void chooseTicket() {
        TariffCalendarPage tariffCalendarPage = new TariffCalendarPage(driver);
        tariffCalendarPage.openPage();
        tariffCalendarPage.chooseTicketAndCheckItInfo();
    }
    
    public void ticketInfoCollection() {
    	TicketInfoPage ticketInfoPage = new TicketInfoPage(driver);
    	ticketInfoPage.openPage();
    	ticketInfoPage.ticketInfoCollection();
    }
}
