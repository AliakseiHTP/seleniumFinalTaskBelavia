package by.htp.pages;

import static by.htp.utils.PropertyManager.getProperty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import by.htp.pages.Elements.ElementsEnum;
import by.htp.utils.Log;

public class MainPage extends BasePage{
	private static final String BASE_URL = getProperty("main.page.url");
	private static final String BASE_ELEMENT = "//div[@class='logo']//img";
	private static final String ORIGIN = getProperty("city.from");
	private static final String DESTINATION = getProperty("city.to");
    private static final String DEPARTURE_INPUT = "//input[@id='DepartureDate_Datepicker']/../a";
	private static final String DEPARTURE_DATE = "//table//td[contains(@class,'today')]/.";
	private static final String NEXT_MONTH = "//a[contains(@class,'next')]";
	private static final String ARRIVAL_MONTH = "//span[@class='ui-datepicker-month'][contains(text(),'Ноябрь')]";
	private static final String ARRIVAL_DATE = "/../../..//a[@class='ui-state-default'][contains(text(),'11')]";
	private static final String SUBMIT_BTN = "//div[@id='step-2']//button";

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
		if(!isPresent(By.xpath(ARRIVAL_MONTH))){
			nextMonth.click();
			chooseArrivalDate();
		} else {
			WebElement arrivalDate = findOneElement(By.xpath(String.format("%s%s", ARRIVAL_MONTH, ARRIVAL_DATE)));
			arrivalDate.click();
		}
	}

	private void routeSelection(ElementsEnum selOriginLocation,
    		ElementsEnum selCityFrom, ElementsEnum selDestinationLocation, ElementsEnum selCityTo,
    		ElementsEnum selWay) {
		typeTextInTbx(selOriginLocation, ORIGIN);
        clickOnDropdownElement(selCityFrom);
        Log.getLogInfo(String.format("Departure city selected - %s", ORIGIN));
        typeTextInTbx(selDestinationLocation, DESTINATION);
        clickOnDropdownElement(selCityTo);
        Log.getLogInfo(String.format("City of arrival selected - %s", DESTINATION));
        chooseKindOfTicket(selWay);
        Log.getLogInfo("One way selected");
	}
	
    public void searchTicketOneWay(ElementsEnum selOriginLocation,
    		ElementsEnum selCityFrom, ElementsEnum selDestinationLocation, ElementsEnum selCityTo,
    		ElementsEnum selWay) {
    	routeSelection(selOriginLocation, selCityFrom, selDestinationLocation, selCityTo, selWay);
        WebElement departureDateInput = findOneElement(By.xpath(DEPARTURE_INPUT));
        departureDateInput.click();
        WebElement departureDateBtn = findOneElement(By.xpath(DEPARTURE_DATE));
        departureDateBtn.click();
        Log.getLogInfo("Holiday date selected");
        WebElement findBtn = findOneElement(By.xpath(SUBMIT_BTN));
        findBtn.click();
        Log.getLogInfo("Searching for results");
    }

	public void searchTicketRoundTrip(ElementsEnum selOriginLocation,
    		ElementsEnum selCityFrom, ElementsEnum selDestinationLocation, ElementsEnum selCityTo,
    		ElementsEnum selWay) {
		routeSelection(selOriginLocation, selCityFrom, selDestinationLocation, selCityTo, selWay);
        WebElement departureDateInput = findOneElement(By.xpath(DEPARTURE_INPUT));
        departureDateInput.click();
        WebElement departureDateBtn = findOneElement(By.xpath(DEPARTURE_DATE));
        departureDateBtn.click();
		chooseArrivalDate();
		Log.getLogInfo("Holiday date selected");
        WebElement findBtn = findOneElement(By.xpath(SUBMIT_BTN));
        findBtn.click();
        Log.getLogInfo("Searching for results");
	}

}
