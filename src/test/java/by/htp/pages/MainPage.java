package by.htp.pages;

import static by.htp.utils.PropertyManager.getProperty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import by.htp.utils.Log;

public class MainPage extends BasePage{
	private static final String BASE_URL = getProperty("main.page.url");
	private static final String MAIN_LOGO = "//div[@class='logo']//img";
	
	
	public MainPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		Assert.assertTrue(isPresent(driver, By.xpath(MAIN_LOGO)));
		Log.getLogInfo("Main page was appear");
	}
	
	public void searchTicket() {
        
	}

}
