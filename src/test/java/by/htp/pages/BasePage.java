package by.htp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import by.htp.utils.Log;

public abstract class BasePage {
	protected WebDriver driver;

	public abstract void openPage();

	BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	boolean isPresent(By by) {
        return driver.findElements(by).size() > 0;
    }
	
	public void moveMouseOn(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
	
	public void typeTextInTbx(Elements.ElementsEnum selTxb, String someText){
		Elements.getElement(driver, selTxb, someText);
    }
	
	public void clickOnDropdownElement(Elements.ElementsEnum selBtn){
		Elements.getStrongElement(driver, selBtn);
    }
	
	public static void needSleep(int iTime) throws InterruptedException {
        Thread.sleep(iTime);
        Log.getLogInfo(String.format("waiting %d millis", iTime));
    }
}
