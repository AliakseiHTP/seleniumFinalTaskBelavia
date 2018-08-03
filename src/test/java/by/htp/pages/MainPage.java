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
	private static final String MAIN_LOGO = "//div[@class='logo']//img";
	private static final String ORIGIN = getProperty("city.from");
	private static final String DESTINATION = getProperty("city.to");
	private static final String DEPATURE_DATE = "//table//td[contains(@class,'today')]/.";
	private static final String NEXT_MONTH = "//a[contains(@class,'next')]";
	private static final String ARRIVAL_MONTH = "//span[@class='ui-datepicker-month'][contains(text(),'Сентябрь')]";
	private static final String ARRIVAL_DATE = "/../../..//a[@class='ui-state-default'][contains(text(),'11')]";
	
	public MainPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		Assert.assertTrue(isPresent(By.xpath(MAIN_LOGO)));
		Log.getLogInfo("Main page was appear");
	}
	
	private void chooseArrivalDate() {
		WebElement nextMonth = driver.findElement(By.xpath(NEXT_MONTH));
		if(!isPresent(By.xpath(ARRIVAL_MONTH))){
			nextMonth.click();
			chooseArrivalDate();
		} else {
			WebElement arrivalDate = driver.findElement(By.xpath(String.format("%s%s", ARRIVAL_MONTH, ARRIVAL_DATE)));
			moveMouseOn(arrivalDate);
			arrivalDate.click();
		}
	}
	
	public void searchTicket() throws InterruptedException {
		typeTextInTbx(ElementsEnum.ORIGIN_LOCATION, ORIGIN);
		clickOnDropdownElement(ElementsEnum.CITY_FROM);
		Log.getLogInfo(String.format("Departure city selected - %s", ORIGIN));
		typeTextInTbx(Elements.ElementsEnum.DESTINATION_LOCATION, DESTINATION);
		clickOnDropdownElement(ElementsEnum.CITY_TO);
		Log.getLogInfo(String.format("City of arrival selected - %s", DESTINATION));
		WebElement departureDateBtn = driver.findElement(By.xpath(DEPATURE_DATE));
		moveMouseOn(departureDateBtn);
		System.out.println("1");
		needSleep(2000);
		departureDateBtn.click();
		System.out.println("2");
		chooseArrivalDate();
		Log.getLogInfo("Holiday date selected");
	}

}
