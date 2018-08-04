package by.htp.testCases;

import by.htp.pages.Elements.ElementsEnum;
import by.htp.steps.SearchTicketSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRoundTrip {
	private SearchTicketSteps step;

	@BeforeTest(description = "Init browser")
	public void setUp() {
		step = new SearchTicketSteps();
		step.initBrowser();
	}

	@Test(description = "Open main page", priority = 1)
	public void openMainPage() {
		step.openMainPage();
	}

	@Test(description = "Search kind of ticket", priority = 2)
	public void searchKindOfTicket() {
		step.searchTicketRoundTrip(ElementsEnum.ORIGIN_LOCATION, ElementsEnum.CITY_FROM,
				ElementsEnum.DESTINATION_LOCATION, ElementsEnum.CITY_TO, ElementsEnum.ROUND_TRIP);
	}

	@AfterTest(description = "Stop Browser")
	public void stopBrowser() {
		// step.closeDriver();
	}
}