package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Waits;

public class FindTourPage extends BasePage{

    public static final By HEADER = By.xpath("//div[@id=\"gre-form_search_tour\"]");
    private static final By COUNTRY_CHOICE = By.xpath("//select[@id=\"country_to\"]");
    private static final By SEARCH_BUTTON = By.xpath("//input[@id=\"hotelpriceshow\"]");
    private static final By TOUR_RESULT = By.xpath("//li[@class=\"box\"]");
    private static final By MIN_PRICE = By.xpath("//*[@id=\"price_min\"]/input");
    private static final By MAX_PRICE = By.xpath("//*[@id=\"price_max\"]/input");
    private static final By CURRENCY_SELECT = By.xpath("//select[@id=\"currency\"]");
    private static final By TOUR_CURRENCY = By.xpath("//p[@class=\"price_search_tours\"]/small");

    public FindTourPage(WebDriver driver) {
        super(driver);
    }

    public FindTourPage chooseCountryTo(int stringCode){
        Select select = new Select(Waits.getWebElementUntilWait(driver, COUNTRY_CHOICE));
        select.selectByIndex(stringCode);
        return this;
    }

    public String getCurrentCurrency(){
        return getTextFromElement(TOUR_CURRENCY);
    }

    public boolean isPageContainsResult(){
        try{
            Waits.getWebElementUntilWait(driver, TOUR_RESULT);
            return true;
        }
        catch (TimeoutException ex){
            return false;
        }
    }

    public FindTourPage fillMinPrice(int price){
        fillInput(MIN_PRICE, String.valueOf(price));
        return this;
    }

    public FindTourPage fillMaxPrice(int price){
        fillInput(MAX_PRICE, String.valueOf(price));
        return this;
    }

    public FindTourPage clickFindButton(){
        buttonClick(SEARCH_BUTTON);
        buttonClick(SEARCH_BUTTON);
        return this;
    }
}
