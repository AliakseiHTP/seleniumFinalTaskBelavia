package by.htp.pages;

import by.htp.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TariffCalendarPage extends BasePage {
	private static final String BASE_ELEMENT = "//div[@id='calendar']";
	private static final String LIST_OF_TICKETS = "//input[@name='date']/../label";
	private static final String NEXT_BTN = "//button[@value='next']";
	private static final String TILL_DATE = "//div[@id='outbound_18-11-01']";
	private static final String CANCEL_BUTTON = "//button[@class='button btn btn-default ui-corner-all cancel']";
	private static final String NEXT_7_DAYS = "//a[@data-val='next']";
	boolean condition = true;
	int iCount = 0;

	public TariffCalendarPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		Assert.assertTrue(isPresent(By.xpath(BASE_ELEMENT)));
		Log.getLogInfo("Tariff calendar page was appear");
	}

	public void chooseTicketOneWayAndCheckItInfo() {
		TicketInfoPage ticketInfoPage = new TicketInfoPage(driver);
		List<WebElement> listOfTickets = findListOfElements(By.xpath(LIST_OF_TICKETS));
		for (int i = 0; i < listOfTickets.size(); i++) {
			WebElement chooseTicket = findOneElement(By.xpath(String.format("(%s)[%d]", LIST_OF_TICKETS, i + 1)));
			chooseTicket.click();
			WebElement nextBtn = findOneElement(By.xpath(NEXT_BTN));
			nextBtn.click();
			ticketInfoPage.ticketInfoCollectionOneWay();
			needSleep(1000);
		}
		WebElement cancelBtn = findOneElement(By.xpath(CANCEL_BUTTON));
		cancelBtn.click();
		needSleep(1000);
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseDepartureDateAndSearch();
		mainPage.searchBtnClick();
		needSleep(1000);
		iCount++;
	}
	
	public void chooseTicketRoundTripAndCheckItInfo() {
		TicketInfoPage ticketInfoPage = new TicketInfoPage(driver);
		List<WebElement> listOfTickets = findListOfElements(By.xpath(LIST_OF_TICKETS));
		for (int i = 0; i < listOfTickets.size(); i++) {
			WebElement chooseTicket = findOneElement(By.xpath(String.format("(%s)[%d]", LIST_OF_TICKETS, i + 1)));
			chooseTicket.click();
			WebElement nextBtn = findOneElement(By.xpath(NEXT_BTN));
			nextBtn.click();
			ticketInfoPage.ticketInfoCollectionRoundTrip();
			needSleep(1000);
		}
		WebElement cancelBtn = findOneElement(By.xpath(CANCEL_BUTTON));
		cancelBtn.click();
		needSleep(1000);
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseDepartureDateAndSearch();
		mainPage.searchBtnClick();
		needSleep(1000);
		iCount++;
	}

	public void seeAllAvailableOneWayTickets() {
		do {
			if (iCount == 0) {
				if (!isPresent(By.xpath(TILL_DATE))) {
					chooseTicketOneWayAndCheckItInfo();
					seeAllAvailableOneWayTickets();
				}
			} else if (iCount > 0) {
				for (int i = 0; i < iCount; i++) {
					WebElement next7Days = findOneElement(By.xpath(NEXT_7_DAYS));
					next7Days.click();
					needSleep(1000);
				}
				if (!isPresent(By.xpath(TILL_DATE))) {
					chooseTicketOneWayAndCheckItInfo();
					seeAllAvailableOneWayTickets();
				}
			}
		} while (iCount < 12);
	}
	
	public void seeAllAvailableRoundTripTickets() {
		do {
			if (iCount == 0) {
				if (!isPresent(By.xpath(TILL_DATE))) {
					chooseTicketRoundTripAndCheckItInfo();
					seeAllAvailableRoundTripTickets();
				}
			} else if (iCount > 0) {
				for (int i = 0; i < iCount; i++) {
					WebElement next7Days = findOneElement(By.xpath(NEXT_7_DAYS));
					next7Days.click();
					needSleep(1000);
				}
				if (!isPresent(By.xpath(TILL_DATE))) {
					chooseTicketRoundTripAndCheckItInfo();
					seeAllAvailableRoundTripTickets();
				}
			}
		} while (iCount < 12);
	}
}
