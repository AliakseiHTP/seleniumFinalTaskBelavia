package by.htp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {
	protected WebDriver driver;

	public abstract void openPage();

	BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	static boolean isPresent(WebDriver driver, By by) {
        return driver.findElements(by).size() > 0; //.xpath(xpath)
    }
	
	public void moveMouseOn(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
