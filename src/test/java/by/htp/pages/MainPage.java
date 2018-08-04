package by.htp.pages;

import static by.htp.utils.PropertyManager.getProperty;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import by.htp.pages.Elements.ElementsEnum;
import by.htp.utils.Log;

public class MainPage extends BasePage {
	private static final String BASE_URL = getProperty("main.page.url");
	private static final String BASE_ELEMENT = "//div[@class='logo']//img";
	private static final String ORIGIN = getProperty("city.from");
	private static final String DESTINATION = getProperty("city.to");
	private static final String DEPARTURE_INPUT = "//input[@id='DepartureDate_Datepicker']/../a";
	private static final String DEPARTURE_DATE = "//table//td[contains(@class,'today')]/.";
	private static final String DEPARTURE_MONTH = "//div[@class='ui-datepicker-group ui-datepicker-group-first']//span[@class='ui-datepicker-month']";
	private static final String NEXT_MONTH = "//a[contains(@class,'next')]";
	private static final String PREV_MONTH = "//a[contains(@class,'prev')]";
	private static final String ARRIVAL_MONTH = "//span[@class='ui-datepicker-month'][contains(text(),'Ноябрь')]";
	private static final String ARRIVAL_DATE = "/../../..//a[@class='ui-state-default'][contains(text(),'1')]";
	private static final String SUBMIT_BTN = "//button[@class='button btn-large btn btn-b2-green ui-corner-all']";

	public MainPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		Assert.assertTrue(isPresent(By.xpath(BASE_ELEMENT)));
		Log.getLogInfo("Main page was appear");
	}

	private void chooseArrivalDate() {
		WebElement nextMonth = findOneElement(By.xpath(NEXT_MONTH));
		if (!isPresent(By.xpath(ARRIVAL_MONTH))) {
			nextMonth.click();
			chooseArrivalDate();
		} else {
			WebElement arrivalDate = findOneElement(By.xpath(String.format("%s%s", ARRIVAL_MONTH, ARRIVAL_DATE)));
			arrivalDate.click();
		}
	}

	private void routeSelection(ElementsEnum selOriginLocation, ElementsEnum selCityFrom,
			ElementsEnum selDestinationLocation, ElementsEnum selCityTo, ElementsEnum selWay) {
		typeTextInTbx(selOriginLocation, ORIGIN);
		clickOnDropdownElement(selCityFrom);
		Log.getLogInfo(String.format("Departure city selected - %s", ORIGIN));
		typeTextInTbx(selDestinationLocation, DESTINATION);
		clickOnDropdownElement(selCityTo);
		Log.getLogInfo(String.format("City of arrival selected - %s", DESTINATION));
		chooseKindOfTicket(selWay);
		Log.getLogInfo("One way selected");
	}

	public void checkRightMonthAndClick() {
		System.out.println("1");
		WebElement prevMonth = findOneElement(By.xpath(PREV_MONTH));
		System.out.println("2");
		if(!isPresent(By.xpath(DEPARTURE_DATE))) {
			System.out.println("3");
			prevMonth.click();
			System.out.println("4");
			checkRightMonthAndClick();
			System.out.println("5");
		} else {
		System.out.println("6");
		WebElement departureDateBtn = findOneElement(By.xpath(DEPARTURE_DATE));
		System.out.println("7");
		departureDateBtn.click();
		System.out.println("8");
		}
	}

	public void chooseDepartureDateAndSearch() {
		WebElement departureDateInput = findOneElement(By.xpath(DEPARTURE_INPUT));
		departureDateInput.click();
		checkRightMonthAndClick();
		System.out.println("9");
	}

	public void searchBtnClick() {
		WebElement searchBtn = findOneElement(By.xpath(SUBMIT_BTN));
		searchBtn.click();
	}

	public void searchTicketOneWay(ElementsEnum selOriginLocation, ElementsEnum selCityFrom,
			ElementsEnum selDestinationLocation, ElementsEnum selCityTo, ElementsEnum selWay) {
		routeSelection(selOriginLocation, selCityFrom, selDestinationLocation, selCityTo, selWay);
		chooseDepartureDateAndSearch();
		System.out.println("1");
		Log.getLogInfo("Holiday date selected");
		searchBtnClick();
		Log.getLogInfo("Searching for results");
	}

	public void searchTicketRoundTrip(ElementsEnum selOriginLocation, ElementsEnum selCityFrom,
			ElementsEnum selDestinationLocation, ElementsEnum selCityTo, ElementsEnum selWay) {
		routeSelection(selOriginLocation, selCityFrom, selDestinationLocation, selCityTo, selWay);
		chooseDepartureDateAndSearch();
		chooseArrivalDate();
		Log.getLogInfo("Holiday date selected");
		searchBtnClick();
		Log.getLogInfo("Searching for results");
	}

}
