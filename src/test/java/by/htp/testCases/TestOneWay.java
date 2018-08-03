package by.htp.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.steps.SearchTicketSteps;

public class TestOneWay {
	private SearchTicketSteps step;
	
	@BeforeTest(description = "Init browser")
	public void setUp() {
		step = new SearchTicketSteps();
		step.initBrowser();
	}
	
	@Test(description = "Open main page", priority = 1)
	public void openMainPage() {
		step.openMainPage();
		step.searchTicketOneWay();
	}
	
	@AfterTest(description = "Stop Browser")
	public void stopBrowser() {
		//step.closeDriver();
	}
}
