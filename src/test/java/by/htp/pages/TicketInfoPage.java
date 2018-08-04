package by.htp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import by.htp.utils.Log;

public class TicketInfoPage extends BasePage {
	private static final String BASE_ELEMENT1 = "//div[@id='outbound']";
	private static final String BASE_ELEMENT2 = "//div[@id='price']";
	private static final String DEPATURE_DATE_AND_TIME = "//div[@class='flight-info']//div[@class='departure']/strong";
	private String[] splited = null;
	private String dateAndTime = "", date = "", time = "";
	
	TicketInfoPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		Assert.assertTrue(isPresent(By.xpath(BASE_ELEMENT1)));
		Assert.assertTrue(isPresent(By.xpath(BASE_ELEMENT2)));
    	Log.getLogInfo("Ticket info page was appear");
	}
	
	public void ticketInfoCollection() {
		WebElement depatureDateAndTime = findOneElement(By.xpath(DEPATURE_DATE_AND_TIME));
		dateAndTime = depatureDateAndTime.getText();
		splited = dateAndTime.split("\\s+");
		date = splited[0];
		time = splited[1];
		Log.getLogInfo(String.format("Depature date = %s, depature time = %s", date, time));
	}

}
