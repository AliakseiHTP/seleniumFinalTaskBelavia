package by.htp.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import by.htp.utils.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	WebDriver driver;

	public abstract void openPage();

	BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	boolean isPresent(By by) {
        try {
            return driver.findElements(by).size() > 0;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    WebElement findOneElement(By by) {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

	void typeTextInTbx(Elements.ElementsEnum selTxb, String someText){
		Elements.getElement(driver, selTxb, someText);
    }

    void chooseKindOfTicket(Elements.ElementsEnum selCheckBox){
        Elements.chooseKindOfTicket(driver, selCheckBox);
    }
	
	void clickOnDropdownElement(Elements.ElementsEnum selBtn){
		Elements.getStrongElement(driver, selBtn);
    }
	
	static void needSleep(int iTime) throws InterruptedException {
        Thread.sleep(iTime);
        Log.getLogInfo(String.format("waiting %d millis", iTime));
    }

    void moveMouseOn(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

	void clickOnElementJE(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		Log.getLogInfo("Clicking using JavascriptExecutor");
	}
}
