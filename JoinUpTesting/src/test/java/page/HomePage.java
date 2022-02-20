package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public class HomePage extends BasePage{

    private static final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://joinup.by/";
    public static final By FIND_TOUR_BUTTON = By.xpath("//li[@class=\"btn-search-tour\"]/a");
    public static final By ACCEPT_COOKIE = By.xpath("//*[@id=\"scnb-cookie-accept\"]");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage openPage(){
        driver.get(PAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public void openFindTourPage(){
        buttonClick(FIND_TOUR_BUTTON);
    }

    public HomePage acceptCookie(){
        buttonClick(ACCEPT_COOKIE);
        return this;
    }
}
