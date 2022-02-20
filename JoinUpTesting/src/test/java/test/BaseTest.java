package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.FindTourPage;
import page.HomePage;

public abstract class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected FindTourPage findTourPage;

    @BeforeMethod(alwaysRun = true)
    public void init(){
        driver = DriverSingleton.getDriver();
        homePage = new HomePage(driver);
        findTourPage = new FindTourPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void close(){
        DriverSingleton.closeBrowser();
    }
}
