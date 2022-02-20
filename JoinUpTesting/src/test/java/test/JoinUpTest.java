package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.FindTourPage;
import utils.RandomData;

import java.nio.charset.StandardCharsets;

public class JoinUpTest extends BaseTest {
    @Test
    public void findTourToRandomCountry() {
        homePage.openPage()
                .acceptCookie()
                .openFindTourPage();
        findTourPage.waitForOpenPage(FindTourPage.HEADER);
        boolean isFoundResults = findTourPage.chooseCountryTo(RandomData.getRandomInt())
                .clickFindButton()
                .isPageContainsResult();
        Assert.assertTrue(isFoundResults);
    }

    @Test
    public void findVeryCheapTour(){
        homePage.openPage()
                .acceptCookie()
                .openFindTourPage();
        findTourPage.waitForOpenPage(FindTourPage.HEADER);
        boolean isFoundResults = findTourPage.chooseCountryTo(RandomData.getRandomInt())
                .fillMaxPrice(RandomData.getRandomInt())
                .clickFindButton()
                .isPageContainsResult();
        Assert.assertFalse(isFoundResults);
    }

    @Test
    public void findTourByPrice() {
        int maxPrice = 10000;
        homePage.openPage()
                .acceptCookie()
                .openFindTourPage();
        findTourPage.waitForOpenPage(FindTourPage.HEADER);
        boolean isFoundResults = findTourPage.chooseCountryTo(RandomData.getRandomInt())
                .fillMaxPrice(maxPrice)
                .clickFindButton()
                .isPageContainsResult();
        Assert.assertTrue(isFoundResults);
    }

    @Test
    public void findVeryExpensiveTour(){
        int minPrice = 10000000;
        homePage.openPage()
                .acceptCookie()
                .openFindTourPage();
        findTourPage.waitForOpenPage(FindTourPage.HEADER);
        boolean isFoundResults = findTourPage.chooseCountryTo(RandomData.getRandomInt())
                .fillMinPrice(minPrice)
                .clickFindButton()
                .isPageContainsResult();
        Assert.assertFalse(isFoundResults);
    }
}
