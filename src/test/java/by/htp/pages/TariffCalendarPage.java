package by.htp.pages;

import by.htp.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TariffCalendarPage extends BasePage {
    private static final String BASE_ELEMENT = "//div[@id='calendar']/h1[contains(text(),'Календарь тарифов')]";
    private static final String LIST_OF_TICKETS = "//input[@name='date']";

    public TariffCalendarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        //Assert.assertTrue(isPresent(By.xpath(BASE_ELEMENT)));
        Log.getLogInfo("Tariff Calendar was appear");
    }

    public void chooseVariantOfTicket() {
        List<WebElement> listOfTickets = findListOfElements(By.xpath(LIST_OF_TICKETS));
        System.out.println(listOfTickets.size());
        for(int i = 0; i < listOfTickets.size(); i++) {
            WebElement chooseTicket = findOneElement(By.xpath(String.format("(%s)[%d]",LIST_OF_TICKETS,i+1)));
            chooseTicket.click();
        }
    }
}