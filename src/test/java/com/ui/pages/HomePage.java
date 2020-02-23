package com.ui.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    private WebDriver driver;
    private String Baseurl;

    @FindBy(xpath = "//a[contains(text(),'Individual & SMSF investors')]")
    private WebElement individualSmsfLink ;

    @FindBy(xpath = "//a[contains(text(),'Fund compare')]")
    public WebElement fundcomparelink ;



    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String verifyHomePageTitle(){
        return driver.getTitle();
    }


    public void clickOnIndividualAndSMSFLink(){

        individualSmsfLink.click();
    }

    public void clickOnFundCompareLink(){

        fundcomparelink.click();
    }


}
