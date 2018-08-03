package by.htp.testCases;

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

    @Test(description = "Fill info", priority = 2)
    public void fillInfo() {
        step.searchTicketRoundTrip();
    }

	@AfterTest(description = "Stop Browser")
	public void stopBrowser() {
		//step.closeDriver();
	}
}