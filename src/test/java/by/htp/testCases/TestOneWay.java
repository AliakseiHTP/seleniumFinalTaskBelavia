package by.htp.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.steps.OneWayTicketSteps;

public class TestOneWay {
	private OneWayTicketSteps step;
	
	@BeforeTest(description = "Init browser")
	public void setUp() {
		step = new OneWayTicketSteps();
		step.initBrowser();
	}
	
	@Test(description = "Open main page", priority = 1)
	public void openMainPage() throws InterruptedException {
		step.openMainPage();
		step.searchOneWayTicket();
	}
	
	@AfterTest(description = "Stop Browser")
	public void stopBrowser() {
		//step.closeDriver();
	}
}
