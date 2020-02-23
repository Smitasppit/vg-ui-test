package com.ui.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompareFundsPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@id='addButton0']")
    public WebElement addFundButton;
    @FindBy(xpath = "//button[@id='compareFundBtn']")
    public WebElement compareFundButton;

    @FindBy(xpath = "//*[@id=\"vanguard_tab\"]/div/table/tbody/tr[3]/td[1]/input")
    public WebElement fund1;
    @FindBy(xpath = "//*[@id=\"vanguard_tab\"]/div/table/tbody/tr[4]/td[1]/input")
    public WebElement fund2;
    @FindBy(xpath = "//*[@id=\"vanguard_tab\"]/div/table/tbody/tr[5]/td[1]/input")
    public WebElement fund3;
    @FindBy(xpath = "//*[@id=\"vanguard_tab\"]/div/table/tbody/tr[6]/td[1]/input")
    public WebElement fund4;

    @FindBy(xpath = "//*[@id=\"fcImage\"]/td/h2")
    public WebElement compareFundsHeadingText;

    @FindBy(xpath = " //*[@id=\"errorMessage\"]")
    public WebElement compareFundsErrorText;

    public CompareFundsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifyComparePageTitle(){
        return driver.getTitle();
    }

}
