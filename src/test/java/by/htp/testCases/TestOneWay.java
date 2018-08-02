package by.htp.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import by.htp.steps.OneWayTicketSteps;

public class TestOneWay {
	private OneWayTicketSteps step;
	
	@BeforeTest(description = "Init browser")
	public void setUp() {
		step = new OneWayTicketSteps();
		step.initBrowser();
	}
	
	@AfterTest(description = "Stop Browser")
	public void stopBrowser() {
		step.closeDriver();
	}
}
