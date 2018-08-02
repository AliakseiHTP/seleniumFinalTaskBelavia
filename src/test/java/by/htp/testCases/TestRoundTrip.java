package by.htp.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import by.htp.steps.RoundTripTicketSteps;

public class TestRoundTrip {
	private RoundTripTicketSteps step;
	
	@BeforeTest(description = "Init browser")
	public void setUp() {
		step = new RoundTripTicketSteps();
		step.initBrowser();
	}
	
	@AfterTest(description = "Stop Browser")
	public void stopBrowser() {
		step.closeDriver();
	}
}
