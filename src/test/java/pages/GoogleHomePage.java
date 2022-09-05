package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class GoogleHomePage {

    public GoogleHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@title='Search']")
    public WebElement searchBox;

    @FindBy (xpath = "//input[@aria-label='Google Search']")
    public WebElement searchButton;

    @FindBy (xpath = "//body/div[1]/div[5]/div[1]/div[3]/a[1]")
    public WebElement privacyButton;

    @FindBy (xpath="//header/div[3]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    public WebElement privacyPolicyTab;

    @FindBy (xpath = "//div[@id='result-stats']")
    public WebElement resultsStatement;

    @FindBy (xpath = "//body/div[@id='main']/div[@id='cnt']/div[@id='rcnt']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
    public WebElement yourSearchDidNotMatchMessage;

    @FindBy (xpath = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/div[1]")
    public WebElement buttonContent;

    @FindBy (xpath = "//input[@id='gbqfbb']")
    public WebElement ImFeelingLuckyButton;
}
