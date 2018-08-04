package by.htp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import by.htp.utils.Log;

public class TicketInfoPage extends BasePage {
	private static final String BASE_ELEMENT1 = "//div[@id='outbound']";
	private static final String BASE_ELEMENT2 = "//div[@id='price']"; 
	private static final String DEPATURE_DATE = "//div[@id='outbound']//h3";
	private static final String DEPATURE_TIME = "//div[@class='flight-avail']/div[@class='departure']/strong";
	private static final String LIST_OF_CLASSES = "//input[@name='Outbound']/../label";
	private static final String TOTAL_AMOUNT = "//div[@class='total-tx-amount']";
	private static final String CLASS_ABBREVIATION = "//div[@class='fare-avail']/div/a[contains(@data-rel,'%s')]";
	private String[] subStr = null;
	private String temp = "", delimeter = "", classKind = "", date = "", time = "";
	
	public TicketInfoPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		Assert.assertTrue(isPresent(By.xpath(BASE_ELEMENT1)));
		Assert.assertTrue(isPresent(By.xpath(BASE_ELEMENT2)));
    	Log.getLogInfo("Ticket info page was appear");
	}
	
	public void ticketInfoCollection() {
		WebElement depatureDate = findOneElement(By.xpath(DEPATURE_DATE));
		date = depatureDate.getText();
		WebElement depatureTime = findOneElement(By.xpath(DEPATURE_TIME));
		time = depatureTime.getText();
		Log.getLogInfo(String.format("Depature date = %s, depature time = %s", date, time));
		List<WebElement> listOfClasses = findListOfElements(By.xpath(LIST_OF_CLASSES));
        System.out.println(listOfClasses.size());
        for(int i = 0; i < listOfClasses.size(); i++) {
            WebElement chooseClass = findOneElement(By.xpath(String.format("(%s)[%d]",LIST_OF_CLASSES,i+1)));
            temp = chooseClass.getAttribute("for");
            delimeter = "-";
            subStr = temp.split(delimeter);
            WebElement className = findOneElement(By.xpath(String.format(CLASS_ABBREVIATION,subStr[1])));
            classKind = className.getText();
            chooseClass.click();
            needSleep(1000);
            WebElement totalAmount = findOneElement(By.xpath(TOTAL_AMOUNT));
            String ticketPrice = totalAmount.getText();
            Log.getLogInfo(String.format("Class %d - %s, ticket price - %s", i+1, classKind,ticketPrice));
        }
        driver.navigate().back();
	}

}
