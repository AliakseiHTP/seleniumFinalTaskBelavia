package by.htp.pages;

import static by.htp.utils.PropertyManager.getProperty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {
	private static final String UNIQUE_ID = "//*[@id='%s']";
	private static final String STRONG_TEXT = "//strong[contains(text(),'%s')]";
	private static final String KIND_OF_TICKET = "//*[@id='%s']/../label[@for='%s']";

	public enum ElementsEnum {
		ORIGIN_LOCATION, DESTINATION_LOCATION, CITY_FROM, CITY_TO, ONE_WAY, ROUND_TRIP;
		private String ELEMENT;

		ElementsEnum() {
			this.ELEMENT = getProperty(this.toString());
		}

		private String getELEMENT() {
			return ELEMENT;
		}
	}

	static void getElement(WebDriver driver, ElementsEnum selElement, String someText) {
		WebElement someTbx = driver.findElement(By.xpath(String.format(UNIQUE_ID, selElement.getELEMENT())));
		someTbx.sendKeys(someText);
	}

	static void getElement(WebDriver driver, ElementsEnum selElement) {
		WebElement someBtn = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(String.format(UNIQUE_ID, selElement.getELEMENT()))));
		someBtn.click();
	}

	static void chooseKindOfTicket(WebDriver driver, ElementsEnum selElement) {
		WebElement someBtn = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(String.format(KIND_OF_TICKET, selElement.getELEMENT(), selElement.getELEMENT()))));
		someBtn.click();
	}

	static void getStrongElement(WebDriver driver, ElementsEnum selElement) {
		WebElement someBtn = driver.findElement(By.xpath(String.format(STRONG_TEXT, selElement.getELEMENT())));
		someBtn.click();
	}
}