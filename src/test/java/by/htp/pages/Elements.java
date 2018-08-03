package by.htp.pages;

import static by.htp.utils.PropertyManager.getProperty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {
	public static final String UNIQUE_ID = "//*[@id='%s']";
	public static final String STRONG_TEXT = "//strong[contains(text(),'%s')]";
	
	public enum ElementsEnum {
        ORIGIN_LOCATION, DESTINATION_LOCATION, CITY_FROM, CITY_TO;
        private String ELEMENT;

        ElementsEnum() {
            this.ELEMENT = getProperty(this.toString());
        }

        private String getELEMENT(){
            return ELEMENT;
        }
    }
	
	static void getElement(WebDriver driver, ElementsEnum selElement, String someText){
        WebElement someTbx = driver.findElement(By.xpath(String.format(UNIQUE_ID,
        		selElement.getELEMENT())));
        someTbx.sendKeys(someText);
    }
	
	static void getElement(WebDriver driver, ElementsEnum selElement){
        WebElement someBtn = driver.findElement(By.xpath(String.format(UNIQUE_ID,
        		selElement.getELEMENT())));
        someBtn.click();
    }
	
	static void getStrongElement(WebDriver driver, ElementsEnum selElement){
        WebElement someBtn = driver.findElement(By.xpath(String.format(STRONG_TEXT,
        		selElement.getELEMENT())));
        someBtn.click();
    }
}
