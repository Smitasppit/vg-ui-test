package com.ui.tests;

import com.ui.core.DriverProvider;
import com.ui.pages.CompareFundsPage;
import com.ui.pages.HomePage;
import com.ui.utils.Helper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class VgCompareFundsTest {
    private Logger logger = Logger.getLogger(VgCompareFundsTest.class);


    HomePage homePage;
    CompareFundsPage compareFundsPage;
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= DriverProvider.getDriver();
        String baseurl = DriverProvider.getBaseurl();
        driver.get(baseurl);

    }

    @Test
    void compareFundsTest() {

            homePage = new HomePage(driver);
            compareFundsPage = new CompareFundsPage(driver);

            homePage.verifyHomePageTitle();
            logger.info("Click on Individual and SMSF investors link");
            homePage.clickOnIndividualAndSMSFLink();
            Helper.waitUntilPageStopsLoading(driver,50, By.xpath("//a[contains(text(),'Fund compare')]"));
            logger.info("Click on Fund Compare link");
            homePage.clickOnFundCompareLink();

            ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs_windows.get(1));
            Helper.waitUntilPageStopsLoading(driver,50, By.xpath("//*[@id=\"addButton0\"]"));
            logger.info("Click on Add Fund Button");
            compareFundsPage.addFundButton.click();
            compareFundsPage.verifyComparePageTitle();

            Helper.waitUntilPageStopsLoading(driver,50, By.xpath("//*[@id=\"addFund\"]"));
            logger.info("Select top 4 products to compare");
            compareFundsPage.fund1.click();
            compareFundsPage.fund2.click();
            compareFundsPage.fund3.click();
            compareFundsPage.fund4.click();
            Helper.waitUntilPageStopsLoading(driver,50, By.xpath("//*[@id=\"compareFundBtn\"]"));
            logger.info("Click on Compare Fund Button");
            compareFundsPage.compareFundButton.click();
            Helper.waitUntilPageStopsLoading(driver,50, By.xpath(" //*[@id=\"compareTableResults\"]"));
            assertEquals(compareFundsPage.compareFundsHeadingText.getText(),"Compare products");
            assertEquals(compareFundsPage.compareFundsErrorText.getText(),"The funds you chose fall into different investing categories. Comparing funds from different categories may not provide complete or accurate results.");

    }

    @AfterMethod
    public void closeDriver() {
        if (DriverProvider.getDriver() != null) {
            DriverProvider.closeDriver();
        }
    }
}
