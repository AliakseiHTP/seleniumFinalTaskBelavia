package by.htp.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.pages.Elements.ElementsEnum;
import by.htp.steps.SearchTicketSteps;

public class TestOneWay {
	private SearchTicketSteps step;

	@BeforeTest(description = "Init browser")
	public void setUp() {
		step = new SearchTicketSteps();
		step.initBrowser();
	}

	@Test(priority = 1)
	public void openMainPage() {
		step.openMainPage();
	}

	@Test(priority = 2)
	public void searchKindOfTicket() {
		step.searchTicketOneWay(ElementsEnum.ORIGIN_LOCATION, ElementsEnum.CITY_FROM, ElementsEnum.DESTINATION_LOCATION,
				ElementsEnum.CITY_TO, ElementsEnum.ONE_WAY);
	}

	@Test(priority = 3)
	public void chooseTicket() {
		step.chooseTicket();
	}

	@AfterTest(description = "Stop Browser")
	public void stopBrowser() {
		//step.closeDriver();
	}
}